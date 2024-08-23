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
    public static FuncionariosConsultaFuncionario funcionario1 = new FuncionariosConsultaFuncionario();

    /**
     * Create the panel.
     */
    public FuncionariosConsultaFuncionario() {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(-15, -13, 821, 500);
        add(panel);
        panel.setLayout(null);

        JLabel tituloFuncionarios = new JLabel("Funcionários");
        tituloFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
        tituloFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tituloFuncionarios.setBounds(320, 11, 150, 25);
        panel.add(tituloFuncionarios);

        JLabel textoNomeFuncionario = new JLabel("Nome do funcionário: ");
        textoNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoNomeFuncionario.setBounds(165, 83, 182, 25);
        panel.add(textoNomeFuncionario);

        campoNomeFuncionario = new JTextField();
        campoNomeFuncionario.setBounds(347, 83, 267, 24);
        panel.add(campoNomeFuncionario);
        campoNomeFuncionario.setColumns(10);

        // Adiciona o filtro para permitir apenas letras
        ((AbstractDocument) campoNomeFuncionario.getDocument()).setDocumentFilter(new FiltroApenasLetras());

        JButton botaoPesquisarFuncionario = new JButton("Pesquisar Funcionario");
        botaoPesquisarFuncionario.setForeground(new Color(255, 255, 255));
        botaoPesquisarFuncionario.setBackground(new Color(159, 80, 0));
        botaoPesquisarFuncionario.setBounds(299, 133, 171, 23);
        panel.add(botaoPesquisarFuncionario);

        JLabel textoFuncionariosEncontrados = new JLabel("Funcionários encontrados:");
        textoFuncionariosEncontrados.setHorizontalAlignment(SwingConstants.CENTER);
        textoFuncionariosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textoFuncionariosEncontrados.setBounds(254, 167, 267, 40);
        panel.add(textoFuncionariosEncontrados);

        JComboBox<String> selectResultadoFuncionarios = new JComboBox<>();
        selectResultadoFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
        selectResultadoFuncionarios.setBounds(298, 218, 203, 21);
        panel.add(selectResultadoFuncionarios);

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

        JButton botaoVerificarFuncionario = new JButton("<html>Verificar <br>funcionário</html>");
        botaoVerificarFuncionario.setForeground(new Color(255, 255, 255));
        botaoVerificarFuncionario.setBackground(new Color(159, 80, 0));
        botaoVerificarFuncionario.setBounds(320, 251, 150, 40);
        panel.add(botaoVerificarFuncionario);

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

        JButton botaoRetornar = new JButton("← Retornar");
        botaoRetornar.setForeground(new Color(255, 255, 255));
        botaoRetornar.setBackground(new Color(159, 80, 0));
        botaoRetornar.setBounds(248, 426, 99, 21);
        panel.add(botaoRetornar);

        botaoRetornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
                f.setContentPane(new Home());
                f.revalidate();
            }
        });

        JButton botaoAdicionarFuncionario = new JButton("Adicionar novo funcionário\r\n");
        botaoAdicionarFuncionario.setForeground(new Color(255, 255, 255));
        botaoAdicionarFuncionario.setBackground(new Color(159, 80, 0));
        botaoAdicionarFuncionario.setBounds(425, 407, 209, 40);
        panel.add(botaoAdicionarFuncionario);

        botaoAdicionarFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
                f.setContentPane(new FuncionariosNovoFuncionario());
                f.revalidate();
            }

        });

    }

    // Filtro para permitir apenas letras (maiúsculas e minúsculas)
    class FiltroApenasLetras extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("[a-zA-Z ]*")) {  // Permite letras e espaços
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("[a-zA-Z ]*")) {  // Permite letras e espaços
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}