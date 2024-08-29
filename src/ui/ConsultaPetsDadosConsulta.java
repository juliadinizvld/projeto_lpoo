package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ui.entities.Consultas;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class ConsultaPetsDadosConsulta extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ConsultaPetsDadosConsulta(Consultas consulta) {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 821, 576);
		add(panel);
		panel.setLayout(null);

		JLabel textDataConsulta = new JLabel("Data da Consulta: " + consulta.getDataConsulta());
		textDataConsulta.setBounds(137, 61, 278, 14);
		panel.add(textDataConsulta);

		JLabel textMedicoDaConsulta = new JLabel("Médico da Consulta: " + consulta.getNomeMedico());
		textMedicoDaConsulta.setBounds(138, 89, 277, 14);
		panel.add(textMedicoDaConsulta);

		JLabel textDescricaoDaConsulta = new JLabel("Descrição da Consulta:");
		textDescricaoDaConsulta.setBounds(137, 121, 278, 14);
		panel.add(textDescricaoDaConsulta);

		JLabel textmedicacaoSolicitada = new JLabel("Medicação Solicitada: " + consulta.getMedicacao());
		textmedicacaoSolicitada.setBounds(137, 344, 459, 14);
		panel.add(textmedicacaoSolicitada);

		JButton botaoSair = new JButton("Sair");
		botaoSair.setForeground(new Color(255, 255, 255));
		botaoSair.setBackground(new Color(159, 80, 0));
		botaoSair.setBounds(311, 399, 89, 23);
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ConsultaPets());
				f.revalidate();
			}
		});

		panel.add(botaoSair);

		JTextArea descricaoConsulta = new JTextArea();
		descricaoConsulta.setBackground(SystemColor.inactiveCaption);
		descricaoConsulta.setForeground(Color.BLACK);
		descricaoConsulta.setBounds(137, 157, 459, 171);
		panel.add(descricaoConsulta);
		descricaoConsulta.setText(consulta.getDescricao());
		descricaoConsulta.setEditable(false);

		JLabel textIdPet = new JLabel("Id do pet: " + consulta.getId_pet());
		textIdPet.setBounds(425, 61, 139, 14);
		panel.add(textIdPet);

	}
}
