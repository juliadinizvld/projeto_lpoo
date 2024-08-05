package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ConsultaPetTela3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPetTela3 frame = new ConsultaPetTela3();
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
	public ConsultaPetTela3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textDataConsulta = new JLabel("Data da Consulta:");
		textDataConsulta.setBounds(10, 25, 168, 14);
		contentPane.add(textDataConsulta);
		
		JLabel textMedicoDaConsulta = new JLabel("Médico da Consulta:");
		textMedicoDaConsulta.setBounds(10, 50, 168, 14);
		contentPane.add(textMedicoDaConsulta);
		
		JLabel textDescricaoDaConsulta = new JLabel("Descrição da Consulta:");
		textDescricaoDaConsulta.setBounds(10, 94, 168, 14);
		contentPane.add(textDescricaoDaConsulta);
		
		JLabel textProcedimentoSolicitado = new JLabel("Procedimento Solicitado:");
		textProcedimentoSolicitado.setBounds(10, 198, 168, 14);
		contentPane.add(textProcedimentoSolicitado);
		
		JLabel textmedicacaoSolicitada = new JLabel("Medicação Solicitada:");
		textmedicacaoSolicitada.setBounds(10, 240, 122, 14);
		contentPane.add(textmedicacaoSolicitada);
		
		JLabel textMetodoPagamento = new JLabel("Métodos de Pagamento:");
		textMetodoPagamento.setBounds(163, 366, 165, 14);
		contentPane.add(textMetodoPagamento);
		
		JLabel textValorConsulta = new JLabel("Valor da Consulta:");
		textValorConsulta.setBounds(163, 335, 109, 14);
		contentPane.add(textValorConsulta);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setBounds(672, 21, 89, 23);
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaPetTela2 telaResumoConsulta = new ConsultaPetTela2 ();
				 telaResumoConsulta.setVisible(true);
				 dispose();
			}
			 
		
		});
	
		
		contentPane.add(botaoSair);
				   
	
	}
	
}
