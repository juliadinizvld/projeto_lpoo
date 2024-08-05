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
	private JTable table;
	private JTable table_1;
	private JTable table_2;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("Consulta dia 03/02/2024");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textNomeTutor = new JLabel("Tutor:");
		textNomeTutor.setBounds(546, 26, 46, 14);
		contentPane.add(textNomeTutor);
		
		JLabel textCpfTutor = new JLabel("CPF do tutor:");
		textCpfTutor.setBounds(546, 51, 86, 14);
		contentPane.add(textCpfTutor);
		
		JLabel tituloDadosPet = new JLabel("Dados do PET");
		tituloDadosPet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tituloDadosPet.setBounds(271, 13, 132, 41);
		contentPane.add(tituloDadosPet);
		
		table = new JTable();
		table.setBounds(149, 109, 1, 1);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(271, 147, 1, 1);
		contentPane.add(table_1);
		
		table_2 = new JTable();
		table_2.setBounds(197, 109, 1, 1);
		contentPane.add(table_2);
		
		JLabel textIDPet = new JLabel("ID:");
		textIDPet.setBounds(8, 109, 46, 14);
		contentPane.add(textIDPet);
		
		JLabel TextNomePet = new JLabel("Nome:");
		TextNomePet.setBounds(8, 134, 86, 14);
		contentPane.add(TextNomePet);
		
		JLabel TextEspeciePet = new JLabel("Espécie:");
		TextEspeciePet.setBounds(8, 164, 114, 14);
		contentPane.add(TextEspeciePet);
		
		JLabel TextracaPet = new JLabel("Raça:");
		TextracaPet.setBounds(8, 189, 95, 14);
		contentPane.add(TextracaPet);
		
		JLabel textIdadePet = new JLabel(" Idade:");
		textIdadePet.setBounds(8, 236, 86, 20);
		contentPane.add(textIdadePet);
		
		JLabel TextSexoPet = new JLabel("Sexo:");
		TextSexoPet.setBounds(8, 267, 46, 14);
		contentPane.add(TextSexoPet);
		
		JLabel textPesoPet = new JLabel("Peso:");
		textPesoPet.setBounds(8, 292, 46, 14);
		contentPane.add(textPesoPet);
		
		JLabel textVacinasPet = new JLabel("Vacinas:");
		textVacinasPet.setBounds(8, 317, 86, 14);
		contentPane.add(textVacinasPet);
		
		JLabel textListaDeConsulta = new JLabel("Lista de Consultas ");
		textListaDeConsulta.setBounds(484, 122, 108, 14);
		contentPane.add(textListaDeConsulta);
		
		JList listConsultasAnterior = new JList();
		listConsultasAnterior.setFont(new Font("Tahoma", Font.PLAIN, 11));
		listConsultasAnterior.setModel(new AbstractListModel() {
			String[] values = new String[] {"Consulta: 07/04/2024", "Consulta: 08/06/2024"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listConsultasAnterior.setBounds(429, 147, 244, 109);
		contentPane.add(listConsultasAnterior);
		
		JButton botaoVerificarConsulta = new JButton("Verificar Consulta");
		botaoVerificarConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoVerificarConsulta.setBounds(492, 288, 140, 23);
		contentPane.add(botaoVerificarConsulta);
		
		JButton botaoAgendarConsulta = new JButton("Agendar consulta");
		botaoAgendarConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoAgendarConsulta.setBounds(172, 403, 180, 23);
		contentPane.add(botaoAgendarConsulta);
		
		JButton botaoAgendarProcedimento = new JButton("Agendar Procedimento");
		botaoAgendarProcedimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoAgendarProcedimento.setBounds(481, 403, 206, 23);
		contentPane.add(botaoAgendarProcedimento);
		
		JLabel TextNascPet = new JLabel("Nascimento:");
		TextNascPet.setBounds(8, 205, 142, 27);
		contentPane.add(TextNascPet);
	}
}
