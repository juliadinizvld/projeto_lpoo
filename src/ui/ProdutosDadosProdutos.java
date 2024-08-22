package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ui.entities.Produtos;

import java.awt.Color;

public class ProdutosDadosProdutos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ProdutosDadosProdutos(Produtos produtos) {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 677, 391);
		add(panel);
		panel.setLayout(null);

		JLabel textId = new JLabel("Id:");
		textId.setBounds(10, 73, 168, 14);
		panel.add(textId);

		JLabel textNomeProduto = new JLabel(" Nome do Produto:");
		textNomeProduto.setBounds(10, 115, 168, 14);
		panel.add(textNomeProduto);

		JLabel textTipo = new JLabel(" Tipo: ");
		textTipo.setBounds(10, 163, 168, 14);
		panel.add(textTipo);

		JLabel textQuantidade = new JLabel("Quantidade:");
		textQuantidade.setBounds(10, 198, 168, 14);
		panel.add(textQuantidade);

		JLabel textValor = new JLabel(" Valor:");
		textValor.setBounds(10, 238, 122, 14);
		panel.add(textValor);
		
		JLabel lblDadosdeProdutos = new JLabel("Dados do Produto ");
		lblDadosdeProdutos.setBounds(307, 21, 249, 23);
		panel.add(lblDadosdeProdutos);
		
		JButton botaoRetornar = new JButton("Retornar");
		botaoRetornar.setBounds(302, 285, 85, 21);
		panel.add(botaoRetornar);
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ProdutosDadosProdutos(produtos));
				f.revalidate();
			}
		});

		panel.add(botaoRetornar);


	
	}
}
