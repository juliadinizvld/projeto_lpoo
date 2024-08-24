package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import javax.swing.JOptionPane;
import ui.entities.Produtos;
import business.BDServices;

public class ProdutosDadosProdutos extends JPanel {

	private static final long serialVersionUID = 1L;

	public ProdutosDadosProdutos(Produtos produtos) {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 677, 391);
		add(panel);
		panel.setLayout(null);

		JLabel textId = new JLabel("Id: " + produtos.getId());
		textId.setBounds(10, 73, 168, 14);
		panel.add(textId);

		JLabel textNomeProduto = new JLabel(" Nome do Produto: " + produtos.getNome());
		textNomeProduto.setBounds(10, 115, 168, 14);
		panel.add(textNomeProduto);

		JLabel textTipo = new JLabel(" Tipo: " + produtos.getTipo());
		textTipo.setBounds(10, 163, 168, 14);
		panel.add(textTipo);

		JLabel textQuantidade = new JLabel("Quantidade: " + produtos.getQuantidade());
		textQuantidade.setBounds(10, 198, 168, 14);
		panel.add(textQuantidade);

		JLabel textValor = new JLabel(" Valor: " + produtos.getValor());
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
				f.setContentPane(new ProdutosPesquisaProduto());
				f.revalidate();
			}
		});

		JButton botaoRemover = new JButton("Remover");
		botaoRemover.setBounds(400, 285, 85, 21);
		panel.add(botaoRemover);
		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja remover este produto?",
						"Confirmar Remoção", JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {
					BDServices.removerProduto(produtos.getId());
					JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
					JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
					f.setContentPane(new ProdutosPesquisaProduto());
					f.revalidate();
				}
			}
		});
	}
}
