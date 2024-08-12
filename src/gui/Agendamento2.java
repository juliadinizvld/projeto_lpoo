package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;

public class Agendamento2 extends JPanel {

	private static final long serialVersionUID = 1L;
	public static Agendamento2 agendamento2 = new Agendamento2();

	/**
	 * Create the panel.
	 */
	public Agendamento2() {
		// Painel principal
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		// Seleção de data
		JLabel lblData = new JLabel("Selecione a data desejada:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lblData, gbc);

		JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
		dateSpinner.setEditor(dateEditor);
		gbc.gridx = 1;
		panel.add(dateSpinner, gbc);

		// Informação de pagamento
		JLabel lblPagamento = new JLabel("<html>Para conclusão do agendamento é necessário realizar o pagamento. "
				+ "O valor total para pagamento é de R$ tal. Acesse o link abaixo para realização do pagamento:<br>"
				+ "link mercado pago, integração com API</html>");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(20, 10, 10, 10); // Ajuste os insets para mover o lblPagamento
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(lblPagamento, gbc);
		// Botões
		JButton btnRetornar = new JButton("Retornar");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		panel.add(btnRetornar, gbc);

		JButton btnAvancar = new JButton("Avançar");
		gbc.gridx = 1;
		panel.add(btnAvancar, gbc);

		// Ação do botão "Retornar"
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(Agendamento1.agendamento1);
				f.revalidate();
			}
		});

		// Ação do botão "Avançar"
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqui você pode definir a ação do botão Avançar
				// Por exemplo, ir para uma página de confirmação
				JOptionPane.showMessageDialog(panel, "Pagamento concluído e agendamento realizado com sucesso!");
			}
		});

		// Adiciona painel ao frame
		add(panel);
	}


}
