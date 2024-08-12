package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.services.ServicoAlterarTela;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Funcionarios3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionarios3 frame = new Funcionarios3();
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
	public Funcionarios3() {
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

		JLabel tituloConsultaFuncionario = new JLabel("Consulta funcionário");
		tituloConsultaFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		tituloConsultaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloConsultaFuncionario.setBounds(216, 23, 236, 25);
		panel.add(tituloConsultaFuncionario);

		JLabel textoNomeDoFuncionario = new JLabel("Nome do funcionário: ");
		textoNomeDoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeDoFuncionario.setBounds(103, 79, 190, 25);
		panel.add(textoNomeDoFuncionario);

		JLabel textoIdade = new JLabel("Idade: ");
		textoIdade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoIdade.setBounds(103, 123, 96, 20);
		panel.add(textoIdade);

		JLabel textoFuncao = new JLabel("Função: ");
		textoFuncao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoFuncao.setBounds(103, 162, 78, 25);
		panel.add(textoFuncao);

		JLabel textoEspecialidade = new JLabel("Especialidade: ");
		textoEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoEspecialidade.setBounds(103, 201, 133, 20);
		panel.add(textoEspecialidade);

		JLabel textoRmv = new JLabel("RMV: ");
		textoRmv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoRmv.setBounds(103, 244, 96, 20);
		panel.add(textoRmv);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int positionX = getLocation().x;
				int positionY = getLocation().y;
				ServicoAlterarTela.alterarTela(new Funcionarios1(), positionX, positionY);
				setVisible(false);
			}
		});
		botaoRetornar.setBounds(264, 306, 122, 21);
		panel.add(botaoRetornar);
	}

}
