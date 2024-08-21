package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

import business.BDServices;
import data.BD;
import ui.entities.Pets;

public class ConsultaPets extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField caixaInserirIDTutor;
    public static ConsultaPets consultaPets1 = new ConsultaPets();

    /**
     * Create the panel.
     */
    public ConsultaPets() {
        setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 821, 500);
        add(panel);
        panel.setLayout(null);

        JButton botaoRetornar = new JButton(" <- Retornar");
        botaoRetornar.setFont(new Font("Tahoma", Font.BOLD, 11));
        botaoRetornar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
                f.setContentPane(new Home());
                f.revalidate();
            }
        });
        botaoRetornar.setBounds(281, 124, 125, 23);
        panel.add(botaoRetornar);

        caixaInserirIDTutor = new JTextField();
        caixaInserirIDTutor.setBounds(414, 75, 63, 20);
        panel.add(caixaInserirIDTutor);
        caixaInserirIDTutor.setColumns(10);

        // Adicionando o filtro de caracteres para aceitar apenas números
        ((AbstractDocument) caixaInserirIDTutor.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        JLabel textoIdTutor = new JLabel("ID do tutor:");
        textoIdTutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textoIdTutor.setBounds(327, 77, 77, 14);
        panel.add(textoIdTutor);

        JLabel texConsul = new JLabel("Consulta PET");
        texConsul.setFont(new Font("Tahoma", Font.PLAIN, 14));
        texConsul.setBounds(378, 23, 151, 14);
        panel.add(texConsul);

        JButton botaoConsultar = new JButton("Consultar");
        botaoConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
        botaoConsultar.setBounds(436, 124, 119, 23);
        panel.add(botaoConsultar);

        JLabel textAnimaisPorID = new JLabel("Animais encontrados no CPF Informado");
        textAnimaisPorID.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textAnimaisPorID.setBounds(300, 191, 229, 14);
        panel.add(textAnimaisPorID);

        JComboBox<String> ListAnimaisPorID = new JComboBox<>();
        ListAnimaisPorID.setBounds(327, 231, 164, 22);
        panel.add(ListAnimaisPorID);

        botaoConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListAnimaisPorID.removeAllItems();
                Connection connection = null;
                Statement st = null;
                ResultSet rs = null;

                try {
                    int idTutor = Integer.parseInt(caixaInserirIDTutor.getText());
                    
                    try {
                        connection = BD.getConnection();
                        st = connection.createStatement();
                        rs = st.executeQuery("SELECT * FROM pets WHERE id_tutor = " + idTutor);
                        while (rs.next()) {
                            ListAnimaisPorID.addItem(rs.getString("nome") + " - " + rs.getInt("id"));
                        }
                    } catch (SQLException i) {
                        i.printStackTrace();
                    } finally {
                        try {
                            if (rs != null) rs.close();
                            if (st != null) st.close();
                            if (connection != null) connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o ID do tutor.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton botaoVerificarFicha = new JButton("Verificar Ficha");
        botaoVerificarFicha.setBounds(349, 283, 125, 23);
        botaoVerificarFicha.setFont(new Font("Tahoma", Font.BOLD, 11));
        botaoVerificarFicha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] petSelecionado = String.valueOf(ListAnimaisPorID.getSelectedItem()).split("-");
                int idPetSelecionado = Integer.parseInt(petSelecionado[1].trim());
                Pets pet = BDServices.consultarPet(idPetSelecionado);
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
                f.setContentPane(new ConsultaPetsDadosPet(pet));
                f.revalidate();
            }

        });

        panel.add(botaoVerificarFicha);
    }
}
