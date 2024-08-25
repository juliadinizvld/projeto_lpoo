package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ProdutosInformacoesProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botaoRetornar;
	public static ProdutosInformacoesProdutos produtosInformacoesProdutos = new ProdutosInformacoesProdutos();
	
	/**
	 * Create the panel.
	 */
	public ProdutosInformacoesProdutos() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(-73, -114, 700, 500);
		add(panel);
		panel.setLayout(null);

		JLabel tituloInformacoesDoProduto = new JLabel("Informações do produto");
		tituloInformacoesDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloInformacoesDoProduto.setBounds(229, 11, 213, 30);
		panel.add(tituloInformacoesDoProduto);

		JLabel textoNomeDoProduto = new JLabel("Nome do produto: ");
		textoNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeDoProduto.setBounds(129, 80, 137, 30);
		panel.add(textoNomeDoProduto);

		JLabel textoQuantidadeEmEstoque = new JLabel("Quantidade em estoque: ");
		textoQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoQuantidadeEmEstoque.setBounds(128, 117, 200, 30);
		panel.add(textoQuantidadeEmEstoque);

		JLabel textoValorUnitario = new JLabel("Valor unitário: ");
		textoValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoValorUnitario.setBounds(129, 158, 107, 30);
		panel.add(textoValorUnitario);

		JLabel textoQuantidadeDesejada = new JLabel("Selecione a quantidade desejada: ");
		textoQuantidadeDesejada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoQuantidadeDesejada.setBounds(129, 199, 240, 30);
		panel.add(textoQuantidadeDesejada);
		
		JComboBox SelectQuantidadeDesejada = new JComboBox();
		SelectQuantidadeDesejada.setBounds(392, 205, 59, 22);
		panel.add(SelectQuantidadeDesejada);

		botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setBounds(170, 345, 131, 36);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(ProdutosConsultaProduto.produto1);
				f.revalidate();
				
			}
			
		});
		
		JButton botaoFazerPedido = new JButton("Fazer pedido");
		botaoFazerPedido.setBackground(new Color(159, 80, 0));
		botaoFazerPedido.setForeground(new Color(255, 255, 255));
		botaoFazerPedido.setBounds(335, 345, 150, 36);
		panel.add(botaoFazerPedido);
		
		botaoFazerPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ProdutosPagamento());
				f.revalidate();
				
			}
			
		});
		
	}
}
