package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Home extends JPanel {

	private static final long serialVersionUID = 1L;
	public static Home telaInicial = new Home();

	/**
	 * Create the panel.
	 */
	public Home() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));

		setLayout(null);
		// Cria um painel para a barra de favoritos
		JPanel favoritesBarPanel = new JPanel();
		favoritesBarPanel.setBackground(new Color(192, 192, 192)); // Cor cinza escuro
		favoritesBarPanel.setPreferredSize(new Dimension(getWidth(), 30)); // Altura da barra de favoritos
		favoritesBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		// Cria e adiciona os botões "File" e "Options" na barra de favoritos
		JButton fileButton = new JButton("File");
		fileButton.setBackground(new Color(192, 192, 192));
		JButton optionsButton = new JButton("Options");
		optionsButton.setBackground(new Color(192, 192, 192));

		fileButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		optionsButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

		favoritesBarPanel.add(fileButton);
		favoritesBarPanel.add(optionsButton);

		// Cria um painel principal com um layout de coluna única
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 222, 222));
		panel.setLayout(null);

		// Cria os botões para opções
		JButton cadastroPetsButton = new JButton("Cadastro de pets");
		cadastroPetsButton.setForeground(new Color(255, 255, 255));
		cadastroPetsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cadastroPetsButton.setBackground(new Color(159, 80, 0));
		cadastroPetsButton.setBounds(295, 97, 200, 60);
		cadastroPetsButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
			f.setContentPane(new CadastroEscolha());
			f.revalidate();
		});

		JButton consultarPetsButton = new JButton("Consultar pets");
		consultarPetsButton.setForeground(new Color(255, 255, 255));
		consultarPetsButton.setBackground(new Color(159, 80, 0));
		consultarPetsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		consultarPetsButton.setBounds(295, 187, 200, 60);

		consultarPetsButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
			f.setContentPane(new ConsultaPets());
			f.revalidate();
		});

		JButton agendamentoProcedimentosButton = new JButton(
				"<html><div style='text-align: center;'>Agendamento de<br/>procedimentos</div></html>");
		agendamentoProcedimentosButton.setForeground(new Color(255, 255, 255));
		agendamentoProcedimentosButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		agendamentoProcedimentosButton.setBackground(new Color(159, 80, 0));
		agendamentoProcedimentosButton.setBounds(295, 270, 200, 64);
		agendamentoProcedimentosButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
			f.setContentPane(AgendamentoAgendarProcedimento.agendamento1);
			f.revalidate();
		});

		JButton consultaProdutosButton = new JButton(
				"<html><div style='text-align: center;'>Consulta de<br/><div style='padding-left: 5px;'>produtos</div></div></html>");
		consultaProdutosButton.setForeground(new Color(255, 255, 255));
		consultaProdutosButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		consultaProdutosButton.setBackground(new Color(159, 80, 0));
		consultaProdutosButton.setBounds(295, 360, 200, 60);
		consultaProdutosButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
			f.setContentPane(new ProdutosConsultaProduto());
			f.revalidate();
		});

		// Adiciona o slogan
		JLabel sloganLabel = new JLabel("Bem-vindos ao VetMed", JLabel.CENTER);
		sloganLabel.setBounds(181, 23, 431, 64);
		sloganLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		sloganLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(sloganLabel);

		// Adiciona os botões ao painel principal
		add(cadastroPetsButton);
		add(consultarPetsButton);
		add(agendamentoProcedimentosButton);
		add(consultaProdutosButton);

		// Cria um painel para conter a barra de favoritos e o painel principal
		JPanel containerPanel = new JPanel();
		containerPanel.setLayout(new BorderLayout());
		add(favoritesBarPanel, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);

		// Adiciona o painel de contêiner à janela
		add(containerPanel);

		JMenuBar menuAdministrador = new JMenuBar();
		menuAdministrador.setBackground(new Color(249, 220, 189));
		menuAdministrador.setBounds(0, 0, 800, 22);
		add(menuAdministrador);

		JMenu mnNewMenu = new JMenu("Adicionar/consultar");
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		menuAdministrador.add(mnNewMenu);

		JMenuItem menuItemProduto = new JMenuItem("Produto");
		mnNewMenu.add(menuItemProduto);

		menuItemProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ProdutosPesquisaProduto());
				f.revalidate();
			}
		});

		JMenuItem menuItemFuncionario = new JMenuItem("Funcionario");
		mnNewMenu.add(menuItemFuncionario);

		menuItemFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new FuncionariosConsultaFuncionario());
				f.revalidate();
			}
		});

		JMenu mnNewMenu_1 = new JMenu("Informações");
		mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 12));
		menuAdministrador.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sobre");
		mnNewMenu_1.add(mntmNewMenuItem_2);
	}
}
