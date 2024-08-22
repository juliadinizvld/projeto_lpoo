package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ui.entities.Pets;

public class ConsultaPetsDadosConsulta extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ConsultaPetsDadosConsulta(Pets pet) {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JLabel textDataConsulta = new JLabel("Data da Consulta:");
		textDataConsulta.setBounds(10, 25, 168, 14);
		panel.add(textDataConsulta);

		JLabel textMedicoDaConsulta = new JLabel("Médico da Consulta:");
		textMedicoDaConsulta.setBounds(10, 50, 168, 14);
		panel.add(textMedicoDaConsulta);

		JLabel textDescricaoDaConsulta = new JLabel("Descrição da Consulta:");
		textDescricaoDaConsulta.setBounds(10, 94, 168, 14);
		panel.add(textDescricaoDaConsulta);

		JLabel textProcedimentoSolicitado = new JLabel("Procedimento Solicitado:");
		textProcedimentoSolicitado.setBounds(10, 198, 168, 14);
		panel.add(textProcedimentoSolicitado);

		JLabel textmedicacaoSolicitada = new JLabel("Medicação Solicitada:");
		textmedicacaoSolicitada.setBounds(10, 240, 122, 14);
		panel.add(textmedicacaoSolicitada);

		JLabel textMetodoPagamento = new JLabel("Métodos de Pagamento:");
		textMetodoPagamento.setBounds(163, 366, 165, 14);
		panel.add(textMetodoPagamento);

		JLabel textValorConsulta = new JLabel("Valor da Consulta:");
		textValorConsulta.setBounds(163, 335, 109, 14);
		panel.add(textValorConsulta);

		JButton botaoSair = new JButton("Sair");
		botaoSair.setBounds(672, 21, 89, 23);
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ConsultaPetsDadosPet(pet));
				f.revalidate();
			}
		});

		panel.add(botaoSair);

	}
}
