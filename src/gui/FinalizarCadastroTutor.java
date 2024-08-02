package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalizarCadastroTutor {

    public static void showConfirmationDialog(JFrame parentFrame) {
        // Cria a nova janela de confirmação
        JFrame confirmationFrame = new JFrame("Confirmação");
        confirmationFrame.setSize(300, 150);
        confirmationFrame.setLocationRelativeTo(parentFrame);
        confirmationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cria um painel para a nova janela com um layout apropriado
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Usando GridBagLayout para melhor controle do layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os componentes

        // Adiciona uma mensagem
        JLabel messageLabel = new JLabel("Deseja visualizar o cadastro feito?");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa as duas colunas
        panel.add(messageLabel, gbc);

        // Botão "Sim"
        JButton btnSim = new JButton("Sim");
        btnSim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode colocar a lógica para exibir o cadastro
                JOptionPane.showMessageDialog(confirmationFrame, "Cadastro exibido!");
                confirmationFrame.dispose(); // Fecha a janela de confirmação após a ação
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Volta a ocupar uma coluna
        panel.add(btnSim, gbc);

        // Botão "Não"
        JButton btnNao = new JButton("Não");
        btnNao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmationFrame.dispose(); // Fecha a janela de confirmação
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(btnNao, gbc);

        // Adiciona o painel à janela de confirmação e a torna visível
        confirmationFrame.getContentPane().add(panel);
        confirmationFrame.setVisible(true);
    }
}

