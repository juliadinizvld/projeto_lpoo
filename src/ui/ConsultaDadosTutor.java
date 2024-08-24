package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import business.BDServices;
import ui.entities.Pets;
import java.awt.Color;
import ui.entities.Tutores;

public class ConsultaDadosTutor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public ConsultaDadosTutor(Tutores tutor) {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JLabel tituloDadosTutor = new JLabel("Dados do Tutor");
		tituloDadosTutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tituloDadosTutor.setBounds(272, 13, 132, 41);
		panel.add(tituloDadosTutor);

		table = new JTable();
		table.setBounds(149, 109, 1, 1);
		panel.add(table);

		table_1 = new JTable();
		table_1.setBounds(271, 147, 1, 1);
		panel.add(table_1);

		table_2 = new JTable();
		table_2.setBounds(197, 109, 1, 1);
		panel.add(table_2);

		JLabel textIDTutor = new JLabel("ID: " + tutor.getId());
		textIDTutor.setBounds(8, 120, 86, 14);
		panel.add(textIDTutor);

		JLabel TextNomeTutor = new JLabel("Nome: " + tutor.getNome());
		TextNomeTutor.setBounds(8, 147, 226, 14);
		panel.add(TextNomeTutor);

		JLabel TextCPFTutor = new JLabel("CPF: <dynamic>");
		TextCPFTutor.setBackground(new Color(255, 255, 255));
		TextCPFTutor.setBounds(8, 164, 226, 14);
		panel.add(TextCPFTutor);

		JLabel EmailTutor = new JLabel("Email:  <dynamic>");
		EmailTutor.setBounds(8, 189, 190, 14);
		panel.add(EmailTutor);

		JLabel TelefoneTutor = new JLabel("Telefone: <dynamic>");
		TelefoneTutor.setBounds(8, 285, 142, 14);
		panel.add(TelefoneTutor);

		JLabel TextSexoPet = new JLabel("Sexo: " + tutor.getSexo());
		TextSexoPet.setBounds(8, 214, 142, 14);
		panel.add(TextSexoPet);

		JLabel TextNascPet = new JLabel("Nascimento: " + tutor.getDataNascimento());
		TextNascPet.setBounds(8, 247, 208, 27);
		panel.add(TextNascPet);

		JButton botaoRetornar = new JButton("Retornar");
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setForeground(new Color(255, 255, 255));
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

		JButton botaoRemoverTutor = new JButton("Remover Tutor");
		botaoRemoverTutor.setForeground(Color.WHITE);
		botaoRemoverTutor.setBackground(new Color(159, 80, 0));
		botaoRemoverTutor.setBounds(390, 403, 195, 23);
		panel.add(botaoRemoverTutor);
		
		JLabel EmailTutor_1 = new JLabel("Email:  <dynamic>");
		EmailTutor_1.setBounds(8, 235, 190, 14);
		panel.add(EmailTutor_1);
		
		JLabel lblCep = new JLabel("CEP:  <dynamic>");
		lblCep.setBounds(415, 134, 190, 14);
		panel.add(lblCep);
		
		JLabel BairroTutor = new JLabel("Bairro:  <dynamic>");
		BairroTutor.setBounds(415, 164, 190, 14);
		panel.add(BairroTutor);
		
		JLabel RuaAV = new JLabel("Rua/Av:  <dynamic>");
		RuaAV.setBounds(415, 189, 190, 14);
		panel.add(RuaAV);
		
		JLabel TextNumeroCasa = new JLabel(" Numero: null");
		TextNumeroCasa.setBounds(412, 208, 208, 27);
		panel.add(TextNumeroCasa);

		botaoRemoverTutor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja remover este Pet?", "Confirmar Remoção",
						JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {
					BDServices.removerPet(pet.getId());
					JOptionPane.showMessageDialog(null, "Pet removido com sucesso!");
					JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
					f.setContentPane(new ConsultaPets());
					f.revalidate();
				}
			}

		});

	}
}
