package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ui.entities.Produtos;

public class ProdutosPagamento extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ProdutosPagamento(Produtos produto) {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(-63, -47, 700, 500);
		add(panel);
		panel.setLayout(null);

		JLabel tituloPagamento = new JLabel("Pagamento");
		tituloPagamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloPagamento.setBounds(305, 11, 101, 25);
		panel.add(tituloPagamento);

		JLabel textoNomeDoProduto = new JLabel("Nome do produto: ");
		textoNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeDoProduto.setBounds(168, 98, 322, 25);
		panel.add(textoNomeDoProduto);

		JLabel textoQuantidadeSolicitada = new JLabel("Quantidade solicitada: ");
		textoQuantidadeSolicitada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoQuantidadeSolicitada.setBounds(168, 134, 322, 25);
		panel.add(textoQuantidadeSolicitada);

		JLabel textoConclusaoCompra = new JLabel(
				"<html>Para conclusão da compra é necessário realizar o pagamento, o valor total para pagamento é de R$ . Acesse o link abaixo para realização do pagamento: </html>");
		textoConclusaoCompra.setVerticalAlignment(SwingConstants.TOP);
		textoConclusaoCompra.setHorizontalAlignment(SwingConstants.CENTER);
		textoConclusaoCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoConclusaoCompra.setBounds(178, 170, 352, 94);
		panel.add(textoConclusaoCompra);

		JLabel linkMercadoPagoApi = new JLabel("Link mercado pago");
		linkMercadoPagoApi.setBounds(293, 278, 89, 14);
		panel.add(linkMercadoPagoApi);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setBounds(168, 344, 117, 23);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ProdutosInformacoesCompraProduto(produto));
				f.revalidate();

			}

		});

	}
}
