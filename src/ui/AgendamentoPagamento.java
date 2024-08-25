package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class AgendamentoPagamento extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AgendamentoPagamento() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 793, 666);
		add(panel);
		panel.setLayout(null);

		JLabel lblEscolhaData = new JLabel("Escolha a data");
		lblEscolhaData.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEscolhaData.setBounds(216, 30, 253, 25);
		panel.add(lblEscolhaData);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(265, 123, 159, 25);
		dateChooser.setPreferredSize(new Dimension(150, 25));
		panel.add(dateChooser);

		JLabel lblPagamento = new JLabel(
				"<html>Para conclusão do agendamento é necessário realizar o <br>pagamento. Acesse o link abaixo para realização do pagamento!</html>");
		lblPagamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPagamento.setBounds(126, 180, 480, 66);
		panel.add(lblPagamento);
	}
}