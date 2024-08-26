package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CadastroEscolha extends JPanel {

    private static final long serialVersionUID = 1L;
    public static CadastroCadastroTutor cadastroEscolha = new CadastroCadastroTutor();
    private static JFrame frame;

    /**
     * Create the panel.
     */
    public CadastroEscolha() {
        setLayout(new BorderLayout());

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(222, 222, 222));
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.insets = new Insets(10, 10, 10, 10);
        gbcMain.anchor = GridBagConstraints.CENTER;
        gbcMain.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel lblTitulo = new JLabel("Tutor já é cadastrado?");
        lblTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
        gbcMain.gridwidth = 2;
        gbcMain.gridy = 0;
        mainPanel.add(lblTitulo, gbcMain);

        // Botão Novo Cadastro
        JButton btnNovoCadastro = new JButton("Novo Cadastro");
        btnNovoCadastro.setForeground(Color.WHITE);
        btnNovoCadastro.setBackground(new Color(159, 80, 0));
        gbcMain.gridwidth = 1;
        gbcMain.gridy++;
        mainPanel.add(btnNovoCadastro, gbcMain);
        btnNovoCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
                f.setContentPane(new CadastroCadastroTutor());
                f.revalidate();
            }
        });

        // Botão Já sou cadastrado
        JButton btnJaCadastrado = new JButton("Já sou cadastrado");
        btnJaCadastrado.setForeground(Color.WHITE);
        btnJaCadastrado.setBackground(new Color(159, 80, 0));
        gbcMain.gridy++;
        mainPanel.add(btnJaCadastrado, gbcMain);
        btnJaCadastrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
                f.setContentPane(new CadastroInformarIdTutor());
                f.revalidate();
            }
        });

        // Botão Retornar
        JButton btnRetornar = new JButton("Retornar");
        btnRetornar.setForeground(Color.WHITE);
        btnRetornar.setBackground(new Color(159, 80, 0));
        gbcMain.gridy++;
        mainPanel.add(btnRetornar, gbcMain);
        btnRetornar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
                f.setContentPane(new Home());
                f.revalidate();
            }
        });

        add(mainPanel, BorderLayout.CENTER);
    }
}

