package ui;
import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import business.BDServices;
import data.BD;
import ui.entities.Funcionarios;

import java.awt.Color;

public class FuncionariosConsultaFuncionario extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField campoNomeFuncionario;

    public FuncionariosConsultaFuncionario() {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(222, 222, 222));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel tituloFuncionarios = new JLabel("Funcionários", SwingConstants.CENTER);
        tituloFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(tituloFuncionarios, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel textoNomeFuncionario = new JLabel("Nome do funcionário: ");
        textoNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(textoNomeFuncionario, gbc);

        gbc.gridx++;
        campoNomeFuncionario = new JTextField(20);
        panel.add(campoNomeFuncionario, gbc);
        ((AbstractDocument) campoNomeFuncionario.getDocument()).setDocumentFilter(new FiltroApenasLetrasEAcentos());

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton botaoPesquisarFuncionario = new JButton("Pesquisar Funcionário");
        botaoPesquisarFuncionario.setForeground(Color.WHITE);
        botaoPesquisarFuncionario.setBackground(new Color(159, 80, 0));
        panel.add(botaoPesquisarFuncionario, gbc);

        gbc.gridy++;
        JLabel textoFuncionariosEncontrados = new JLabel("Funcionários encontrados:", SwingConstants.CENTER);
        textoFuncionariosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(textoFuncionariosEncontrados, gbc);

        gbc.gridy++;
        JComboBox<String> selectResultadoFuncionarios = new JComboBox<>();
        selectResultadoFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(selectResultadoFuncionarios, gbc);

        gbc.gridy++;
        JButton botaoVerificarFuncionario = new JButton("<html>Verificar <br>funcionário</html>");
        botaoVerificarFuncionario.setForeground(Color.WHITE);
        botaoVerificarFuncionario.setBackground(new Color(159, 80, 0));
        panel.add(botaoVerificarFuncionario, gbc);

        gbc.gridy++;
        JButton botaoAdicionarFuncionario = new JButton("Adicionar novo funcionário");
        botaoAdicionarFuncionario.setForeground(Color.WHITE);
        botaoAdicionarFuncionario.setBackground(new Color(159, 80, 0));
        panel.add(botaoAdicionarFuncionario, gbc);
        
        gbc.gridy++;
        JButton botaoRetornar = new JButton("← Retornar");
        botaoRetornar.setForeground(Color.WHITE);
        botaoRetornar.setBackground(new Color(159, 80, 0));
        panel.add(botaoRetornar, gbc);

        add(panel, BorderLayout.CENTER);

        botaoPesquisarFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectResultadoFuncionarios.removeAllItems();
                Connection connection = null;
                Statement st = null;
                ResultSet rs = null;
                String nome = campoNomeFuncionario.getText();
                try {
                    connection = BD.getConnection();
                    st = connection.createStatement();
                    rs = st.executeQuery("SELECT * FROM funcionarios WHERE nome LIKE '%" + nome + "%';");
                    while (rs.next()) {
                        selectResultadoFuncionarios.addItem(rs.getString("nome") + " - " + rs.getInt("id"));
                    }
                } catch (SQLException i) {
                    i.printStackTrace();
                }
            }
        });

        botaoVerificarFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] funcionarioSelecionado = String.valueOf(selectResultadoFuncionarios.getSelectedItem())
                        .split("-");
                int idFuncionarioSelecionado = Integer.parseInt(funcionarioSelecionado[1].trim());
                Funcionarios funcionario = BDServices.consultarFuncionario(idFuncionarioSelecionado);
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
                f.setContentPane(new FuncionariosDadosFuncionario(funcionario));
                f.revalidate();
            }
        });

        botaoRetornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
                f.setContentPane(new Home());
                f.revalidate();
            }
        });

        botaoAdicionarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
                f.setContentPane(new FuncionariosNovoFuncionario());
                f.revalidate();
            }
        });
    }

    class FiltroApenasLetrasEAcentos extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("[\\p{L} ]*")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("[\\p{L} ]*")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}
