package ui;

import java.awt.Dimension;
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

import com.toedter.calendar.JDateChooser;

public class AgendamentoPagamento extends JPanel {

	private static final long serialVersionUID = 1L;
	public static AgendamentoPagamento agendamento2 = new AgendamentoPagamento();

	/**
	 * Create the panel.
	 */
	public AgendamentoPagamento() {
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

		// Cria o componente JDateChooser
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy"); // Define o formato de exibição da data
		gbc.gridx = 1;
		panel.add(dateChooser, gbc);
		
		// Ajusta o tamanho do JDateChooser
		dateChooser.setPreferredSize(new Dimension(150, 25)); 
		
		
		
		// Informação de pagamento
		JLabel lblPagamento = new JLabel("<html><br><br><br>Para conclusão do agendamento é necessário realizar o pagamento. "
				+ "O valor total para pagamento é de R$   . Acesse o link abaixo para realização do pagamento:<br>"
				+ "link mercado pago, integração com API</html>");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(20, 10, 10, 10); // Ajuste os insets para mover o lblPagamento
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(lblPagamento, gbc);
		
		// Botões 
		JButton btnRetornar = new JButton("Retornar");
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		panel.add(btnRetornar, gbc);

		JButton btnAvancar = new JButton("Avançar");
		gbc.gridx = 1;
		panel.add(btnAvancar, gbc);

		// Ação do botão "Retornar"
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(AgendamentoAgendarProcedimento.agendamento1);
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
