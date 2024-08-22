package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import ui.entities.Pets;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class ConsultaInserirDadosConsulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoDataConsulta;
	private JTextField CampoNomeMedico;
	private JTextField campoMedicacaoSolicitada;
	private JTextField campoProcedimentoSolicitado;
	private JTextField campoValorConsulta;
	
	public ConsultaInserirDadosConsulta(Pets pet) {

		SimpleDateFormat fmtBr = new SimpleDateFormat("dd/MM/yyyy");

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
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, -12, 821, 500);
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
		textProcedimentoSolicitado.setBounds(10, 241, 168, 14);
		panel.add(textProcedimentoSolicitado);

		JLabel textmedicacaoSolicitada = new JLabel("Medicação Solicitada:");
		textmedicacaoSolicitada.setBounds(10, 291, 122, 14);
		panel.add(textmedicacaoSolicitada);

		JLabel textMetodoPagamento = new JLabel("Métodos de Pagamento:");
		textMetodoPagamento.setBounds(163, 366, 165, 14);
		panel.add(textMetodoPagamento);

		JLabel textValorConsulta = new JLabel("Valor da Consulta:");
		textValorConsulta.setBounds(163, 335, 109, 14);
		panel.add(textValorConsulta);

		JButton botaoSair = new JButton("Sair");
		botaoSair.setForeground(new Color(255, 255, 255));
		botaoSair.setBackground(new Color(159, 80, 0));
		botaoSair.setBounds(672, 21, 89, 23);
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ConsultaInserirDadosConsulta(pet));
				f.revalidate();
			}
		});

		panel.add(botaoSair);
		
		campoDataConsulta = new JFormattedTextField(mfDataConsulta);
		campoDataConsulta.setBounds(135, 22, 137, 20);
		panel.add(campoDataConsulta);
		campoDataConsulta.setColumns(10);
		
		CampoNomeMedico = new JTextField();
		CampoNomeMedico.setBounds(136, 50, 136, 20);
		panel.add(CampoNomeMedico);
		CampoNomeMedico.setColumns(10);
		
		campoMedicacaoSolicitada = new JTextField();
		campoMedicacaoSolicitada.setBounds(117, 288, 244, 20);
		panel.add(campoMedicacaoSolicitada);
		campoMedicacaoSolicitada.setColumns(10);
		
		campoProcedimentoSolicitado = new JTextField();
		campoProcedimentoSolicitado.setBounds(143, 238, 218, 20);
		panel.add(campoProcedimentoSolicitado);
		campoProcedimentoSolicitado.setColumns(10);
		
		campoValorConsulta = new JFormattedTextField(mfValorConsulta);
		campoValorConsulta.setBounds(267, 329, 86, 20);
		panel.add(campoValorConsulta);
		campoValorConsulta.setColumns(10);
		
		JComboBox BoxMetodoPagamento = new JComboBox();
		BoxMetodoPagamento.setModel(new DefaultComboBoxModel(new String[] {"Crédito", "Débito", "Pix"}));
		BoxMetodoPagamento.setToolTipText("");
		BoxMetodoPagamento.setBounds(297, 362, 122, 22);
		panel.add(BoxMetodoPagamento);
		
		JTextArea campoDescricaoConsulta = new JTextArea();
		campoDescricaoConsulta.setBounds(20, 119, 341, 93);
		panel.add(campoDescricaoConsulta);

	}
}


