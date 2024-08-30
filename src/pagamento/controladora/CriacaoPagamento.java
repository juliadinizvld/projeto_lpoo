package pagamento.controladora;

import com.google.gson.Gson;
import pagamento.entidades.Constantes;
import pagamento.entidades.PedidoPagamento;
import pagamento.entidades.RespostaPagamento;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CriacaoPagamento {

	public enum TipoEntidade {
		PRODUTO, CONSULTA, EXAME
	}

	public static void main(String[] args) {
		CriacaoPagamento criacaoPagamento = new CriacaoPagamento();

	}

	public String criarPagamento(String idEntidade, String nomeEntidade,
			double precoEntidade) {
		try {
			// Cria o item de pagamento
			PedidoPagamento.Item item = new PedidoPagamento.Item();
			item.setId(Integer.parseInt(idEntidade));
			item.setTitle(nomeEntidade);
			item.setCurrency_id("BRL");
			item.setQuantity(1);
			item.setUnit_price(precoEntidade);

			// Cria o pedido de pagamento e adiciona o item
			PedidoPagamento pagamento = new PedidoPagamento();
			List<PedidoPagamento.Item> items = new ArrayList<>();
			items.add(item);
			pagamento.setItems(items);

			// Converte o pedido para JSON
			Gson gson = new Gson();
			String corpoRequisicao = gson.toJson(pagamento);

			// Cria a requisição HTTP para o Mercado Pago
			HttpRequest criacaoPagamentoRequisicao = HttpRequest.newBuilder()
					.uri(new URI("https://api.mercadopago.com/checkout/preferences"))
					.header("Authorization", "Bearer " + Constantes.Chave_acesso)
					.POST(HttpRequest.BodyPublishers.ofString(corpoRequisicao)).build();

			// Envia a requisição e obtém a resposta
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpResponse<String> criacaoPagamentoResposta = httpClient.send(criacaoPagamentoRequisicao,
					HttpResponse.BodyHandlers.ofString());

			// Converte a resposta para o objeto RespostaPagamento
			RespostaPagamento criacaoPagamento = gson.fromJson(criacaoPagamentoResposta.body(),
					RespostaPagamento.class);

			// Retorna o link de redirecionamento (sandbox ou produção)
			return criacaoPagamento.getSandbox_init_point(); //
			
		} catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
