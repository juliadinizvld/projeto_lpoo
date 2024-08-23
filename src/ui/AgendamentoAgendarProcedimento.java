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
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

        String[] tipos = { "Consulta", "Exame", "Cirurgia", "Vacinas" };
        JComboBox<String> cbTipo = new JComboBox<>(tipos);
        gbc.gridx = 1;
        add(cbTipo, gbc);

        // Escolha exames/etapas
        JLabel lblExame = new JLabel("Escolha exames/etapas:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblExame, gbc);

        String[] exames = { "Raio-X", "Biometria ocular", "Ultrassom ocular" };
        JComboBox<String> cbExame = new JComboBox<>(exames);
        gbc.gridx = 1;
        add(cbExame, gbc);

        // ID do pet
        JLabel lblIdPet = new JLabel("ID do pet:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblIdPet, gbc);

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
        add(txtIdPet, gbc);

        // Botões
        JButton btnRetornar = new JButton("← Retornar");
        btnRetornar.setForeground(Color.WHITE);
        btnRetornar.setBackground(new Color(159, 80, 0));
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(btnRetornar, gbc);
        
        btnRetornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, AgendamentoAgendarProcedimento.this);
                f.setContentPane(new Home());
                f.revalidate();
            }
        });

        JButton btnAvancar = new JButton("Avançar");
        btnAvancar.setForeground(Color.WHITE);
        btnAvancar.setBackground(new Color(159, 80, 0));
        gbc.gridx = 1;
        add(btnAvancar, gbc);

        // Ação do botão "Avançar"
        btnAvancar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, AgendamentoAgendarProcedimento.this);
                f.setContentPane(AgendamentoPagamento.agendamento2);
                f.revalidate();
            }
        });

        // Configura o painel com fundo claro
        setBackground(new Color(222, 222, 222));
    }
}

