package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import business.BDServices;
import ui.CadastroCadastroPet.LengthLimitFilter;
import ui.entities.Produtos;
import ui.entities.Tutores;

import java.awt.Color;

public class AtualizacaoAtualizarCadastroProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	public static ProdutosAdiçãoProduto adicaoProdutos1 = new ProdutosAdiçãoProduto();

	/**
	 * Create the panel.
	 */
	public AtualizacaoAtualizarCadastroProduto(Produtos produto) {
		MaskFormatter valorProduto = null;
		try {
			valorProduto = new MaskFormatter("###.##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		setLayout(null);
		JPanel panel = new JPanel();
		setBackground(new Color(222, 222, 222));
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setBackground(new Color(159, 80, 0));
		btnAtualizar.setBounds(436, 237, 167, 23);
		panel.add(btnAtualizar);

		JButton btnCancelar = new JButton("<-    Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(159, 80, 0));
		btnCancelar.setBounds(282, 237, 125, 23);
		panel.add(btnCancelar);

		JLabel lblTitle = new JLabel("Adição de Produtos");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(313, 17, 218, 39);
		panel.add(lblTitle);

		JLabel lblTypeOfProduct = new JLabel("Tipo de Produto: ");
		lblTypeOfProduct.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTypeOfProduct.setBounds(257, 70, 111, 14);
		panel.add(lblTypeOfProduct);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Consulta", "Exame", "Cirurgia", "Vacina" }));
		comboBox.setBounds(394, 67, 167, 22);
		panel.add(comboBox);
		if (produto.getTipo().charAt(0) == 'C' && produto.getTipo().charAt(1) == 'O') {
			comboBox.setSelectedItem("Consulta");
		} else if (produto.getTipo().charAt(0) == 'E') {
			comboBox.setSelectedItem("Exame");
		} else if (produto.getTipo().charAt(0) == 'V') {
			comboBox.setSelectedItem("Vacina");
		} else {
			comboBox.setSelectedItem("Cirurgia");
		}
		JLabel lblProductName = new JLabel("Nome do Produto:");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProductName.setBounds(252, 102, 102, 14);
		panel.add(lblProductName);

		JLabel lblQuantity = new JLabel("Quantidade: ");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantity.setBounds(281, 136, 71, 14);
		panel.add(lblQuantity);

		JLabel lblNewLabel = new JLabel("Valor unitário:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(282, 167, 102, 14);
		panel.add(lblNewLabel);

		JFormattedTextField txtProductName = new JFormattedTextField();
		txtProductName.setBounds(394, 100, 156, 20);
		// Adiciona o filtro para permitir apenas letras (maiúsculas e minúsculas)
		((AbstractDocument) txtProductName.getDocument()).setDocumentFilter(new FiltroApenasLetras());
		panel.add(txtProductName);
		txtProductName.setText(produto.getNome());

		JFormattedTextField txtQuantity = new JFormattedTextField();
		txtQuantity.setBounds(394, 134, 28, 20);
		panel.add(txtQuantity);
		txtQuantity.setText(String.valueOf(produto.getQuantidade()));

		JFormattedTextField txtValorUnitario = new JFormattedTextField(valorProduto);
		txtValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtValorUnitario.setBounds(394, 165, 71, 20);
		panel.add(txtValorUnitario);
		txtValorUnitario.setText(String.valueOf(produto.getValor()));

		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipoProduto = String.valueOf(comboBox.getSelectedItem()).toUpperCase();
				String nomeProduto = String.valueOf(txtProductName.getText());
				int quantidadeProduto = Integer.parseInt(txtQuantity.getText());
				double valorUnitarioProduto = Double.parseDouble(txtValorUnitario.getText());
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja confirmar a atualização dos dados?",
						"Confirmar Atualização", JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {
					BDServices.atualizarProduto(produto.getId(), tipoProduto, nomeProduto, quantidadeProduto,
							valorUnitarioProduto);
					JOptionPane.showMessageDialog(panel, "Adicionado com sucesso!");
					JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
					Produtos produtoAtualizado = BDServices.consultarProduto(produto.getId());
					f.setContentPane(new ProdutosDadosProdutos(produtoAtualizado));
					f.revalidate();
				}

			}

		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ProdutosPesquisaProduto());
				f.revalidate();
			}

		});
	}

	// Filtro para permitir apenas letras (maiúsculas e minúsculas)
	class FiltroApenasLetras extends DocumentFilter {
		@Override
		public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr)
				throws BadLocationException {
			if (string != null && string.matches("[a-zA-Z]+")) { // Apenas letras maiúsculas ou minúsculas
				super.insertString(fb, offset, string, attr);
			}
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs)
				throws BadLocationException {
			if (text != null && text.matches("[a-zA-Z]+")) { // Apenas letras maiúsculas ou minúsculas
				super.replace(fb, offset, length, text, attrs);
			}
		}
	}
}
