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

		JLabel lblNewLabel = new JLabel("Informações do produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(229, 11, 213, 30);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome do produto: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(129, 80, 137, 30);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Quantidade em estoque: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(128, 117, 200, 30);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Valor unitário: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(129, 158, 107, 30);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Selecione a quantidade desejada: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(129, 199, 240, 30);
		panel.add(lblNewLabel_4);

		JButton btnNewButton = new JButton("← Retornar");
		btnNewButton.setBounds(170, 345, 131, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Fazer pedido");
		btnNewButton_1.setBounds(335, 345, 150, 23);
		panel.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(392, 205, 59, 22);
		panel.add(comboBox);
	}
}
