package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import data.BD;
import ui.entities.Consulta;

public class AgendamentoAgendarProcedimento extends JPanel {

	private static final long serialVersionUID = 1L;

	public static AgendamentoAgendarProcedimento agendamento1 = new AgendamentoAgendarProcedimento();

	/**
	 * Create the panel.
	 */
	public AgendamentoAgendarProcedimento() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Título
		JLabel titulo = new JLabel("Agendamento de Procedimento", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.PLAIN, 30));
		titulo.setPreferredSize(new Dimension(800, 50));
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(titulo, gbc);

		// Tipo de procedimento
		JLabel lblTipo = new JLabel("Tipo de procedimento:");
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lblTipo, gbc);

		String[] tipos = { "Consulta" };
		JComboBox<String> cbTipo = new JComboBox<>(tipos);
		gbc.gridx = 1;
		add(cbTipo, gbc);

		// ID do pet
		JLabel lblIdPet = new JLabel("ID do pet: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(lblIdPet, gbc);

		// Cria uma máscara para permitir apenas dígitos numéricos

		JFormattedTextField txtIdPet = new JFormattedTextField();
		txtIdPet.setColumns(10);
		gbc.gridx = 1;
		add(txtIdPet, gbc);

		JFormattedTextField txtNomePet = new JFormattedTextField();
		txtIdPet.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(txtNomePet, gbc);
		txtNomePet.setEditable(false);

		JLabel nomePet = new JLabel("Nome do pet: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(nomePet, gbc);

		// Botões
		JButton btnRetornar = new JButton("← Retornar");
		btnRetornar.setForeground(Color.WHITE);
		btnRetornar.setBackground(new Color(159, 80, 0));
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(btnRetornar, gbc);

		btnRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class,
						AgendamentoAgendarProcedimento.this);
				f.setContentPane(new Home());
				f.revalidate();
			}
		});

		JButton confirmarPet = new JButton("Confirmar Pet");
		confirmarPet.setForeground(Color.WHITE);
		confirmarPet.setBackground(new Color(159, 80, 0));
		gbc.gridx = 1;
		add(confirmarPet, gbc);
		String valorNomePet = "";

		confirmarPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;
				try {
					int idPet = Integer.parseInt(txtIdPet.getText());
					try {
						connection = BD.getConnection();
						st = connection.createStatement();
						rs = st.executeQuery("SELECT * FROM pets WHERE id = " + idPet);
						while (rs.next()) {
							txtNomePet.setText(rs.getString("nome"));
						}
					} catch (SQLException i) {
						i.printStackTrace();
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o ID do tutor.",
							"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setForeground(Color.WHITE);
		btnAvancar.setBackground(new Color(159, 80, 0));
		gbc.gridx = 3;

		add(btnAvancar, gbc);

		// Ação do botão "Avançar"
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idConsulta = 1;
				String nomeConsulta = "Consulta";
				double valorConsulta = 80.00;
				int quantidadeConsulta = 1;

				Consulta consulta = new Consulta(idConsulta, nomeConsulta, valorConsulta, quantidadeConsulta);
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class,
						AgendamentoAgendarProcedimento.this);
				f.setContentPane(new AgendamentoPagamento(consulta));
				f.revalidate();
			}
		});

		// Configura o painel com fundo claro
		setBackground(new Color(222, 222, 222));
	}
}
