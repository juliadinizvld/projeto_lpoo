package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import business.BDServices;
import data.BD;
import ui.entities.Produtos;

import java.awt.Color;

public class ProdutosConsultaProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNomeDoProduto;

	public ProdutosConsultaProduto() {
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 222, 222));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;

		JLabel tituloConsultaDeProdutos = new JLabel("Consulta de produtos", SwingConstants.CENTER);
		tituloConsultaDeProdutos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(tituloConsultaDeProdutos, gbc);

		gbc.gridy++;
		gbc.gridwidth = 1;
		JLabel textoNomeDoProduto = new JLabel("Nome do produto:");
		textoNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(textoNomeDoProduto, gbc);

		gbc.gridx++;
		campoNomeDoProduto = new JTextField(20);
		// Configuração do filtro de limite de caracteres
		AbstractDocument document = (AbstractDocument) campoNomeDoProduto.getDocument();
		document.setDocumentFilter(new LimitDocumentFilter(45)); // Limita a 45 caracteres
		panel.add(campoNomeDoProduto, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		JButton botaoVerificarProduto = new JButton("Verificar Produto");
		botaoVerificarProduto.setForeground(Color.WHITE);
		botaoVerificarProduto.setBackground(new Color(159, 80, 0));
		panel.add(botaoVerificarProduto, gbc);

		gbc.gridy++;
		JLabel tituloProdutosEncontrados = new JLabel("Produtos encontrados:", SwingConstants.CENTER);
		tituloProdutosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(tituloProdutosEncontrados, gbc);

		gbc.gridy++;
		JComboBox<String> listaProdutosEncontrados = new JComboBox<>();
		listaProdutosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(listaProdutosEncontrados, gbc);

		gbc.gridy++;
		gbc.gridwidth = 1;
		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setForeground(Color.WHITE);
		botaoRetornar.setBackground(new Color(159, 80, 0));
		panel.add(botaoRetornar, gbc);

		gbc.gridx++;
		JButton botaoRealizarCompra = new JButton("Realizar Compra");
		botaoRealizarCompra.setForeground(Color.WHITE);
		botaoRealizarCompra.setBackground(new Color(159, 80, 0));
		panel.add(botaoRealizarCompra, gbc);

		add(panel, BorderLayout.CENTER);

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
				f.setContentPane(new Home());
				f.revalidate();
			}
		});

		botaoRealizarCompra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaProdutosEncontrados.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null,
							"Por favor, selecione um produto antes de prosseguir com a compra.", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String[] produtoSelecionado = String.valueOf(listaProdutosEncontrados.getSelectedItem()).split("-");
					int idProdutoSelecionado = Integer.parseInt(produtoSelecionado[1].trim());
					Produtos produto = BDServices.consultarProduto(idProdutoSelecionado);
					JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
					f.setContentPane(new ProdutosInformacoesCompraProduto(produto));
					f.revalidate();
				}
			}
		});
	}

	// Classe interna para o filtro de limite de caracteres
	static class LimitDocumentFilter extends DocumentFilter {
		private final int limit;

		public LimitDocumentFilter(int limit) {
			this.limit = limit;
		}

		@Override
		public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
				throws BadLocationException {
			if (string == null) {
				return;
			}

			if ((fb.getDocument().getLength() + string.length()) <= limit) {
				super.insertString(fb, offset, string, attr);
			}
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs)
				throws BadLocationException {
			if (string == null) {
				return;
			}

			if ((fb.getDocument().getLength() - length + string.length()) <= limit) {
				super.replace(fb, offset, length, string, attrs);
			}
		}
	}
}
