package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class FuncionariosNovoFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionariosNovoFuncionario frame = new FuncionariosNovoFuncionario();
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
	public FuncionariosNovoFuncionario() {
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
		
		JLabel lblNewLabel = new JLabel("Novo funcionário");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(216, 10, 253, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do funcionário:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(137, 90, 208, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Idade:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(137, 131, 128, 20);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Função:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(137, 172, 128, 20);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Especialidade:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(137, 216, 128, 20);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("RMV:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(137, 258, 128, 20);
		panel.add(lblNewLabel_1_4);
		
		JButton btnNewButton = new JButton("← Retornar");
		btnNewButton.setBounds(280, 365, 120, 21);
		panel.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(203, 131, 62, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(208, 172, 245, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(249, 213, 260, 25);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(203, 255, 167, 25);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(306, 90, 278, 22);
		panel.add(textField);
		textField.setColumns(10);
	}
}
