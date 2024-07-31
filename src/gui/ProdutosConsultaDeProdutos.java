package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;

public class ProdutosConsultaDeProdutos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNomeDoProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosConsultaDeProdutos frame = new ProdutosConsultaDeProdutos();
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
	public ProdutosConsultaDeProdutos() {
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
		
		JLabel tituloConsultaDeProdutos = new JLabel("Consulta de produtos");
		tituloConsultaDeProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloConsultaDeProdutos.setBounds(250, 11, 195, 31);
		panel.add(tituloConsultaDeProdutos);
		
		JLabel textoNomeDoProduto = new JLabel("Nome do produto:");
		textoNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoNomeDoProduto.setBounds(184, 90, 115, 19);
		panel.add(textoNomeDoProduto);
		
		campoNomeDoProduto = new JTextField();
		campoNomeDoProduto.setBounds(309, 91, 201, 20);
		panel.add(campoNomeDoProduto);
		campoNomeDoProduto.setColumns(10);
		
		JLabel tituloProdutosEncontrados = new JLabel("Produtos encontrados:");
		tituloProdutosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloProdutosEncontrados.setBounds(250, 133, 201, 31);
		panel.add(tituloProdutosEncontrados);
		
		JList listaProdutosEncontrados = new JList();
		listaProdutosEncontrados.setBounds(210, 194, 300, 177);
		panel.add(listaProdutosEncontrados);
		
		JButton botaoRetornar = new JButton("← Retonar");
		botaoRetornar.setBounds(210, 410, 130, 23);
		panel.add(botaoRetornar);
		
		JButton botaoRealizarPedido = new JButton("Realizar pedido");
		botaoRealizarPedido.setBounds(373, 410, 137, 23);
		panel.add(botaoRealizarPedido);
	}
}
