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

		JLabel textIDTutor = new JLabel("ID: " + tutor.getId());
		textIDTutor.setBounds(8, 120, 132, 14);
		panel.add(textIDTutor);

		JLabel TextNomeTutor = new JLabel("Nome: " + tutor.getNome());
		TextNomeTutor.setBounds(8, 145, 226, 14);
		panel.add(TextNomeTutor);

		JLabel TextCPFTutor = new JLabel("CPF: " + tutor.getCpf());
		TextCPFTutor.setBackground(new Color(255, 255, 255));
		TextCPFTutor.setBounds(8, 174, 226, 14);
		panel.add(TextCPFTutor);

		JLabel TelefoneTutor = new JLabel("Telefone: " + tutor.getTelefone());
		TelefoneTutor.setBounds(8, 261, 226, 14);
		panel.add(TelefoneTutor);

		JLabel TextSexo = new JLabel("Sexo: " + tutor.getSexo());
		TextSexo.setBounds(8, 199, 208, 14);
		panel.add(TextSexo);

		JLabel TextDataNascimento = new JLabel("Data de Nascimento: " + tutor.getDataNascimento());
		TextDataNascimento.setBounds(8, 238, 245, 23);
		panel.add(TextDataNascimento);

		JButton botaoRetornar = new JButton("Retornar");
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBounds(197, 403, 114, 23);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Home());
				f.revalidate();
			}

		});

		JButton botaoRemoverTutor = new JButton("Remover Tutor");
		botaoRemoverTutor.setForeground(Color.WHITE);
		botaoRemoverTutor.setBackground(new Color(159, 80, 0));
		botaoRemoverTutor.setBounds(390, 403, 195, 23);
		panel.add(botaoRemoverTutor);

		JLabel EmailTutor = new JLabel("Email: " + tutor.getEmail());
		EmailTutor.setBounds(8, 221, 226, 14);
		panel.add(EmailTutor);

		JLabel lblCep = new JLabel("CEP: " + tutor.getCep());
		lblCep.setBounds(415, 134, 190, 14);
		panel.add(lblCep);

		JLabel BairroTutor = new JLabel("Bairro: " + tutor.getBairro());
		BairroTutor.setBounds(415, 164, 190, 14);
		panel.add(BairroTutor);

		JLabel RuaAV = new JLabel("Rua/Av: " + tutor.getRua());
		RuaAV.setBounds(415, 189, 190, 14);
		panel.add(RuaAV);

		JLabel TextNumeroCasa = new JLabel(" Numero: " + tutor.getNumeroCasa());
		TextNumeroCasa.setBounds(412, 208, 208, 27);
		panel.add(TextNumeroCasa);

		botaoRemoverTutor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja remover este Pet?", "Confirmar Remoção",
						JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {

				}
			}

		});

	}
}
