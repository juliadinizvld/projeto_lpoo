package gui;

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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Funcionario3 extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Funcionario3() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 821, 500);
		add(panel);
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
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(Funcionario1.funcionario1);
				f.revalidate();
			}
		});
		botaoRetornar.setBounds(264, 306, 122, 21);
		panel.add(botaoRetornar);
	}
};
