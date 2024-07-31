package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.services.RetornarPaginaServico;

public class Funcionarios2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoIdade;
	private JTextField campoFuncao;
	private JTextField campoEspecialidade;
	private JTextField campoRmv;
	private JTextField campoNomeFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionarios2 frame = new Funcionarios2();
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
	public Funcionarios2() {
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

		JLabel tituloNovoFuncionario = new JLabel("Novo funcionário");
		tituloNovoFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		tituloNovoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloNovoFuncionario.setBounds(216, 10, 253, 25);
		panel.add(tituloNovoFuncionario);

		JLabel textoNomeDoFuncionario = new JLabel("Nome do funcionário:");
		textoNomeDoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeDoFuncionario.setBounds(137, 90, 167, 20);
		panel.add(textoNomeDoFuncionario);

		campoNomeFuncionario = new JTextField();
		campoNomeFuncionario.setBounds(306, 90, 278, 22);
		panel.add(campoNomeFuncionario);
		campoNomeFuncionario.setColumns(10);

		JLabel textoIdade = new JLabel("Idade:");
		textoIdade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoIdade.setBounds(137, 131, 62, 20);
		panel.add(textoIdade);

		campoIdade = new JTextField();
		campoIdade.setBounds(203, 131, 62, 22);
		panel.add(campoIdade);
		campoIdade.setColumns(10);

		JLabel textoFuncao = new JLabel("Função:");
		textoFuncao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoFuncao.setBounds(137, 172, 72, 20);
		panel.add(textoFuncao);

		campoFuncao = new JTextField();
		campoFuncao.setBounds(208, 172, 245, 22);
		panel.add(campoFuncao);
		campoFuncao.setColumns(10);

		JLabel textoEspecialidade = new JLabel("Especialidade:");
		textoEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoEspecialidade.setBounds(137, 216, 109, 20);
		panel.add(textoEspecialidade);

		campoEspecialidade = new JTextField();
		campoEspecialidade.setBounds(249, 213, 260, 25);
		panel.add(campoEspecialidade);
		campoEspecialidade.setColumns(10);

		JLabel textoRmv = new JLabel("RMV:");
		textoRmv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoRmv.setBounds(137, 258, 62, 20);
		panel.add(textoRmv);

		campoRmv = new JTextField();
		campoRmv.setBounds(203, 255, 167, 25);
		panel.add(campoRmv);
		campoRmv.setColumns(10);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setBounds(225, 341, 120, 21);
		panel.add(botaoRetornar);

		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(400, 340, 109, 23);
		panel.add(botaoConfirmar);

		botaoRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int positionX = getLocation().x;
				int positionY = getLocation().y;
				RetornarPaginaServico.returnPage(new Funcionarios1(), positionX, positionY);
				setVisible(false);
			}
		});
	}
}
