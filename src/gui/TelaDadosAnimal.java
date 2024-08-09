package gui;

import javax.swing.*;
import java.awt.*;

public class TelaDadosAnimal {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JFormattedTextField formattedTextField;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;

    public static void main(String[] args) {
        // Executa a GUI na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            // Cria a janela principal
            JFrame frame = new JFrame("Dados do Animal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null); // Centraliza a janela
            
         // Cria a barra de menus
            JMenuBar menuBar = new JMenuBar();
            menuBar.setBackground(new Color(192, 192, 192));
            
            // Adiciona os itens de menu à barra de menus
            JMenu fileMenu = new JMenu("File");
            fileMenu.setBounds(5, 5, 101, 26);
            JMenu optionsMenu = new JMenu("Options");
            
            menuBar.add(fileMenu);
            menuBar.add(optionsMenu);
            
            // Adiciona a barra de menus à parte superior da janela
            frame.setJMenuBar(menuBar);
            
            // Cria um painel principal com um layout de BorderLayout
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(null);

            // Cria o título
            JLabel titleLabel = new JLabel("Dados do Animal:", JLabel.CENTER);
            titleLabel.setBounds(-24, 10, 800, 50);
            titleLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
            titleLabel.setPreferredSize(new Dimension(800, 50)); // Define o tamanho do título

            // Adiciona o título ao painel principal
            mainPanel.add(titleLabel);

            // Define o fundo do painel principal
            mainPanel.setBackground(new Color(222, 222, 222));

            // Adiciona o painel principal à janela
            frame.getContentPane().add(mainPanel);
            
            textField = new JTextField();
            textField.setBounds(282, 74, 242, 26);
            mainPanel.add(textField);
            textField.setColumns(10);
            
            JLabel lblNewLabel = new JLabel("Nome do animal:");
            lblNewLabel.setFont(new Font("Arial", Font.BOLD, 10));
            lblNewLabel.setBounds(185, 74, 100, 24);
            mainPanel.add(lblNewLabel);
            
            textField_1 = new JTextField();
            textField_1.setColumns(10);
            textField_1.setBounds(225, 161, 273, 26);
            mainPanel.add(textField_1);
            
            JLabel lblNewLabel_1 = new JLabel("Espécie:");
            lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
            lblNewLabel_1.setBounds(185, 118, 49, 24);
            mainPanel.add(lblNewLabel_1);
            
            JRadioButton rdbtnNewRadioButton = new JRadioButton("Cachorro\r\n");
            rdbtnNewRadioButton.setBackground(new Color(222, 222, 222));
            rdbtnNewRadioButton.setBounds(240, 120, 79, 21);
            mainPanel.add(rdbtnNewRadioButton);
            
            JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Gato");
            rdbtnNewRadioButton_1.setBackground(new Color(222, 222, 222));
            rdbtnNewRadioButton_1.setBounds(321, 120, 58, 21);
            mainPanel.add(rdbtnNewRadioButton_1);
            
            JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Outro");
            rdbtnNewRadioButton_2.setBackground(new Color(222, 222, 222));
            rdbtnNewRadioButton_2.setBounds(381, 120, 103, 21);
            mainPanel.add(rdbtnNewRadioButton_2);
            
            JLabel lblNewLabel_1_1 = new JLabel("Raça:");
            lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 10));
            lblNewLabel_1_1.setBounds(185, 161, 49, 24);
            mainPanel.add(lblNewLabel_1_1);
            
            JLabel lblNewLabel_1_1_1 = new JLabel("Data de Nascimento: ");
            lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
            lblNewLabel_1_1_1.setBounds(185, 205, 108, 24);
            mainPanel.add(lblNewLabel_1_1_1);
            
            textField_2 = new JTextField();
            textField_2.setText("        /        /");
            textField_2.setColumns(10);
            textField_2.setBounds(296, 205, 103, 26);
            mainPanel.add(textField_2);
            
            JLabel lblNewLabel_1_1_1_1 = new JLabel("Sexo:");
            lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
            lblNewLabel_1_1_1_1.setBounds(185, 255, 49, 24);
            mainPanel.add(lblNewLabel_1_1_1_1);
            
            JRadioButton rdbtnFmea = new JRadioButton("Fêmea");
            rdbtnFmea.setBackground(new Color(222, 222, 222));
            rdbtnFmea.setBounds(219, 257, 66, 21);
            mainPanel.add(rdbtnFmea);
            
            JRadioButton rdbtnFmea_1 = new JRadioButton("Macho");
            rdbtnFmea_1.setBackground(new Color(222, 222, 222));
            rdbtnFmea_1.setBounds(282, 257, 58, 21);
            mainPanel.add(rdbtnFmea_1);
            
            JRadioButton rdbtnNoIdentificado = new JRadioButton("Não identificado");
            rdbtnNoIdentificado.setBackground(new Color(222, 222, 222));
            rdbtnNoIdentificado.setBounds(347, 257, 126, 21);
            mainPanel.add(rdbtnNoIdentificado);
            
            JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Peso(kg):");
            lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
            lblNewLabel_1_1_1_1_1.setBounds(185, 299, 49, 24);
            mainPanel.add(lblNewLabel_1_1_1_1_1);
            
            textField_3 = new JTextField();
            textField_3.setColumns(10);
            textField_3.setBounds(250, 299, 100, 26);
            mainPanel.add(textField_3);
            
            JLabel lblNewLabel_1_1_2 = new JLabel("Alergia(s):");
            lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 10));
            lblNewLabel_1_1_2.setBounds(185, 351, 58, 24);
            mainPanel.add(lblNewLabel_1_1_2);
            
            textField_4 = new JTextField();
            textField_4.setColumns(10);
            textField_4.setBounds(251, 351, 273, 26);
            mainPanel.add(textField_4);
            
            JLabel lblNewLabel_1_1_2_1 = new JLabel("Vacinas:");
            lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 10));
            lblNewLabel_1_1_2_1.setBounds(185, 398, 58, 24);
            mainPanel.add(lblNewLabel_1_1_2_1);
            
            textField_5 = new JTextField();
            textField_5.setColumns(10);
            textField_5.setBounds(251, 398, 273, 26);
            mainPanel.add(textField_5);
            
            JButton btnNewButton = new JButton("Avançar ");
            btnNewButton.setBounds(416, 454, 108, 35);
            mainPanel.add(btnNewButton);
            
            JButton btnRetornar = new JButton("Retornar");
            btnRetornar.setBounds(262, 454, 108, 35);
            mainPanel.add(btnRetornar);
            

            // Torna a janela visível
            frame.setVisible(true);
        });
    }
}