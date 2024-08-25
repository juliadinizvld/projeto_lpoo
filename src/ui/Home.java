package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Home extends JPanel {

	private static final long serialVersionUID = 1L;

	public Home() {
		setLayout(new BorderLayout());

		// Painel principal
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(222, 222, 222));
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbcMain = new GridBagConstraints();
		gbcMain.insets = new Insets(10, 10, 10, 10);
		gbcMain.anchor = GridBagConstraints.CENTER;
		gbcMain.fill = GridBagConstraints.HORIZONTAL;

		// Título
		JLabel sloganLabel = new JLabel("Bem-vindos ao VetMed", JLabel.CENTER);
		sloganLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		gbcMain.gridwidth = 2;
		gbcMain.gridy = 0;
		mainPanel.add(sloganLabel, gbcMain);

		// Botão Cadastro de Pets
		JButton cadastroPetsButton = new JButton("Cadastro de pets");
		cadastroPetsButton.setForeground(Color.WHITE);
		cadastroPetsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cadastroPetsButton.setBackground(new Color(159, 80, 0));
		gbcMain.gridwidth = 1;
		gbcMain.gridy++;
		gbcMain.weightx = 1.0;
		gbcMain.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(cadastroPetsButton, gbcMain);
		cadastroPetsButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
			f.setContentPane(new CadastroEscolha());
			f.revalidate();
		});

		// Botão Consultar Pets
		JButton consultarPetsButton = new JButton("Consultar pets");
		consultarPetsButton.setForeground(Color.WHITE);
		consultarPetsButton.setBackground(new Color(159, 80, 0));
		consultarPetsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gbcMain.gridy++;
		mainPanel.add(consultarPetsButton, gbcMain);
		consultarPetsButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
			f.setContentPane(new ConsultaPets());
			f.revalidate();
		});

		// Botão Agendamento de Procedimentos
		JButton agendamentoProcedimentosButton = new JButton(
				"<html><div style='text-align: center;'>Agendamento de<br/>procedimentos</div></html>");
		agendamentoProcedimentosButton.setForeground(Color.WHITE);
		agendamentoProcedimentosButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		agendamentoProcedimentosButton.setBackground(new Color(159, 80, 0));
		gbcMain.gridy++;
		mainPanel.add(agendamentoProcedimentosButton, gbcMain);
		agendamentoProcedimentosButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
			f.setContentPane(AgendamentoAgendarProcedimento.agendamento1);
			f.revalidate();
		});

		// Botão Consulta de Produtos
		JButton consultaProdutosButton = new JButton(
				"<html><div style='text-align: center;'>Consulta de<br/><div style='padding-left: 5px;'>produtos</div></div></html>");
		consultaProdutosButton.setForeground(Color.WHITE);
		consultaProdutosButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		consultaProdutosButton.setBackground(new Color(159, 80, 0));
		gbcMain.gridy++;
		mainPanel.add(consultaProdutosButton, gbcMain);
		consultaProdutosButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
			f.setContentPane(new ProdutosConsultaProduto());
			f.revalidate();
		});

		add(mainPanel, BorderLayout.CENTER);

		// Menu
		JMenuBar menuAdministrador = new JMenuBar();
		menuAdministrador.setBackground(new Color(249, 220, 189));
		JMenu mnNewMenu = new JMenu("Adicionar/consultar");
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 12));
		menuAdministrador.add(mnNewMenu);

		JMenuItem menuItemProduto = new JMenuItem("Produto");
		mnNewMenu.add(menuItemProduto);
		menuItemProduto.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
			f.setContentPane(new ProdutosPesquisaProduto());
			f.revalidate();
		});

		JMenuItem menuItemFuncionario = new JMenuItem("Funcionario");
		mnNewMenu.add(menuItemFuncionario);
		menuItemFuncionario.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
			f.setContentPane(new FuncionariosConsultaFuncionario());
			f.revalidate();
		});

		JMenuItem menuItemTutor = new JMenuItem("Tutor");
		mnNewMenu.add(menuItemTutor);
		menuItemTutor.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
			f.setContentPane(new TutorConsultaTutor());
			f.revalidate();
		});

		JMenu mnNewMenu_1 = new JMenu("Informações");
		mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 12));
		menuAdministrador.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sobre");
		mnNewMenu_1.add(mntmNewMenuItem_2);

		mntmNewMenuItem_2.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, mainPanel);
			f.setContentPane(new Sobre());
			f.revalidate();
		});

		add(menuAdministrador, BorderLayout.NORTH);
	}
}
