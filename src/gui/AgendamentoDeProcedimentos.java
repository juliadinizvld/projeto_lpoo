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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AgendamentoDeProcedimentos extends JFrame {
	  public AgendamentoDeProcedimentos() {
	        setTitle("Agendamento de procedimentos");
	        setSize(800, 600);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

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

	        String[] tipos = {"Consulta", "Exame", "Cirurgia", "Vacinas"};
	        JComboBox<String> cbTipo = new JComboBox<>(tipos);
	        gbc.gridx = 1;
	        panel.add(cbTipo, gbc);

	        // Escolha exames/etapas
	        JLabel lblExame = new JLabel("Escolha exames/etapas:");
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        panel.add(lblExame, gbc);

	        String[] exames = {"Raio-X", "Biometria ocular", "Ultrassom ocular"};
	        JComboBox<String> cbExame = new JComboBox<>(exames);
	        gbc.gridx = 1;
	        panel.add(cbExame, gbc);

	        // ID do pet
	        JLabel lblIdPet = new JLabel("ID do pet:");
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        panel.add(lblIdPet, gbc);

	        JTextField txtIdPet = new JTextField(10);
	        gbc.gridx = 1;
	        panel.add(txtIdPet, gbc);
	        // Botões
	        JButton btnRetornar = new JButton("Retornar");
	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        panel.add(btnRetornar, gbc);

	        JButton btnAvancar = new JButton("Avançar");
	        gbc.gridx = 1;
	        panel.add(btnAvancar, gbc);

	        // Ação do botão "Avançar"
	        btnAvancar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Fecha a janela atual
	                dispose();
	                
	                // Abre a nova janela
	                new PagamentoAgendamento().setVisible(true);
	            }
	        });

	        // Adiciona painel ao frame
	        add(panel);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new AgendamentoDeProcedimentos().setVisible(true);
	            }
	        });
	    }
}
