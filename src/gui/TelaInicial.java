package gui;

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

public class TelaInicial extends JPanel {

	private static final long serialVersionUID = 1L;
	public static TelaInicial telaInicial = new TelaInicial();

	/**
	 * Create the panel.
	 */
	public TelaInicial() {

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
		cadastroPetsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cadastroPetsButton.setBackground(new Color(192, 192, 192));
		cadastroPetsButton.setBounds(295, 97, 200, 60);
		cadastroPetsButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
			f.setContentPane(new TelaCadastro1());
			f.revalidate();
		});

		JButton consultarPetsButton = new JButton("Consultar pets");
		consultarPetsButton.setBackground(new Color(192, 192, 192));
		consultarPetsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		consultarPetsButton.setBounds(295, 187, 200, 60);
		
		consultarPetsButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
			f.setContentPane(new ConsultaPets1());
			f.revalidate();
		});
		
		JButton agendamentoProcedimentosButton = new JButton(
				"<html><div style='text-align: center;'>Agendamento de<br/>procedimentos</div></html>");
		agendamentoProcedimentosButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		agendamentoProcedimentosButton.setBackground(new Color(192, 192, 192));
		agendamentoProcedimentosButton.setBounds(293, 275, 200, 64);
		agendamentoProcedimentosButton.addActionListener(e -> {
			// Ação para agendamento de procedimentos
		});

		JButton consultaProdutosButton = new JButton(
				"<html><div style='text-align: center;'>Consulta de<br/><div style='padding-left: 5px;'>produtos</div></div></html>");
		consultaProdutosButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		consultaProdutosButton.setBackground(new Color(192, 192, 192));
		consultaProdutosButton.setBounds(295, 360, 200, 60);
		consultaProdutosButton.addActionListener(e -> {
			JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
			f.setContentPane(new Produto1());
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
	};
}
