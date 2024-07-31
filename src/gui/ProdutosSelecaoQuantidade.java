package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ProdutosSelecaoQuantidade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton botaoRetornar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosSelecaoQuantidade frame = new ProdutosSelecaoQuantidade();
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
	public ProdutosSelecaoQuantidade() {
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

		JLabel tituloInformacoesDoProduto = new JLabel("Informações do produto");
		tituloInformacoesDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloInformacoesDoProduto.setBounds(229, 11, 213, 30);
		panel.add(tituloInformacoesDoProduto);

		JLabel textoNomeDoProduto = new JLabel("Nome do produto: ");
		textoNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeDoProduto.setBounds(129, 80, 137, 30);
		panel.add(textoNomeDoProduto);

		JLabel textoQuantidadeEmEstoque = new JLabel("Quantidade em estoque: ");
		textoQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoQuantidadeEmEstoque.setBounds(128, 117, 200, 30);
		panel.add(textoQuantidadeEmEstoque);

		JLabel textoValorUnitario = new JLabel("Valor unitário: ");
		textoValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoValorUnitario.setBounds(129, 158, 107, 30);
		panel.add(textoValorUnitario);

		JLabel textoQuantidadeDesejada = new JLabel("Selecione a quantidade desejada: ");
		textoQuantidadeDesejada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoQuantidadeDesejada.setBounds(129, 199, 240, 30);
		panel.add(textoQuantidadeDesejada);
		
		JComboBox SelectQuantidadeDesejada = new JComboBox();
		SelectQuantidadeDesejada.setBounds(392, 205, 59, 22);
		panel.add(SelectQuantidadeDesejada);

		botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setBounds(170, 345, 131, 23);
		panel.add(botaoRetornar);

		JButton botaoFazerPedido = new JButton("Fazer pedido");
		botaoFazerPedido.setBounds(335, 345, 150, 23);
		panel.add(botaoFazerPedido);
		

	}
}
