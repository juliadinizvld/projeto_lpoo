package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial {

    public static void main(String[] args) {
        // Executa a GUI na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            // Cria a janela principal
            JFrame frame = new JFrame("VetMed - Interface");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null); // Centraliza a janela

            // Cria um painel para a barra de favoritos
            JPanel favoritesBarPanel = new JPanel();
            favoritesBarPanel.setBackground(new Color(192, 192, 192)); // Cor cinza escuro
            favoritesBarPanel.setPreferredSize(new Dimension(frame.getWidth(), 30)); // Altura da barra de favoritos
            favoritesBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            
         // Cria e adiciona os botões "File" e "Options" na barra de favoritos
            JButton fileButton = new JButton("File");
            fileButton.setBackground(new Color(192, 192, 192));
            JButton optionsButton = new JButton("Options");
            optionsButton.setBackground(new Color(192, 192, 192));

            fileButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
            optionsButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

            favoritesBarPanel.add(fileButton);
            favoritesBarPanel.add(optionsButton);

            // Cria um painel principal com um layout de coluna única
            JPanel mainPanel = new JPanel();
            mainPanel.setBackground(new Color(222, 222, 222));
            mainPanel.setLayout(null);

            // Cria os botões para opções
            JButton cadastroPetsButton = new JButton("Cadastro de pets");
            cadastroPetsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
            cadastroPetsButton.setBackground(new Color(192, 192, 192));        
            cadastroPetsButton.setBounds(295, 97, 200, 60);
            cadastroPetsButton.addActionListener(e -> {
                // Ação para cadastro de pets
            });

            JButton consultarPetsButton = new JButton("Consultar pets");
            consultarPetsButton.setBackground(new Color(192, 192, 192));
            consultarPetsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
            consultarPetsButton.setBounds(295, 187, 200, 60);

            JButton agendamentoProcedimentosButton = new JButton("<html><div style='text-align: center;'>Agendamento de<br/>procedimentos</div></html>");
            agendamentoProcedimentosButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
            agendamentoProcedimentosButton.setBackground(new Color(192, 192, 192));
            agendamentoProcedimentosButton.setBounds(293, 275, 200, 64);
            agendamentoProcedimentosButton.addActionListener(e -> {
                // Ação para agendamento de procedimentos
            });

            JButton consultaProdutosButton = new JButton("<html><div style='text-align: center;'>Consulta de<br/><div style='padding-left: 5px;'>produtos</div></div></html>");
            consultaProdutosButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
            consultaProdutosButton.setBackground(new Color(192, 192, 192));
            consultaProdutosButton.setBounds(295, 360, 200, 60);
            consultaProdutosButton.addActionListener(e -> {
                // Ação para consulta de produtos
            });

            // Adiciona o slogan
            JLabel sloganLabel = new JLabel("Bem-vindos ao VetMed", JLabel.CENTER);
            sloganLabel.setBounds(181, 23, 431, 64);
            sloganLabel.setFont(new Font("Arial", Font.PLAIN, 30));
            sloganLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            mainPanel.add(sloganLabel);

            // Adiciona os botões ao painel principal
            mainPanel.add(cadastroPetsButton);
            mainPanel.add(consultarPetsButton);
            mainPanel.add(agendamentoProcedimentosButton);
            mainPanel.add(consultaProdutosButton);

            // Cria um painel para conter a barra de favoritos e o painel principal
            JPanel containerPanel = new JPanel();
            containerPanel.setLayout(new BorderLayout());
            containerPanel.add(favoritesBarPanel, BorderLayout.NORTH);
            containerPanel.add(mainPanel, BorderLayout.CENTER);

            // Adiciona o painel de contêiner à janela
            frame.getContentPane().add(containerPanel);

            // Torna a janela visível
            frame.setVisible(true);
        });
    }
}