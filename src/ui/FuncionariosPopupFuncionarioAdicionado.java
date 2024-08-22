package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class FuncionariosPopupFuncionarioAdicionado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionariosPopupFuncionarioAdicionado frame = new FuncionariosPopupFuncionarioAdicionado();
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
	public FuncionariosPopupFuncionarioAdicionado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500,200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 484, 161);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel tituloFuncionarioAdicionado = new JLabel("Funcionário adicionado!");
		tituloFuncionarioAdicionado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloFuncionarioAdicionado.setHorizontalAlignment(SwingConstants.CENTER);
		tituloFuncionarioAdicionado.setBounds(148, 33, 197, 20);
		panel.add(tituloFuncionarioAdicionado);
		
		JButton botaoOk = new JButton("Ok");
		botaoOk.setForeground(new Color(255, 255, 255));
		botaoOk.setBackground(new Color(159, 80, 0));
		botaoOk.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoOk.setBounds(214, 79, 85, 21);
		panel.add(botaoOk);
	}

}
