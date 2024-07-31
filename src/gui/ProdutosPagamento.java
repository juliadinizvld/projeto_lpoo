package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProdutosPagamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosPagamento frame = new ProdutosPagamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProdutosPagamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 700, 500);
		contentPane.add(panel);
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
		
		JLabel textoConclusaoCompra = new JLabel("<html>Para conclusão da compra é necessário realizar o pagamento, o valor total para pagamento é de R$ . Acesse o link abaixo para realização do pagamento: </html>");
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
	}

}
