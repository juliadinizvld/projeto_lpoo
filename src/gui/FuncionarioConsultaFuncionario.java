package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class FuncionarioConsultaFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioConsultaFuncionario frame = new FuncionarioConsultaFuncionario();
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
	public FuncionarioConsultaFuncionario() {
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
		
		JLabel lblNewLabel = new JLabel("Consulta funcionário");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(216, 23, 236, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do funcionário: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(103, 79, 190, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Idade: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(103, 123, 96, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Função: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(103, 162, 78, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Especialidade: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(103, 201, 133, 20);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("RMV: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(103, 244, 96, 20);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("← Retornar");
		btnNewButton.setBounds(264, 306, 122, 21);
		panel.add(btnNewButton);
	}

}
