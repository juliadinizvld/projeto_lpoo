package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JButton;

public class consultaPetTela2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultaPetTela2 frame = new consultaPetTela2();
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
	public consultaPetTela2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Consulta dia 03/02/2024");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tutor:");
		lblNewLabel.setBounds(296, 10, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF do tutor:");
		lblNewLabel_1.setBounds(256, 26, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(348, 8, 86, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(348, 23, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dados do PET");
		lblNewLabel_2.setBounds(143, -3, 103, 41);
		contentPane.add(lblNewLabel_2);
		
		table = new JTable();
		table.setBounds(149, 109, 1, 1);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(271, 147, 1, 1);
		contentPane.add(table_1);
		
		table_2 = new JTable();
		table_2.setBounds(197, 109, 1, 1);
		contentPane.add(table_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(64, 43, 86, 14);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID ");
		lblNewLabel_3.setBounds(8, 43, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nome");
		lblNewLabel_4.setBounds(8, 59, 33, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Espécie");
		lblNewLabel_5.setBounds(8, 79, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Raça");
		lblNewLabel_6.setBounds(8, 96, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Idade");
		lblNewLabel_8.setBounds(8, 128, 46, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Sexo");
		lblNewLabel_9.setBounds(8, 147, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		textField_3 = new JTextField();
		textField_3.setBounds(64, 59, 86, 14);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(64, 79, 86, 14);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Peso");
		lblNewLabel_10.setBounds(8, 165, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Vacinas");
		lblNewLabel_11.setBounds(8, 184, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(64, 115, 86, 14);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(64, 96, 86, 14);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(64, 131, 86, 14);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(64, 184, 86, 14);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(64, 165, 86, 14);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(64, 147, 86, 14);
		contentPane.add(textField_10);
		
		JLabel lblNewLabel_12 = new JLabel("Lista de Consultas ");
		lblNewLabel_12.setBounds(278, 59, 108, 14);
		contentPane.add(lblNewLabel_12);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Consulta: 07/04/2024", "Consulta: 08/06/2024"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setBounds(256, 78, 147, 96);
		contentPane.add(list_1);
		
		JButton btnNewButton = new JButton("Verificar Consulta");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(263, 180, 140, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agendar consulta");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBounds(64, 227, 134, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Agendar Procedimento");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2.setBounds(222, 227, 147, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("Nascimento");
		lblNewLabel_7.setBounds(8, 109, 55, 27);
		contentPane.add(lblNewLabel_7);
	}
}
