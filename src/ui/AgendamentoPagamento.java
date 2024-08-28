package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import com.toedter.calendar.JDateChooser;

public class AgendamentoPagamento extends JPanel {

    private static final long serialVersionUID = 1L;
    private final JButton btnRealizarPagamento = new JButton("Realizar Pagamento");

    /**
     * Create the panel.
     */
    public AgendamentoPagamento() {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 914, 641);
        add(panel);
        panel.setLayout(null);

        JLabel lblEscolhaData = new JLabel("Escolha a data");
        lblEscolhaData.setHorizontalAlignment(SwingConstants.CENTER);
        lblEscolhaData.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEscolhaData.setBounds(285, 69, 253, 25);
        panel.add(lblEscolhaData);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setBounds(323, 154, 159, 25);
        dateChooser.setPreferredSize(new Dimension(150, 25));
        panel.add(dateChooser);

        JLabel lblPagamento = new JLabel(
                "<html>Para conclusão do agendamento é necessário realizar o pagamento.</html>");
        lblPagamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPagamento.setBounds(166, 217, 602, 69);
        panel.add(lblPagamento);

        JButton btnRetornar = new JButton("← Retornar");
        btnRetornar.setForeground(Color.WHITE);
        btnRetornar.setBackground(new Color(159, 80, 0));
        btnRetornar.setBounds(247, 324, 120, 30); // Ajuste a posição e o tamanho conforme necessário
        panel.add(btnRetornar);
        btnRealizarPagamento.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRealizarPagamento.setBounds(480, 324, 123, 30);
        panel.add(btnRealizarPagamento);
        btnRealizarPagamento.setForeground(new Color(255, 255, 255));
        btnRealizarPagamento.setBackground(new Color(159, 80, 0));

        btnRetornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(AgendamentoPagamento.this);
                if (frame != null) {
                    frame.setContentPane(new AgendamentoAgendarProcedimento());
                    frame.revalidate();
                }
            }
        });
    }
}
