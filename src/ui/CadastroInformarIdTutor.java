package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import business.BDServices;
import ui.entities.Tutores;

import java.awt.Color;

public class CadastroInformarIdTutor extends JPanel {

    private static final long serialVersionUID = 1L;

    public static CadastroInformarIdTutor cadastroInformarIdTutor = new CadastroInformarIdTutor();

    public CadastroInformarIdTutor() {
        setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 10, 867, 606);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Informe o ID do tutor:");
        lblNewLabel.setBounds(303, 31, 373, 22);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
        panel.add(lblNewLabel);

        JButton btnRetornar = new JButton("Retornar ");
        btnRetornar.setForeground(new Color(255, 255, 255));
        btnRetornar.setBackground(new Color(159, 80, 0));
        btnRetornar.setBounds(248, 146, 112, 37);
        panel.add(btnRetornar);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setForeground(new Color(255, 255, 255));
        btnConfirmar.setBackground(new Color(159, 80, 0));
        btnConfirmar.setBounds(470, 146, 122, 37);
        panel.add(btnConfirmar);

        JTextField campoIdTutor = new JTextField();
        campoIdTutor.setBounds(403, 91, 73, 20);
        panel.add(campoIdTutor);

        JButton btnAvancar = new JButton("Avançar");
        btnAvancar.setForeground(new Color(255, 255, 255));
        btnAvancar.setBackground(new Color(159, 80, 0));
        btnAvancar.setBounds(344, 333, 148, 37);
        panel.add(btnAvancar);

        JLabel textoCampoIdTutor = new JLabel("ID:");
        textoCampoIdTutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textoCampoIdTutor.setBounds(345, 90, 35, 17);
        panel.add(textoCampoIdTutor);

        JLabel textoIdTutor = new JLabel("Id tutor: ");
        textoIdTutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textoIdTutor.setBounds(292, 243, 279, 14);
        panel.add(textoIdTutor);

        JLabel textoNomeTutor = new JLabel("Nome do tutor:");
        textoNomeTutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textoNomeTutor.setBounds(292, 269, 328, 14);
        panel.add(textoNomeTutor);

        // Implementação do botão Confirmar
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idTexto = campoIdTutor.getText().trim();
                if (idTexto.isEmpty()) {
                    textoIdTutor.setText("Id inválido!");
                    textoNomeTutor.setText("");
                    return;
                }

                try {
                    int idTutor = Integer.parseInt(idTexto);
                    Tutores tutor = BDServices.consultarTutor(idTutor);

                    if (tutor != null) {
                        textoIdTutor.setText("Id do Tutor: " + tutor.getId());
                        textoNomeTutor.setText("Nome do Tutor: " + tutor.getNome());
                    } else {
                        textoIdTutor.setText("Tutor não encontrado!");
                        textoNomeTutor.setText("");
                    }
                } catch (NumberFormatException ex) {
                    textoIdTutor.setText("Id inválido!");
                    textoNomeTutor.setText("");
                }
            }
        });

        // Implementação do botão Avançar
        btnAvancar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
                if (f != null) {
                    String[] campoIdTutorText = textoIdTutor.getText().split(":");
                    if (campoIdTutorText.length > 1) {
                        try {
                            int idTutor = Integer.parseInt(campoIdTutorText[1].trim());
                            f.setContentPane(new CadastroCadastroPet(idTutor));
                            f.revalidate();
                        } catch (NumberFormatException ex) {
                            textoIdTutor.setText("Id inválido!");
                        }
                    } else {
                        textoIdTutor.setText("Por favor, confirme um tutor primeiro.");
                    }
                } else {
                    System.out.println("JFrame não encontrado.");
                }
            }
        });

        // Implementação do botão Retornar
        btnRetornar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
                if (f != null) {
                    f.setContentPane(new CadastroEscolha());
                    f.revalidate();
                } else {
                    System.out.println("JFrame não encontrado.");
                }
            }
        });

        // Adiciona um InputVerifier para o campoIdTutor
        campoIdTutor.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String text = textField.getText();
                if (text.matches("\\d*")) { // Aceita apenas dígitos
                    return true;
                } else {
                    JOptionPane.showMessageDialog(textField, "Por favor, insira apenas números.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        });
    }
}

