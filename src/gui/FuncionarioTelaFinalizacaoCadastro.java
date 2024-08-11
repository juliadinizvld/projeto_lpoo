package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class FuncionarioTelaFinalizacaoCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioTelaFinalizacaoCadastro frame = new FuncionarioTelaFinalizacaoCadastro();
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
	public FuncionarioTelaFinalizacaoCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500,200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 10, 428, 143);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel tituloFuncionarioAdicionado = new JLabel("Funcionário adicionado!");
		tituloFuncionarioAdicionado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloFuncionarioAdicionado.setHorizontalAlignment(SwingConstants.CENTER);
		tituloFuncionarioAdicionado.setBounds(111, 41, 197, 20);
		panel.add(tituloFuncionarioAdicionado);
		
		JButton botaoOk = new JButton("Ok");
		botaoOk.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoOk.setBounds(160, 71, 85, 21);
		panel.add(botaoOk);
	}

}
