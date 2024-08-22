package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Color;

public class ProdutosPagamentoConcluido extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ProdutosPagamentoConcluido() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 700, 500);
		add(panel);
		panel.setLayout(null);

		JLabel tituloPagamentoConcluido = new JLabel("Pagamento concluído!");
		tituloPagamentoConcluido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloPagamentoConcluido.setBounds(240, 11, 197, 32);
		panel.add(tituloPagamentoConcluido);

		JLabel textoPagamentoConcluido = new JLabel(
				"<html>O pagamento foi concluído e o <br>medicamento já pode ser retirado. Aperte <br>no botão abaixo para retornar a página inicial.</html>");
		textoPagamentoConcluido.setHorizontalAlignment(SwingConstants.CENTER);
		textoPagamentoConcluido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoPagamentoConcluido.setBounds(187, 85, 332, 85);
		panel.add(textoPagamentoConcluido);

		JButton botaoRetornar = new JButton("Retornar a página inicial");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setBounds(254, 203, 197, 49);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				
				f.revalidate();

			}

		});
	}
}
