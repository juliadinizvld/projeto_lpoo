package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDadosTutor {
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JTextField textField;
    private static JTextField textField_1;
    private static JTextField textField_2;
    private static JTextField textField_3;
    private static JTextField textField_4;
    private static JTextField textField_5;
    private static JTextField textField_7;
    private static JTextField textField_8;
    private static JTextField textField_9;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Inicializa o JFrame
            frame = new JFrame("VetMed - Interface");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

            // Cria um painel principal com um layout de coluna única
            mainPanel = new JPanel();
            mainPanel.setBackground(new Color(222, 222, 222)); // Define a cor de fundo

            // Adiciona o painel principal à janela
            frame.getContentPane().add(mainPanel);
            mainPanel.setLayout(null);
            
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

            // Adiciona os componentes
            JLabel lblNewLabel = new JLabel("Dados do tutor:");
            lblNewLabel.setBounds(332, 32, 373, 22);
            lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
            mainPanel.add(lblNewLabel);

            JLabel lblNewLabel_1 = new JLabel("CPF :");
            lblNewLabel_1.setBounds(200, 126, 45, 13);
            lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_1);

            JLabel lblNewLabel_2 = new JLabel("Nome Completo :");
            lblNewLabel_2.setBounds(200, 87, 98, 13);
            lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_2);

            JLabel lblNewLabel_3 = new JLabel("Sexo :");
            lblNewLabel_3.setBounds(200, 149, 45, 13);
            lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_3);

            JLabel lblNewLabel_4 = new JLabel("Data de nascimento :");
            lblNewLabel_4.setBounds(397, 126, 114, 13);
            lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_4);

            JLabel lblNewLabel_5 = new JLabel("Telefone :");
            lblNewLabel_5.setBounds(413, 149, 74, 13);
            lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_5);

            JLabel lblNewLabel_8 = new JLabel("Cidade : ");
            lblNewLabel_8.setBounds(200, 309, 56, 13);
            lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_8);

            JLabel lblNewLabel_9 = new JLabel("CEP :");
            lblNewLabel_9.setBounds(200, 233, 45, 13);
            lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_9);

            JLabel lblNewLabel_10 = new JLabel("Rua/Av");
            lblNewLabel_10.setBounds(397, 236, 45, 13);
            lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_10);

            JLabel lblNewLabel_6 = new JLabel("Bairro :");
            lblNewLabel_6.setBounds(200, 273, 45, 13);
            lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_6);

            JLabel lblNewLabel_11 = new JLabel("Número : ");
            lblNewLabel_11.setBounds(397, 273, 56, 13);
            lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_11);

            textField = new JTextField();
            textField.setBounds(521, 146, 96, 19);
            mainPanel.add(textField);
            textField.setColumns(10);

            textField_1 = new JTextField();
            textField_1.setBounds(521, 123, 96, 19);
            mainPanel.add(textField_1);
            textField_1.setColumns(10);

            textField_2 = new JTextField();
            textField_2.setBounds(255, 230, 96, 19);
            mainPanel.add(textField_2);
            textField_2.setColumns(10);

            textField_3 = new JTextField();
            textField_3.setBounds(447, 273, 40, 19);
            mainPanel.add(textField_3);
            textField_3.setColumns(10);

            textField_4 = new JTextField();
            textField_4.setBounds(255, 270, 96, 19);
            mainPanel.add(textField_4);
            textField_4.setColumns(10);

            textField_5 = new JTextField();
            textField_5.setBounds(457, 230, 96, 19);
            mainPanel.add(textField_5);
            textField_5.setColumns(10);

            JButton btnNewButton = new JButton("Retornar ");
            btnNewButton.setBounds(255, 448, 112, 37);
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Ação para o botão Retornar
                }
            });
            mainPanel.add(btnNewButton);

            JButton btnNewButton_1 = new JButton("Finalizar cadastro ");
            btnNewButton_1.setBounds(436, 448, 148, 37);
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de confirmação quando o botão é clicado
                    FinalizarCadastroTutor.showConfirmationDialog(frame);
                }
            });
            mainPanel.add(btnNewButton_1);

            JLabel lblNewLabel_12 = new JLabel("Email :");
            lblNewLabel_12.setBounds(200, 188, 45, 13);
            lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 10));
            mainPanel.add(lblNewLabel_12);

            textField_7 = new JTextField();
            textField_7.setBounds(239, 188, 189, 16);
            mainPanel.add(textField_7);
            textField_7.setColumns(10);

            textField_8 = new JTextField();
            textField_8.setBounds(296, 84, 304, 19);
            mainPanel.add(textField_8);
            textField_8.setColumns(10);

            JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
            rdbtnFeminino.setBackground(new Color(222, 222, 222));
            rdbtnFeminino.setBounds(241, 145, 74, 21);
            mainPanel.add(rdbtnFeminino);

            JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
            rdbtnMasculino.setBackground(new Color(222, 222, 222));
            rdbtnMasculino.setBounds(317, 145, 74, 21);
            mainPanel.add(rdbtnMasculino);

            // Agrupa os botões de rádio
            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(rdbtnFeminino);
            genderGroup.add(rdbtnMasculino);
            
            textField_9 = new JTextField();
            textField_9.setBounds(255, 306, 96, 19);
            textField_9.setColumns(10);
            mainPanel.add(textField_9);
            
            JFormattedTextField formattedTextField = new JFormattedTextField();
            formattedTextField.setBounds(239, 123, 112, 19);
            mainPanel.add(formattedTextField);

            // Torna a janela visível
            frame.setVisible(true);
        });
    }
}