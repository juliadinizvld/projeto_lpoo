package ui;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import business.BDServices;
import ui.entities.Consultas;
import ui.entities.MedicosVeterinarios;
import ui.entities.Pets;

public class ConsultaInserirDadosConsulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoDataConsulta;
	private JTextField CampoNomeMedico;
	private JTextField campoMedicacaoSolicitada;

	public ConsultaInserirDadosConsulta(MedicosVeterinarios medico, Pets pet) {

		DateTimeFormatter fmtBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		SimpleDateFormat fmtSql = new SimpleDateFormat("dd/MM/yyyy");
		MaskFormatter mfDataConsulta = null;
		MaskFormatter mfValorConsulta = null;

		try {

			mfDataConsulta = new MaskFormatter("##/##/####");
			mfValorConsulta = new MaskFormatter("###.##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 821, 565);
		add(panel);
		panel.setLayout(null);

		JLabel textDataConsulta = new JLabel("Data da Consulta:");
		textDataConsulta.setBounds(191, 46, 137, 14);
		panel.add(textDataConsulta);

		JLabel textMedicoDaConsulta = new JLabel("Médico da Consulta:");
		textMedicoDaConsulta.setBounds(191, 71, 137, 14);
		panel.add(textMedicoDaConsulta);

		JLabel textDescricaoDaConsulta = new JLabel("Descrição da Consulta:");
		textDescricaoDaConsulta.setBounds(191, 102, 168, 14);
		panel.add(textDescricaoDaConsulta);

		JLabel textmedicacaoSolicitada = new JLabel("Medicação Solicitada:");
		textmedicacaoSolicitada.setBounds(191, 300, 137, 14);
		panel.add(textmedicacaoSolicitada);

		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setForeground(new Color(255, 255, 255));
		botaoCancelar.setBackground(new Color(159, 80, 0));
		botaoCancelar.setBounds(191, 399, 89, 23);
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new MedicosConsultaMedico());
				f.revalidate();
			}
		});

		panel.add(botaoCancelar);

		campoDataConsulta = new JFormattedTextField(mfDataConsulta);
		campoDataConsulta.setBounds(349, 43, 137, 20);
		panel.add(campoDataConsulta);
		campoDataConsulta.setColumns(10);
		campoDataConsulta.setText(LocalDate.now().format(fmtBr));
		campoDataConsulta.setEditable(false);

		CampoNomeMedico = new JTextField();
		CampoNomeMedico.setBounds(350, 68, 136, 20);
		panel.add(CampoNomeMedico);
		CampoNomeMedico.setColumns(10);
		CampoNomeMedico.setText(medico.getNome());
		CampoNomeMedico.setEditable(false);

		campoMedicacaoSolicitada = new JTextField();
		campoMedicacaoSolicitada.setBounds(355, 297, 298, 20);
		panel.add(campoMedicacaoSolicitada);
		campoMedicacaoSolicitada.setColumns(10);

		JTextArea campoDescricaoConsulta = new JTextArea();
		campoDescricaoConsulta.setBackground(SystemColor.inactiveCaption);
		campoDescricaoConsulta.setBounds(192, 117, 341, 139);
		panel.add(campoDescricaoConsulta);

		JButton btnAdicionarConsulta = new JButton("Adicionar Consulta");
		btnAdicionarConsulta.setForeground(Color.WHITE);
		btnAdicionarConsulta.setBackground(new Color(159, 80, 0));
		btnAdicionarConsulta.setBounds(380, 399, 153, 23);
		panel.add(btnAdicionarConsulta);

		btnAdicionarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataConsulta = campoDataConsulta.getText();
				String nomeMedico = CampoNomeMedico.getText();
				String descricao = campoDescricaoConsulta.getText();
				Date dataFormatada = null;
				String medicacao = campoMedicacaoSolicitada.getText();

				try {
					dataFormatada = new java.sql.Date(fmtSql.parse(dataConsulta).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Consultas consulta = new Consultas(null, dataFormatada, nomeMedico, descricao, medicacao, pet.getId());
				BDServices.inserirConsulta(consulta);
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja visualizar a consulta feita?",
						"Confirmar Remoção", JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {
					JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
					f.setContentPane(new ConsultaPetsDadosConsulta(consulta));
					f.revalidate();
				}
			}
		});

	}
}
