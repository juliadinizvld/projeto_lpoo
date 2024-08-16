package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CadastroPet extends JPanel {

	private static final long serialVersionUID = 1L;
	public static CadastroPet telaCadastro1 = new CadastroPet();
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public CadastroPet() {
		setLayout(null);
		// Cria um painel principal com um layout de BorderLayout
		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 700, 500);
		add(panel);
		panel.setLayout(null);

		// Cria o título
		JLabel titleLabel = new JLabel("Dados do Animal:", JLabel.CENTER);
		titleLabel.setBounds(-24, 10, 800, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		titleLabel.setPreferredSize(new Dimension(800, 50)); // Define o tamanho do título

		// Adiciona o título ao painel principal
		panel.add(titleLabel);
		
		textField = new JTextField();
		textField.setBounds(282, 74, 242, 26);
		textField.setColumns(10);
		panel.add(textField);

		JLabel lblNewLabel = new JLabel("Nome do animal:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel.setBounds(185, 74, 100, 24);
		panel.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(225, 161, 273, 26);
		panel.add(textField_1);

		JLabel lblNewLabel_1 = new JLabel("Espécie:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1.setBounds(185, 118, 49, 24);
		panel.add(lblNewLabel_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cachorro\r\n");
		rdbtnNewRadioButton.setBounds(240, 120, 79, 21);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Gato");
		rdbtnNewRadioButton_1.setBounds(321, 120, 58, 21);
		panel.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Outro");
		rdbtnNewRadioButton_2.setBounds(381, 120, 103, 21);
		panel.add(rdbtnNewRadioButton_2);

		JLabel lblNewLabel_1_1 = new JLabel("Raça:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(185, 161, 49, 24);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Data de Nascimento: ");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1.setBounds(185, 205, 108, 24);
		panel.add(lblNewLabel_1_1_1);

		textField_2 = new JTextField();
		textField_2.setText("        /        /");
		textField_2.setColumns(10);
		textField_2.setBounds(296, 205, 103, 26);
		panel.add(textField_2);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sexo:");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1_1.setBounds(185, 255, 49, 24);
		panel.add(lblNewLabel_1_1_1_1);

		JRadioButton rdbtnFmea = new JRadioButton("Fêmea");
		rdbtnFmea.setBounds(219, 257, 66, 21);
		panel.add(rdbtnFmea);

		JRadioButton rdbtnFmea_1 = new JRadioButton("Macho");
		rdbtnFmea_1.setBounds(282, 257, 58, 21);
		panel.add(rdbtnFmea_1);

		JRadioButton rdbtnNoIdentificado = new JRadioButton("Não identificado");
		rdbtnNoIdentificado.setBounds(347, 257, 126, 21);
		panel.add(rdbtnNoIdentificado);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Peso(kg):");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1_1_1.setBounds(185, 299, 49, 24);
		panel.add(lblNewLabel_1_1_1_1_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(250, 299, 100, 26);
		panel.add(textField_3);

		JLabel lblNewLabel_1_1_2 = new JLabel("Alergia(s):");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_2.setBounds(185, 351, 58, 24);
		panel.add(lblNewLabel_1_1_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(251, 351, 273, 26);
		panel.add(textField_4);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Vacinas:");
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_2_1.setBounds(185, 398, 58, 24);
		panel.add(lblNewLabel_1_1_2_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(251, 398, 273, 26);
		panel.add(textField_5);

		JButton btnNewButton = new JButton("Avançar ");
		btnNewButton.setBounds(416, 454, 108, 35);
		panel.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(CadastroTutor.telaCadastro2);
				f.revalidate();
			}
		});
		
		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.setBounds(262, 454, 108, 35);
		panel.add(btnRetornar);

		btnRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(TelaInicial.telaInicial);
				f.revalidate();
			}
		});

		setVisible(true);
	}
}
