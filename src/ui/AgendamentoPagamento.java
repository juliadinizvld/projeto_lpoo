package ui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import com.toedter.calendar.JDateChooser;

import pagamento.controladora.CriacaoPagamento;
import ui.entities.Consulta;

public class AgendamentoPagamento extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public AgendamentoPagamento(Consulta consulta) {
        setLayout(null);

        JPanel panel = new JPanel();
        setBackground(new Color(222, 222, 222));
        panel.setBounds(-118, -81, 958, 840);
        add(panel);
        panel.setLayout(null);

        JLabel lblEscolhaData = new JLabel("Escolha a data");
        lblEscolhaData.setHorizontalAlignment(SwingConstants.CENTER);
        lblEscolhaData.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEscolhaData.setBounds(216, 30, 253, 25);
        panel.add(lblEscolhaData);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setBounds(265, 123, 159, 25);
        dateChooser.setPreferredSize(new Dimension(150, 25));
        panel.add(dateChooser);

        JLabel lblPagamento = new JLabel(
                "<html>Para conclusão do agendamento é necessário realizar o <br>pagamento. Acesse o link abaixo para realização do pagamento!</html>");
        lblPagamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPagamento.setBounds(126, 180, 480, 66);
        panel.add(lblPagamento);

        JButton btnRetornar = new JButton("← Retornar");
        btnRetornar.setForeground(Color.WHITE);
        btnRetornar.setBackground(new Color(159, 80, 0));
        btnRetornar.setBounds(174, 274, 148, 30); // Ajuste a posição e o tamanho conforme necessário
        panel.add(btnRetornar);
        
        JButton btnPagamento = new JButton("Pagamento");
        btnPagamento.setForeground(Color.WHITE);
        btnPagamento.setBackground(new Color(159, 80, 0));
        btnPagamento.setBounds (357, 274, 148, 30);
        panel.add(btnPagamento);
        
        btnPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obter os detalhes da consulta
                    double valorConsulta = consulta.getValorConsulta();
                   String idConsulta = String.valueOf(consulta.getId());
                    
                    // Chamar a API do Mercado Pago para criar o pagamento
                    CriacaoPagamento api = new CriacaoPagamento(); // Suponha que você tenha uma classe para isso
                    String linkPagamento = api.criarPagamento("Consulta", valorConsulta, idConsulta);
                    
                    // Redirecionar para o link de pagamento
                    if (linkPagamento != null) {
                        // Abrir o link de pagamento no navegador padrão
                        Desktop.getDesktop().browse(new URI(linkPagamento));
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível gerar o link de pagamento.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao processar o pagamento.");
                }
            }
        });

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
