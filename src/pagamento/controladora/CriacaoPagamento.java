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

    public static void main(String[] args) {

        PedidoPagamento.Item item1 = new PedidoPagamento.Item();
        item1.setId(1);
        item1.setTitle("Racao 500g");
        item1.setDescription("racao para filhotes");
        item1.setCurrency_id("BRL");
        item1.setQuantity(2);
        item1.setUnit_price(49.90);

        PedidoPagamento pagamento = new PedidoPagamento();
        List<PedidoPagamento.Item> items = new ArrayList<>();
        items.add(item1);
        pagamento.setItems(items);


        Gson gson = new Gson();
        String corpoRequisicao = gson.toJson(pagamento);

        HttpRequest criacaoPagamentoRequisicao = null;
		try {
			criacaoPagamentoRequisicao = HttpRequest.newBuilder()
			        .uri(new URI("https://api.mercadopago.com/checkout/preferences"))
			        .header("Authorization", "Bearer " + Constantes.Chave_acesso)
			        .POST(HttpRequest.BodyPublishers.ofString(corpoRequisicao))
			        .build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        HttpClient httpClient = HttpClient.newHttpClient();


        HttpResponse<String> criacaoPagamentoResposta = null;
		try {
			criacaoPagamentoResposta = httpClient.send(criacaoPagamentoRequisicao, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RespostaPagamento criacaoPagamento = gson.fromJson(criacaoPagamentoResposta.body(), RespostaPagamento.class);

        String linkRedirecionamento = criacaoPagamento.getSandbox_init_point();
        System.out.println("Link para redirecionamento: " + linkRedirecionamento);
       
        String resposta = criacaoPagamentoResposta.body();
        int status = criacaoPagamentoResposta.statusCode();
        System.out.println(resposta);
        System.out.println(status);

    }

}