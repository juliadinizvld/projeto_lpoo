package ui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import pagamento.controladora.CriacaoPagamento;
import ui.entities.Produtos;

public class ProdutosPagamento extends JPanel {

	private static final long serialVersionUID = 1L;

	
	public ProdutosPagamento(Produtos produto) {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 808, 526);
		add(panel);
		panel.setLayout(null);

		JLabel tituloPagamento = new JLabel("Pagamento");
		tituloPagamento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloPagamento.setBounds(305, 11, 101, 25);
		panel.add(tituloPagamento);

		JLabel textoNomeDoProduto = new JLabel("Nome do produto: ");
		textoNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeDoProduto.setBounds(168, 98, 322, 25);
		panel.add(textoNomeDoProduto);

		JLabel textoQuantidadeSolicitada = new JLabel("Quantidade solicitada: ");
		textoQuantidadeSolicitada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoQuantidadeSolicitada.setBounds(168, 134, 322, 25);
		panel.add(textoQuantidadeSolicitada);

		JLabel textoConclusaoCompra = new JLabel(
				"<html>Para conclusão da compra é necessário realizar o pagamento, o valor total para pagamento é de R$ .  </html>");
		textoConclusaoCompra.setVerticalAlignment(SwingConstants.TOP);
		textoConclusaoCompra.setHorizontalAlignment(SwingConstants.CENTER);
		textoConclusaoCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoConclusaoCompra.setBounds(178, 170, 352, 94);
		panel.add(textoConclusaoCompra);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setBounds(168, 344, 117, 23);
		panel.add(botaoRetornar);
		
		JButton btnPaga = new JButton("Pagamento");
		btnPaga.setBackground(new Color(159, 80, 0));
		btnPaga.setForeground(new Color(255, 255, 255));
		btnPaga.setBounds(379, 344, 112, 23);
		panel.add(btnPaga);
		
		btnPaga.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Usar o produto selecionado
		            String nomeProduto = produto.getNome();
		            double precoProduto = produto.getValor();
		            
		            // Chamar a API do Mercado Pago para criar o pagamento
		            CriacaoPagamento api = new CriacaoPagamento(); // Suponha que você tenha uma classe para isso
		            String linkPagamento = api.criarPagamento(nomeProduto, precoProduto);
		            
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

		botaoRetornar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ProdutosInformacoesCompraProduto(produto));
				f.revalidate();

			}

		});

	}
}
