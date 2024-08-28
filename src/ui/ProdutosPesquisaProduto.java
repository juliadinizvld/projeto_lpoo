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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import business.BDServices;
import data.BD;
import ui.entities.Funcionarios;
import ui.entities.Produtos;

import java.awt.Color;

public class ProdutosPesquisaProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNomeProduto;
	public static ProdutosPesquisaProduto produtosPesquisaProduto = new ProdutosPesquisaProduto();

	/**
	 * Create the panel.
	 */
	public ProdutosPesquisaProduto() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 919, 568);
		add(panel);
		panel.setLayout(null);

		JLabel tituloProdutos = new JLabel("Produtos");
		tituloProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		tituloProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloProdutos.setBounds(320, 11, 150, 25);
		panel.add(tituloProdutos);

		JLabel textoNomeProduto = new JLabel("Nome do Produto: ");
		textoNomeProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeProduto.setBounds(165, 83, 182, 25);
		panel.add(textoNomeProduto);

		campoNomeProduto = new JTextField();
		campoNomeProduto.setBounds(347, 83, 267, 24);
		panel.add(campoNomeProduto);
		campoNomeProduto.setColumns(10);

		JButton botaoPesquisarProduto = new JButton("Pesquisar Produto");
		botaoPesquisarProduto.setForeground(new Color(255, 255, 255));
		botaoPesquisarProduto.setBackground(new Color(159, 80, 0));
		botaoPesquisarProduto.setBounds(299, 133, 171, 23);
		panel.add(botaoPesquisarProduto);

		JLabel textoProdutosEncontrados = new JLabel("Produtos encontrados:");
		textoProdutosEncontrados.setHorizontalAlignment(SwingConstants.CENTER);
		textoProdutosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoProdutosEncontrados.setBounds(254, 167, 267, 40);
		panel.add(textoProdutosEncontrados);

		JComboBox<String> selectResultadoProdutos = new JComboBox<>();
		selectResultadoProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		selectResultadoProdutos.setBounds(298, 218, 203, 21);
		panel.add(selectResultadoProdutos);

		botaoPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectResultadoProdutos.removeAllItems();
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;
				String nome = campoNomeProduto.getText();
				try {
					connection = BD.getConnection();
					st = connection.createStatement();
					rs = st.executeQuery("SELECT * FROM produtos WHERE nome LIKE '%" + nome + "%';");
					while (rs.next()) {
						selectResultadoProdutos.addItem(rs.getString("nome") + " - " + rs.getInt("id"));
					}
				} catch (SQLException i) {
					i.printStackTrace();
				}
			}
		});

		JButton botaoVerificarProduto = new JButton("<html>Verificar <br>produto</html>");
		botaoVerificarProduto.setForeground(new Color(255, 255, 255));
		botaoVerificarProduto.setBackground(new Color(159, 80, 0));
		botaoVerificarProduto.setBounds(320, 251, 150, 40);
		panel.add(botaoVerificarProduto);

		botaoVerificarProduto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String[] produtoSelecionado = String.valueOf(selectResultadoProdutos.getSelectedItem()).split("-");
				int idProdutoSelecionado = Integer.parseInt(produtoSelecionado[1].trim());
				Produtos produto = BDServices.consultarProduto(idProdutoSelecionado);
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ProdutosDadosProdutos(produto));
				f.revalidate();
			}

		});

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setBounds(189, 338, 140, 40);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Home());
				f.revalidate();
			}
		});

		JButton botaoAdicionarProduto = new JButton("Adicionar produto\r\n");
		botaoAdicionarProduto.setForeground(new Color(255, 255, 255));
		botaoAdicionarProduto.setBackground(new Color(159, 80, 0));
		botaoAdicionarProduto.setBounds(398, 338, 140, 40);
		panel.add(botaoAdicionarProduto);

		botaoAdicionarProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ProdutosAdiçãoProduto());
				f.revalidate();
			}

		});

	}
}
