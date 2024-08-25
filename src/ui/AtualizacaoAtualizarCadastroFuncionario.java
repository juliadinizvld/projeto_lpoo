package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.DocumentFilter.FilterBypass;

import business.BDServices;
import ui.entities.Funcionarios;
import ui.entities.MedicosVeterinarios;
import java.awt.Color;

public class AtualizacaoAtualizarCadastroFuncionario extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField campoRmv;
    private JTextField campoNomeFuncionario;
    private JTextField campoCpf;

    /**
     * Create the panel.
     */
    public AtualizacaoAtualizarCadastroFuncionario() {
        setLayout(null);
        MaskFormatter mfIdade = null;
        MaskFormatter mfCpf = null;
        MaskFormatter mfCrmv = null;
        MaskFormatter mfTelefone = null;
        MaskFormatter mfCep = null;
        MaskFormatter mfEstado = null;

        try {
            mfIdade = new MaskFormatter("##");
            mfCpf = new MaskFormatter("###.###.###-##");
            mfCrmv = new MaskFormatter("CRM/UU#####-##");
            mfTelefone = new MaskFormatter("### #####-####");
            mfCep = new MaskFormatter("#####-###");
            mfEstado = new MaskFormatter("UU");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(-12, 11, 700, 500);
        add(panel);
        panel.setLayout(null);

        JLabel tituloNovoFuncionario = new JLabel("Novo funcionário");
        tituloNovoFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
        tituloNovoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tituloNovoFuncionario.setBounds(216, 10, 253, 25);
        panel.add(tituloNovoFuncionario);

        JLabel textoNomeDoFuncionario = new JLabel("Nome do funcionário:");
        textoNomeDoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoNomeDoFuncionario.setBounds(130, 69, 167, 20);
        panel.add(textoNomeDoFuncionario);

        campoNomeFuncionario = new JTextField();
        campoNomeFuncionario.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoNomeFuncionario.setBounds(299, 69, 278, 22);
        panel.add(campoNomeFuncionario);
        campoNomeFuncionario.setColumns(10);
        
        // Adiciona o filtro para permitir apenas letras acentuadas, letras e espaços
        ((AbstractDocument) campoNomeFuncionario.getDocument()).setDocumentFilter(new FiltroApenasLetrasEAcentos());

        JLabel textoIdade = new JLabel("Idade:");
        textoIdade.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoIdade.setBounds(130, 110, 62, 20);
        panel.add(textoIdade);

        JFormattedTextField campoIdade = new JFormattedTextField(mfIdade);
        campoIdade.setToolTipText("");
        campoIdade.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoIdade.setBounds(196, 110, 62, 22);
        campoIdade.setColumns(10);
        panel.add(campoIdade);

        JLabel textoCpf = new JLabel("CPF: ");
        textoCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoCpf.setBounds(130, 141, 46, 25);
        panel.add(textoCpf);

        campoCpf = new JFormattedTextField(mfCpf);
        campoCpf.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoCpf.setBounds(186, 141, 111, 25);
        panel.add(campoCpf);
        campoCpf.setColumns(10);

        JLabel textoFuncao = new JLabel("Função:");
        textoFuncao.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoFuncao.setBounds(336, 143, 56, 20);
        panel.add(textoFuncao);

        String[] funcoes = { "", "Médico Veterinário", "Atendente", "Administrador" };
        JComboBox<String> selectFuncao = new JComboBox<>(funcoes);
        selectFuncao.setFont(new Font("Dialog", Font.PLAIN, 14));
        selectFuncao.setBounds(402, 143, 149, 23);
        panel.add(selectFuncao);

        JLabel textoRmv = new JLabel("RMV:");
        textoRmv.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoRmv.setBounds(130, 209, 62, 20);
        panel.add(textoRmv);

        campoRmv = new JFormattedTextField(mfCrmv);
        campoRmv.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoRmv.setBounds(186, 207, 120, 25);
        panel.add(campoRmv);
        campoRmv.setColumns(10);
        campoRmv.setEditable(false);

        JButton botaoRetornar = new JButton("← Retornar");
        botaoRetornar.setForeground(new Color(255, 255, 255));
        botaoRetornar.setBackground(new Color(159, 80, 0));
        botaoRetornar.setBounds(190, 447, 120, 21);
        panel.add(botaoRetornar);

        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setForeground(new Color(255, 255, 255));
        botaoConfirmar.setBackground(new Color(159, 80, 0));
        botaoConfirmar.setBounds(402, 446, 109, 23);
        panel.add(botaoConfirmar);

        JLabel textoSexo = new JLabel("Sexo:");
        textoSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoSexo.setBounds(130, 177, 46, 14);
        panel.add(textoSexo);

        String[] sexos = { "Masculino", "Feminino" };
        JComboBox<String> selectSexo = new JComboBox<>(sexos);
        selectSexo.setFont(new Font("Dialog", Font.PLAIN, 14));
        selectSexo.setBounds(186, 173, 149, 23);
        panel.add(selectSexo);

        JLabel textoTelefone = new JLabel("Telefone:");
        textoTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoTelefone.setBounds(336, 113, 79, 14);
        panel.add(textoTelefone);

        JFormattedTextField campoTelefone = new JFormattedTextField(mfTelefone);
        campoTelefone.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoTelefone.setBounds(415, 107, 143, 25);
        panel.add(campoTelefone);

        JLabel textoRua = new JLabel("Rua:");
        textoRua.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoRua.setBounds(130, 274, 46, 20);
        panel.add(textoRua);

        JLabel textoEstado = new JLabel("Estado:");
        textoEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoEstado.setBounds(130, 305, 62, 20);
        panel.add(textoEstado);

        JLabel textoCep = new JLabel("Cep:");
        textoCep.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoCep.setBounds(130, 240, 46, 20);
        panel.add(textoCep);

        JLabel textoCidade_1 = new JLabel("Cidade:");
        textoCidade_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoCidade_1.setBounds(330, 305, 62, 20);
        panel.add(textoCidade_1);

        JLabel textoBairro = new JLabel("Bairro:");
        textoBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoBairro.setBounds(330, 274, 62, 20);
        panel.add(textoBairro);

        JLabel textoNumeroCasa = new JLabel("Numero da casa:");
        textoNumeroCasa.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textoNumeroCasa.setBounds(330, 245, 132, 20);
        panel.add(textoNumeroCasa);

        JFormattedTextField campoCep = new JFormattedTextField(mfCep);
        campoCep.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoCep.setBounds(169, 240, 120, 23);
        panel.add(campoCep);

        JFormattedTextField campoRua = new JFormattedTextField();
        campoRua.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoRua.setBounds(169, 274, 120, 22);
        panel.add(campoRua);

        JFormattedTextField campoEstado = new JFormattedTextField(mfEstado);
        campoEstado.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoEstado.setBounds(186, 304, 46, 22);
        panel.add(campoEstado);

        JFormattedTextField campoBairro = new JFormattedTextField();
        campoBairro.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoBairro.setBounds(384, 274, 120, 22);
        panel.add(campoBairro);

        JFormattedTextField campoNumeroCasa = new JFormattedTextField();
        campoNumeroCasa.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoNumeroCasa.setBounds(454, 242, 56, 22);
        panel.add(campoNumeroCasa);

        JFormattedTextField campoCidade = new JFormattedTextField();
        campoCidade.setFont(new Font("Dialog", Font.PLAIN, 14));
        campoCidade.setBounds(389, 304, 120, 22);
        panel.add(campoCidade);

        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNomeFuncionario.getText();
                String cpf = campoCpf.getText().replace(".", "").replace("-", "");
                String sexo = String.valueOf(selectSexo.getSelectedItem()).toUpperCase();
                String telefone = campoTelefone.getText().replace(" ", "").replace("-", "");
                String rua = campoRua.getText();
                String cidade = campoCidade.getText();
                String estado = campoEstado.getText();
                String bairro = campoBairro.getText();
                int numeroCasa = Integer.parseInt(campoNumeroCasa.getText());
                String cep = campoCep.getText().replace("-", "");
                int idade = Integer.parseInt(campoIdade.getText());

                if (selectFuncao.getSelectedItem().equals("Médico Veterinário")) {
                    String rmv = campoRmv.getText();
                    MedicosVeterinarios medicoVeterinario = new MedicosVeterinarios(null, nome, idade, telefone, cpf,
                            sexo, cep, numeroCasa, rua, bairro, estado, cidade, rmv);
                    BDServices.inserirMedicoVeterinario(medicoVeterinario);
                } else {
                    String tipoFuncionario = String.valueOf(selectFuncao.getSelectedItem()).toUpperCase();
                    Funcionarios funcionario = new Funcionarios(null, nome, idade, telefone, cpf, tipoFuncionario, sexo,
                            cep, numeroCasa, rua, bairro, estado, cidade);
                    BDServices.inserirFuncionario(funcionario);
                }
            }
        });

        ActionListener verificarFuncao = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectFuncao.getSelectedItem().equals("Médico Veterinário")) {
                    campoRmv.setEditable(true);
                } else {
                    campoRmv.setEditable(false);
                    campoRmv.setText("");
                }
            }
        };

        selectFuncao.addActionListener(verificarFuncao);
        botaoRetornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
                f.setContentPane(new FuncionariosConsultaFuncionario());
                f.revalidate();
            }
        });
    }

    // Filtro para permitir apenas letras (maiúsculas, minúsculas e acentos) e espaços
    class FiltroApenasLetrasEAcentos extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr) throws BadLocationException {
            if (string != null && string.matches("[\\p{L} ]*")) {  // Permite letras (incluindo acentuadas) e espaços
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
            if (text != null && text.matches("[\\p{L} ]*")) {  // Permite letras (incluindo acentuadas) e espaços
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}