package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Produto3 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botaoRetornar;

	/**
	 * Create the panel.
	 */
	public Produto3() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 700, 500);
		add(panel);
		panel.setLayout(null);

		JLabel tituloPagamento = new JLabel("Pagamento");
		tituloPagamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloPagamento.setBounds(305, 11, 101, 25);
		panel.add(tituloPagamento);

		JLabel textoNomeDoProduto = new JLabel("Nome do produto: ");
		textoNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeDoProduto.setBounds(168, 100, 322, 25);
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
		textoConclusaoCompra.setBounds(168, 170, 352, 94);
		panel.add(textoConclusaoCompra);

		JLabel linkMercadoPagoApi = new JLabel("Link mercado pago");
		linkMercadoPagoApi.setBounds(293, 278, 89, 14);
		panel.add(linkMercadoPagoApi);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setBounds(168, 344, 117, 23);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Produto2());
				f.revalidate();

			}

		});

	}
}
