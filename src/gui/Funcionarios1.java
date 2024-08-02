package gui;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.border.EmptyBorder;

import model.services.ServicoAlterarTela;

public class Funcionarios1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNomeFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionarios1 frame = new Funcionarios1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Funcionarios1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 700, 500);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel tituloFuncionarios = new JLabel("Funcionários");
		tituloFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		tituloFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloFuncionarios.setBounds(272, 10, 150, 25);
		panel.add(tituloFuncionarios);

		JLabel textoNomeFuncionario = new JLabel("Nome do funcionário: ");
		textoNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeFuncionario.setBounds(120, 83, 182, 25);
		panel.add(textoNomeFuncionario);

		campoNomeFuncionario = new JTextField();
		campoNomeFuncionario.setBounds(302, 83, 267, 24);
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
		botaoPesquisarFuncionario.setBounds(251, 119, 171, 23);
		panel.add(botaoPesquisarFuncionario);

		JLabel textoFuncionariosEncontrados = new JLabel("Funcionários encontrados:");
		textoFuncionariosEncontrados.setHorizontalAlignment(SwingConstants.CENTER);
		textoFuncionariosEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoFuncionariosEncontrados.setBounds(215, 170, 267, 40);
		panel.add(textoFuncionariosEncontrados);

		JList listaFuncionariosEncontrados = new JList();
		listaFuncionariosEncontrados.setBounds(152, 232, 396, 158);
		panel.add(listaFuncionariosEncontrados);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setBounds(152, 433, 99, 21);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Home");
			}
		});

		JButton botaoAdicionarFuncionario = new JButton("<html>Adicionar<br>funcionário\r\n</html>");
		botaoAdicionarFuncionario.setBounds(302, 419, 85, 40);
		panel.add(botaoAdicionarFuncionario);

		botaoAdicionarFuncionario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ServicoAlterarTela.alterarTela(new Funcionarios2(), getLocation().x, getLocation().y);
				setVisible(false);
			}

		});

		JButton botaoVerificarFuncionario = new JButton("<html>Verificar <br>funcionário</html>");
		botaoVerificarFuncionario.setBounds(463, 419, 85, 40);
		panel.add(botaoVerificarFuncionario);

	}
}
