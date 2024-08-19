package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import business.BDServices;
import ui.entities.Produtos;

public class ConsultaProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	public static ConsultaProdutos adicaoProdutos1 = new ConsultaProdutos();

	/**
	 * Create the panel.
	 */
	public ConsultaProdutos() {

		MaskFormatter valorProduto = null;

		try {
			valorProduto = new MaskFormatter("###.##");
		} catch (ParseException e) {
			e.getStackTrace();
		}

		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JButton btnAddProduct = new JButton("Adicionar produto\r\n");
		btnAddProduct.setBounds(436, 237, 167, 23);
		panel.add(btnAddProduct);

		JButton btnReturn = new JButton("<-    Retornar");
		btnReturn.setBounds(282, 237, 125, 23);
		panel.add(btnReturn);

		JLabel lblTitle = new JLabel("Adição de Produtos");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(302, 11, 218, 39);
		panel.add(lblTitle);

		JLabel lblTypeOfProduct = new JLabel("Tipo de Produto:");
		lblTypeOfProduct.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTypeOfProduct.setBounds(263, 70, 102, 14);
		panel.add(lblTypeOfProduct);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Consulta", "Exame", "Cirurgia", "Vacina" }));
		comboBox.setBounds(394, 67, 167, 22);
		panel.add(comboBox);

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
		panel.add(txtProductName);

		JFormattedTextField txtQuantity = new JFormattedTextField();
		txtQuantity.setBounds(394, 134, 28, 20);
		panel.add(txtQuantity);

		JFormattedTextField txtValorUnitario = new JFormattedTextField(valorProduto);
		txtValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtValorUnitario.setBounds(394, 165, 71, 20);
		panel.add(txtValorUnitario);

		btnAddProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeProduto = String.valueOf(comboBox.getSelectedItem()) + " - " + txtProductName.getText();
				int quantidadeProduto = Integer.parseInt(txtQuantity.getText());
				double valorUnitarioProduto = Double.parseDouble(txtValorUnitario.getText());

				Produtos produto = new Produtos(null, nomeProduto, quantidadeProduto, valorUnitarioProduto);
				BDServices.inserirProduto(produto);

			}
		});
	}
}
