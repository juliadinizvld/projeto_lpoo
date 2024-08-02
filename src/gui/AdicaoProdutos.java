package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class AdicaoProdutos {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdicaoProdutos window = new AdicaoProdutos();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AdicaoProdutos() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnAddProduct = new JButton("<html>Adicionar<br>Produto</html>");
        btnAddProduct.setBounds(238, 194, 89, 56);
        frame.getContentPane().add(btnAddProduct);

        JButton btnReturn = new JButton("<-    Retornar");
        btnReturn.setBounds(106, 204, 102, 23);
        frame.getContentPane().add(btnReturn);

        JLabel lblTitle = new JLabel("Adição de Produtos");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(106, 11, 218, 39);
        frame.getContentPane().add(lblTitle);

        JLabel lblTypeOfProduct = new JLabel("Tipo de Produto:");
        lblTypeOfProduct.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTypeOfProduct.setBounds(39, 70, 102, 14);
        frame.getContentPane().add(lblTypeOfProduct);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Consulta", "Exame", "Cirurgia", "Vacina"}));
        comboBox.setBounds(140, 67, 167, 22);
        frame.getContentPane().add(comboBox);

        JLabel lblProductName = new JLabel("Nome do Produto:");
        lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblProductName.setBounds(39, 118, 102, 14);
        frame.getContentPane().add(lblProductName);

        JLabel lblQuantity = new JLabel("Quantidade: ");
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblQuantity.setBounds(39, 160, 71, 14);
        frame.getContentPane().add(lblQuantity);

        JFormattedTextField txtProductName = new JFormattedTextField();
        txtProductName.setBounds(151, 116, 156, 20);
        frame.getContentPane().add(txtProductName);

        JFormattedTextField txtQuantity = new JFormattedTextField();
        txtQuantity.setBounds(120, 158, 28, 20);
        frame.getContentPane().add(txtQuantity);

        // Adiciona o ActionListener ao botão
        btnAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exibe a caixa de mensagem quando o botão é clicado
                JOptionPane.showMessageDialog(
                    frame, // A janela pai onde a caixa de mensagem será exibida
                    "Produto cadastrado com sucesso!", // Mensagem a ser exibida
                    "Cadastro Concluído", // Título da caixa de mensagem
                    JOptionPane.INFORMATION_MESSAGE // Tipo da mensagem
                );
            }
        });

        // Adiciona um ActionListener vazio ao botão Retornar (para teste)
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão Retornar clicado!");
            }
        });
    }
}
