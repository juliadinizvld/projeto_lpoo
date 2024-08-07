package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Produto1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNomeDoProduto;

	/**
	 * Create the panel.
	 */
	public Produto1() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 700, 500);
		add(panel);
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

		JButton botaoVerificarProduto = new JButton("Verificar Produto");
		botaoVerificarProduto.setBounds(274, 120, 137, 23);
		panel.add(botaoVerificarProduto);

		JLabel tituloProdutosEncontrados = new JLabel("Produtos encontrados:");
		tituloProdutosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloProdutosEncontrados.setBounds(244, 169, 201, 31);
		panel.add(tituloProdutosEncontrados);

		JList listaProdutosEncontrados = new JList();
		listaProdutosEncontrados.setBounds(204, 230, 300, 177);
		panel.add(listaProdutosEncontrados);

		JButton botaoRetornar = new JButton("← Retonar");
		botaoRetornar.setBounds(204, 446, 130, 23);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				 * f.setContentPane(new Funcionario2()); f.revalidate();
				 */
			}
		});

		JButton botaoRealizarCompra = new JButton("Realizar Compra");
		botaoRealizarCompra.setBounds(367, 446, 137, 23);
		panel.add(botaoRealizarCompra);

		botaoRealizarCompra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Produto2());
				f.revalidate();
			}
		});

	}
}
