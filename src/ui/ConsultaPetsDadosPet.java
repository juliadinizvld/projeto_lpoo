package ui;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ConsultaPetsDadosPet extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	public static ConsultaPetsDadosPet consultaPets2 = new ConsultaPetsDadosPet();

	/**
	 * Create the panel.
	 */
	public ConsultaPetsDadosPet() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JLabel textNomeTutor = new JLabel("Tutor:");
		textNomeTutor.setBounds(546, 26, 46, 14);
		panel.add(textNomeTutor);

		JLabel textCpfTutor = new JLabel("CPF do tutor:");
		textCpfTutor.setBounds(546, 51, 86, 14);
		panel.add(textCpfTutor);

		JLabel tituloDadosPet = new JLabel("Dados do PET");
		tituloDadosPet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tituloDadosPet.setBounds(271, 13, 132, 41);
		panel.add(tituloDadosPet);

		table = new JTable();
		table.setBounds(149, 109, 1, 1);
		panel.add(table);

		table_1 = new JTable();
		table_1.setBounds(271, 147, 1, 1);
		panel.add(table_1);

		table_2 = new JTable();
		table_2.setBounds(197, 109, 1, 1);
		panel.add(table_2);

		JLabel textIDPet = new JLabel("ID:");
		textIDPet.setBounds(8, 109, 46, 14);
		panel.add(textIDPet);

		JLabel TextNomePet = new JLabel("Nome:");
		TextNomePet.setBounds(8, 134, 86, 14);
		panel.add(TextNomePet);

		JLabel TextEspeciePet = new JLabel("Espécie:");
		TextEspeciePet.setBounds(8, 164, 114, 14);
		panel.add(TextEspeciePet);

		JLabel TextracaPet = new JLabel("Raça:");
		TextracaPet.setBounds(8, 189, 95, 14);
		panel.add(TextracaPet);

		JLabel textIdadePet = new JLabel(" Idade:");
		textIdadePet.setBounds(8, 236, 86, 20);
		panel.add(textIdadePet);

		JLabel TextSexoPet = new JLabel("Sexo:");
		TextSexoPet.setBounds(8, 267, 46, 14);
		panel.add(TextSexoPet);

		JLabel textPesoPet = new JLabel("Peso:");
		textPesoPet.setBounds(8, 292, 46, 14);
		panel.add(textPesoPet);

		JLabel textVacinasPet = new JLabel("Vacinas:");
		textVacinasPet.setBounds(8, 317, 86, 14);
		panel.add(textVacinasPet);

		JLabel textListaDeConsulta = new JLabel("Lista de Consultas ");
		textListaDeConsulta.setBounds(484, 122, 108, 14);
		panel.add(textListaDeConsulta);

		JList listConsultasAnterior = new JList();
		listConsultasAnterior.setFont(new Font("Tahoma", Font.PLAIN, 11));
		listConsultasAnterior.setModel(new AbstractListModel() {
			String[] values = new String[] { "Consulta: 07/04/2024", "Consulta: 08/06/2024" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listConsultasAnterior.setBounds(429, 147, 244, 109);
		panel.add(listConsultasAnterior);

		JButton botaoVerificarConsulta = new JButton("Verificar Consulta");
		botaoVerificarConsulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoVerificarConsulta.setBounds(492, 288, 140, 23);
		panel.add(botaoVerificarConsulta);

		botaoVerificarConsulta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ConsultaPetsDadosConsulta());
				f.revalidate();
			}
		});

		JLabel TextNascPet = new JLabel("Nascimento:");
		TextNascPet.setBounds(8, 205, 142, 27);
		panel.add(TextNascPet);

		JButton botaoRetornar = new JButton("Retornar");
		botaoRetornar.setBounds(197, 403, 114, 23);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(ConsultaPets.consultaPets1);
				f.revalidate();
			}

		});

	}
}
