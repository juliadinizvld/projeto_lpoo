
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

public class ConsultaPetsTela1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField caixaInserirIDPet;

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
	public ConsultaPetsTela1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botaoRetornar = new JButton(" <- Retornar");
		botaoRetornar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoRetornar.setBounds(222, 206, 125, 23);
		contentPane.add(botaoRetornar);
		
		caixaInserirIDPet = new JTextField();
		caixaInserirIDPet.setBounds(288, 117, 241, 20);
		contentPane.add(caixaInserirIDPet);
		caixaInserirIDPet.setColumns(10);
		
		JLabel textoIDPet = new JLabel("ID do PET ou CPF do tutor:");
		textoIDPet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textoIDPet.setBounds(121, 120, 157, 14);
		contentPane.add(textoIDPet);
		
		JLabel texConsul = new JLabel("Consulta PET");
		texConsul.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texConsul.setBounds(378, 23, 151, 14);
		contentPane.add(texConsul);
		
		JButton botaoConsultar = new JButton("Consultar");
		botaoConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoConsultar.setBounds(483, 206, 119, 23);
		contentPane.add(botaoConsultar);
		
		JLabel textAnimaisPorID = new JLabel("Animais encontrados no CPF Informado");
		textAnimaisPorID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAnimaisPorID.setBounds(314, 307, 229, 14);
		contentPane.add(textAnimaisPorID);
		
		JComboBox ListAnimaisPorID = new JComboBox();
		ListAnimaisPorID.setModel(new DefaultComboBoxModel(new String[] {"Bob", "Luna", "Ralph", "Amora"}));
		ListAnimaisPorID.setBounds(335, 350, 164, 22);
		contentPane.add(ListAnimaisPorID);
		
		JList list = new JList();
		list.setBounds(64, 224, 58, 0);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(197, 167, 1, 1);
		contentPane.add(list_1);
		
		JButton botaoVerificarFicha = new JButton("Verificar Ficha");
		botaoVerificarFicha.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoVerificarFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoVerificarFicha.setBounds(354, 398, 125, 23);
		contentPane.add(botaoVerificarFicha);
	}
}
