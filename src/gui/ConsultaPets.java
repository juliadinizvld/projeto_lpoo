package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ConsultaPets extends JFrame {

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
					ConsultaPets frame = new ConsultaPets();
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
	public ConsultaPets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton(" <- Retornar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(222, 206, 125, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(288, 117, 241, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID do PET ou CPF do tutor");
		lblNewLabel.setBounds(121, 120, 157, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Consulta PET");
		lblNewLabel_1.setBounds(378, 23, 151, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(483, 206, 119, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pets encontrados no CPF Informado");
		lblNewLabel_2.setBounds(330, 262, 187, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bob", "Luna", "Ralph", "Amora"}));
		comboBox.setBounds(343, 300, 164, 22);
		contentPane.add(comboBox);
		
		JList list = new JList();
		list.setBounds(64, 224, 58, 0);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(197, 167, 1, 1);
		contentPane.add(list_1);
		
		JButton btnNewButton_2 = new JButton("Verificar Ficha");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(359, 372, 125, 23);
		contentPane.add(btnNewButton_2);
	}
}
