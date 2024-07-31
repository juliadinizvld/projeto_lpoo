package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FuncionariosTelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionariosTelaInicial frame = new FuncionariosTelaInicial();
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
	public FuncionariosTelaInicial() {
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
		
		JLabel lblNewLabel = new JLabel("Funcionários");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(272, 10, 150, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do funcionário: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(120, 83, 205, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Funcionários encontrados:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(214, 142, 267, 40);
		panel.add(lblNewLabel_2);
		
		JList list = new JList();
		list.setBounds(152, 232, 396, 158);
		panel.add(list);
		
		textField = new JTextField();
		textField.setBounds(302, 83, 267, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("← Retornar");
		btnNewButton.setBounds(152, 433, 99, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<html>Adicionar<br>funcionário\r\n</html>");
		btnNewButton_1.setBounds(302, 419, 85, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<html>Verificar <br>funcionário</html>");
		btnNewButton_2.setBounds(463, 419, 85, 40);
		panel.add(btnNewButton_2);
	}
}
