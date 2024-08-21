package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import ui.entities.Pets;

public class ConsultaPetsDadosPet extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public ConsultaPetsDadosPet(Pets pet) {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JLabel textNomeTutor = new JLabel("Nome do Tutor: ");
		textNomeTutor.setBounds(546, 26, 201, 14);
		panel.add(textNomeTutor);

		JLabel textCpfTutor = new JLabel("ID do tutor: " + pet.getId_tutor());
		textCpfTutor.setBounds(546, 51, 155, 14);
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

		JLabel textIDPet = new JLabel("ID: " + pet.getId());
		textIDPet.setBounds(8, 109, 86, 14);
		panel.add(textIDPet);

		JLabel TextNomePet = new JLabel("Nome: " + pet.getNome());
		TextNomePet.setBounds(8, 134, 226, 14);
		panel.add(TextNomePet);

		JLabel TextEspeciePet = new JLabel("Espécie: " + pet.getEspecie());
		TextEspeciePet.setBounds(8, 164, 226, 14);
		panel.add(TextEspeciePet);

		JLabel TextracaPet = new JLabel("Raça: " + pet.getRaca());
		TextracaPet.setBounds(8, 189, 190, 14);
		panel.add(TextracaPet);

		JLabel TextSexoPet = new JLabel("Sexo: " + pet.getSexo());
		TextSexoPet.setBounds(8, 267, 142, 14);
		panel.add(TextSexoPet);

		JLabel textPesoPet = new JLabel("Peso: " + pet.getPeso());
		textPesoPet.setBounds(8, 292, 114, 14);
		panel.add(textPesoPet);

		JLabel textVacinasPet = new JLabel("Vacinas: " + pet.getVacinas());
		textVacinasPet.setBounds(8, 317, 155, 14);
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
				f.setContentPane(new ConsultaPetsDadosConsulta(pet));
				f.revalidate();
			}
		});

		JLabel TextNascPet = new JLabel("Nascimento: " + pet.getDataNascimento());
		TextNascPet.setBounds(8, 205, 208, 27);
		panel.add(TextNascPet);

		JButton botaoRetornar = new JButton("Retornar");
		botaoRetornar.setBounds(197, 403, 114, 23);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ConsultaPets());
				f.revalidate();
			}

		});

	}
}
