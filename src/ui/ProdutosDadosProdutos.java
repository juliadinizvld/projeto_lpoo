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

	public ProdutosDadosProdutos(Produtos produto) {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 108, 805, 552);
		add(panel);
		panel.setLayout(null);

		JLabel textId = new JLabel("Id: " + produto.getId());
		textId.setBounds(121, 83, 168, 14);
		panel.add(textId);

		JLabel textNomeProduto = new JLabel(" Nome do Produto: " + produto.getNome());
		textNomeProduto.setBounds(121, 125, 168, 14);
		panel.add(textNomeProduto);

		JLabel textTipo = new JLabel(" Tipo: " + produto.getTipo());
		textTipo.setBounds(121, 173, 168, 14);
		panel.add(textTipo);

		JLabel textQuantidade = new JLabel("Quantidade: " + produto.getQuantidade());
		textQuantidade.setBounds(121, 208, 168, 14);
		panel.add(textQuantidade);

		JLabel textValor = new JLabel(" Valor: " + produto.getValor());
		textValor.setBounds(121, 248, 122, 14);
		panel.add(textValor);

		JLabel lblDadosdeProdutos = new JLabel("Dados do Produto ");
		lblDadosdeProdutos.setBounds(307, 21, 249, 23);
		panel.add(lblDadosdeProdutos);

		JButton botaoRetornar = new JButton("Retornar");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setBounds(199, 318, 85, 35);
		panel.add(botaoRetornar);
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ProdutosPesquisaProduto());
				f.revalidate();
			}
		});

		JButton botaoRemover = new JButton("Remover");
		botaoRemover.setForeground(new Color(255, 255, 255));
		botaoRemover.setBackground(new Color(159, 80, 0));
		botaoRemover.setBounds(314, 318, 85, 35);
		panel.add(botaoRemover);
		
		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja remover este produto?",
						"Confirmar Remoção", JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {
					BDServices.removerProduto(produto.getId());
					JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
					JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
					f.setContentPane(new ProdutosPesquisaProduto());
					f.revalidate();
				}
			}
		});

		JButton botaoAtualizarProduto = new JButton("Atualizar Produto");
		botaoAtualizarProduto.setForeground(new Color(255, 255, 255));
		botaoAtualizarProduto.setBackground(new Color(159, 80, 0));
		botaoAtualizarProduto.setBounds(427, 318, 214, 35);
		panel.add(botaoAtualizarProduto);
		botaoAtualizarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new AtualizacaoAtualizarCadastroProduto(produto));
				f.revalidate();
			}
		});
	}
}
