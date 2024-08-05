package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextField;
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
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(163, 129, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Descrição da Consulta:");
		lblNewLabel_4.setBounds(10, 94, 168, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Procedimento Solicitado:");
		lblNewLabel_5.setBounds(10, 198, 168, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Medição Solicitada:");
		lblNewLabel_6.setBounds(10, 240, 122, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Métodos de Pagamento:");
		lblNewLabel_7.setBounds(163, 366, 165, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_1 = new JLabel("Valor da Consulta:");
		lblNewLabel_1.setBounds(163, 335, 109, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setBounds(672, 21, 89, 23);
		contentPane.add(botaoSair);
	}
	
}
