package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import business.BDServices;
import data.BD;
import ui.entities.Produtos;

import java.awt.Color;

public class ProdutosConsultaProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNomeDoProduto;
	public static ProdutosConsultaProduto produto1 = new ProdutosConsultaProduto();

	/**
	 * Create the panel.
	 */
	public ProdutosConsultaProduto() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 800, 600);
		add(panel);
		panel.setLayout(null);

		JLabel tituloConsultaDeProdutos = new JLabel("Consulta de produtos");
		tituloConsultaDeProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloConsultaDeProdutos.setBounds(267, 27, 195, 31);
		panel.add(tituloConsultaDeProdutos);

		JLabel textoNomeDoProduto = new JLabel("Nome do produto:");
		textoNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoNomeDoProduto.setBounds(218, 88, 115, 19);
		panel.add(textoNomeDoProduto);

		campoNomeDoProduto = new JTextField();
		campoNomeDoProduto.setBounds(343, 89, 201, 20);
		panel.add(campoNomeDoProduto);
		campoNomeDoProduto.setColumns(10);

		JButton botaoVerificarProduto = new JButton("Verificar Produto");
		botaoVerificarProduto.setForeground(new Color(255, 255, 255));
		botaoVerificarProduto.setBackground(new Color(159, 80, 0));
		botaoVerificarProduto.setBounds(316, 122, 137, 43);
		panel.add(botaoVerificarProduto);

		JLabel tituloProdutosEncontrados = new JLabel("Produtos encontrados:");
		tituloProdutosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloProdutosEncontrados.setBounds(303, 176, 201, 31);
		panel.add(tituloProdutosEncontrados);

		JComboBox<String> listaProdutosEncontrados = new JComboBox<>();
		listaProdutosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listaProdutosEncontrados.setBounds(244, 233, 300, 31);
		panel.add(listaProdutosEncontrados);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setBounds(244, 295, 130, 37);
		panel.add(botaoRetornar);

		botaoVerificarProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listaProdutosEncontrados.removeAllItems();
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;
				String nome = campoNomeDoProduto.getText();
				try {
					connection = BD.getConnection();
					st = connection.createStatement();
					rs = st.executeQuery("SELECT * FROM produtos WHERE nome LIKE '%" + nome + "%';");
					while (rs.next()) {
						listaProdutosEncontrados.addItem(rs.getString("nome") + " - " + rs.getInt("id"));
					}
				} catch (SQLException i) {
					i.printStackTrace();
				}

			}
		});

		botaoRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(Home.telaInicial);
				f.revalidate();

			}
		});

		JButton botaoRealizarCompra = new JButton("Realizar Compra");
		botaoRealizarCompra.setForeground(new Color(255, 255, 255));
		botaoRealizarCompra.setBackground(new Color(159, 80, 0));
		botaoRealizarCompra.setBounds(407, 295, 137, 37);
		panel.add(botaoRealizarCompra);

		botaoRealizarCompra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] produtoSelecionado = String.valueOf(listaProdutosEncontrados.getSelectedItem()).split("-");
				int idProdutoSelecionado = Integer.parseInt(produtoSelecionado[1].trim());
				Produtos produto = BDServices.consultarProduto(idProdutoSelecionado);
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ProdutosInformacoesCompraProduto(produto));
				f.revalidate();
			}
		});

	}
}