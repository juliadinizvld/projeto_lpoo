package gui;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Funcionario1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNomeFuncionario;

	/**
	 * Create the panel.
	 */
	public Funcionario1() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JLabel tituloFuncionarios = new JLabel("Funcionários");
		tituloFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		tituloFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloFuncionarios.setBounds(320, 11, 150, 25);
		panel.add(tituloFuncionarios);

		JLabel textoNomeFuncionario = new JLabel("Nome do funcionário: ");
		textoNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeFuncionario.setBounds(165, 83, 182, 25);
		panel.add(textoNomeFuncionario);

		campoNomeFuncionario = new JTextField();
		campoNomeFuncionario.setBounds(347, 83, 267, 24);
		panel.add(campoNomeFuncionario);
		campoNomeFuncionario.setColumns(10);

		campoNomeFuncionario.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					String nomeFuncionario = campoNomeFuncionario.getText();
					System.out.println(nomeFuncionario);
				}
			}
		});

		JButton botaoPesquisarFuncionario = new JButton("Pesquisar Funcionario");
		botaoPesquisarFuncionario.setBounds(299, 119, 171, 23);
		panel.add(botaoPesquisarFuncionario);

		JLabel textoFuncionariosEncontrados = new JLabel("Funcionários encontrados:");
		textoFuncionariosEncontrados.setHorizontalAlignment(SwingConstants.CENTER);
		textoFuncionariosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoFuncionariosEncontrados.setBounds(254, 167, 267, 40);
		panel.add(textoFuncionariosEncontrados);

		JList listaFuncionariosEncontrados = new JList();
		listaFuncionariosEncontrados.setBounds(196, 232, 396, 158);
		panel.add(listaFuncionariosEncontrados);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setBounds(196, 426, 99, 21);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Home");
				/*
				 * JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				 * f.setContentPane(new Fun3()); f.revalidate();
				 */
			}
		});

		JButton botaoAdicionarFuncionario = new JButton("<html>Adicionar<br>funcionário\r\n</html>");
		botaoAdicionarFuncionario.setBounds(346, 412, 85, 40);
		panel.add(botaoAdicionarFuncionario);

		botaoAdicionarFuncionario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Funcionario2());
				f.revalidate();
			}

		});

		JButton botaoVerificarFuncionario = new JButton("<html>Verificar <br>funcionário</html>");
		botaoVerificarFuncionario.setBounds(507, 412, 85, 40);
		panel.add(botaoVerificarFuncionario);

		botaoVerificarFuncionario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Funcionario3());
				f.revalidate();
			}

		});

	}
}
