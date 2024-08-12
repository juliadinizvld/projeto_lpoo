package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ProdutoPagamentoConcluido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoPagamentoConcluido frame = new ProdutoPagamentoConcluido();
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
	public ProdutoPagamentoConcluido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 700, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel tituloPagamentoConcluido = new JLabel("Pagamento concluído!");
		tituloPagamentoConcluido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloPagamentoConcluido.setBounds(240, 11, 197, 32);
		panel.add(tituloPagamentoConcluido);
		
		JLabel textoPagamentoConcluido = new JLabel("<html>O pagamento foi concluído e o <br>medicamento já pode ser retirado. Aperte <br>no botão abaixo para retornar a página inicial.</html>");
		textoPagamentoConcluido.setHorizontalAlignment(SwingConstants.CENTER);
		textoPagamentoConcluido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoPagamentoConcluido.setBounds(187, 85, 332, 85);
		panel.add(textoPagamentoConcluido);

		JButton botaoRetornarHome = new JButton("Retornar a página inicial");
		botaoRetornarHome.setBounds(254, 203, 197, 49);
		panel.add(botaoRetornarHome);
	}

}
