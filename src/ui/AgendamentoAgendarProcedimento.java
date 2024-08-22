package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import data.BD;

public class AgendamentoAgendarProcedimento extends JPanel {

	private static final long serialVersionUID = 1L;
	public static AgendamentoAgendarProcedimento agendamento1 = new AgendamentoAgendarProcedimento();

	/**
	 * Create the panel.
	 */
	public AgendamentoAgendarProcedimento() {
		

		// Painel principal
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		// Tipo de procedimento
		JLabel lblTipo = new JLabel("Tipo de procedimento:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lblTipo, gbc);

		String[] tipos = { "Consulta", "Exame", "Cirurgia", "Vacinas" };
		JComboBox<String> cbTipo = new JComboBox<>(tipos);
		gbc.gridx = 1;
		panel.add(cbTipo, gbc);
		
		// Escolha exames/etapas
		JLabel lblExame = new JLabel("Escolha exames/etapas:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(lblExame, gbc);

		String[] exames = { "Raio-X", "Biometria ocular", "Ultrassom ocular" };
		JComboBox<String> cbExame = new JComboBox<>(exames);
		gbc.gridx = 1;
		panel.add(cbExame, gbc);


		// ...

		// ID do pet
		JLabel lblIdPet = new JLabel("ID do pet:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(lblIdPet, gbc);

		// Cria uma máscara para permitir apenas dígitos numéricos 
		MaskFormatter idPetFormatter = null;
		try {
		    idPetFormatter = new MaskFormatter("##########"); 
		    idPetFormatter.setPlaceholderCharacter('_'); // Caractere de espaço vazio
		} catch (ParseException e) {
		    e.printStackTrace();
		}

		JFormattedTextField txtIdPet = new JFormattedTextField(idPetFormatter);
		txtIdPet.setColumns(10);
		gbc.gridx = 1;
		panel.add(txtIdPet, gbc);

		// ...

		
		// Botões
		JButton btnRetornar = new JButton("Retornar");
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(btnRetornar, gbc);
		
		btnRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(Home.telaInicial);
				f.revalidate();
			}
		});

		JButton btnAvancar = new JButton("Avançar");
		gbc.gridx = 1;
		panel.add(btnAvancar, gbc);

		// Ação do botão "Avançar"
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(AgendamentoPagamento.agendamento2);
				f.revalidate();
			}
		});

		// Adiciona painel ao frame
		add(panel);
	}

}
