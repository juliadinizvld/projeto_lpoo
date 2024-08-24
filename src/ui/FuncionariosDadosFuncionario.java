package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import business.BDServices;
import ui.entities.Funcionarios;
import java.awt.Color;

public class FuncionariosDadosFuncionario extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public FuncionariosDadosFuncionario(Funcionarios funcionario) {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(-11, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JLabel tituloConsultaFuncionario = new JLabel("Consulta funcionário");
		tituloConsultaFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		tituloConsultaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloConsultaFuncionario.setBounds(279, 11, 236, 25);
		panel.add(tituloConsultaFuncionario);

		JLabel textoNomeFuncionario = new JLabel("Nome do funcionário: " + funcionario.getNome());
		textoNomeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeFuncionario.setBounds(103, 69, 588, 25);
		panel.add(textoNomeFuncionario);

		JLabel textoIdadeFuncionario = new JLabel("Idade: " + String.valueOf(funcionario.getIdade()));
		textoIdadeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoIdadeFuncionario.setBounds(103, 289, 122, 20);
		panel.add(textoIdadeFuncionario);

		JLabel textoFuncaoFuncionario = new JLabel("Função: " + funcionario.getTipoFuncionario());
		textoFuncaoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoFuncaoFuncionario.setBounds(103, 145, 240, 25);
		panel.add(textoFuncaoFuncionario);

		JLabel textoEspecialidadeFuncionario = new JLabel("Especialidade: ");
		textoEspecialidadeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoEspecialidadeFuncionario.setBounds(103, 320, 199, 20);
		panel.add(textoEspecialidadeFuncionario);

		JLabel textoRmvFuncionario = new JLabel("RMV: ");
		textoRmvFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoRmvFuncionario.setBounds(103, 351, 199, 20);
		panel.add(textoRmvFuncionario);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new FuncionariosConsultaFuncionario());
				f.revalidate();
			}
		});
		botaoRetornar.setBounds(253, 428, 122, 21);
		panel.add(botaoRetornar);

		JLabel textoIdFuncionario = new JLabel("ID do funcionário: " + String.valueOf(funcionario.getId()));
		textoIdFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoIdFuncionario.setBounds(103, 109, 199, 25);
		panel.add(textoIdFuncionario);

		JLabel textoTelefoneFuncionario = new JLabel("Telefone: " + funcionario.getTelefone());
		textoTelefoneFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoTelefoneFuncionario.setBounds(103, 181, 199, 25);
		panel.add(textoTelefoneFuncionario);

		JLabel textoCpfFuncionario = new JLabel("CPF: " + funcionario.getCpf());
		textoCpfFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoCpfFuncionario.setBounds(103, 217, 199, 25);
		panel.add(textoCpfFuncionario);

		JLabel textoSexoFuncionario = new JLabel("Sexo: " + funcionario.getSexo());
		textoSexoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoSexoFuncionario.setBounds(103, 253, 199, 25);
		panel.add(textoSexoFuncionario);

		JLabel textoCepFuncionario = new JLabel("Cep: " + funcionario.getCep());
		textoCepFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoCepFuncionario.setBounds(389, 105, 199, 25);
		panel.add(textoCepFuncionario);

		JLabel textoNumeroCasaFuncionario = new JLabel("Numero da casa: " + funcionario.getNumeroCasa());
		textoNumeroCasaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNumeroCasaFuncionario.setBounds(389, 141, 269, 25);
		panel.add(textoNumeroCasaFuncionario);

		JLabel textoRuaFuncionario = new JLabel("Rua: " + funcionario.getRua());
		textoRuaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoRuaFuncionario.setBounds(389, 177, 269, 25);
		panel.add(textoRuaFuncionario);

		JLabel textoBairroFuncionario = new JLabel("Bairro: " + funcionario.getBairro());
		textoBairroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoBairroFuncionario.setBounds(389, 213, 269, 25);
		panel.add(textoBairroFuncionario);

		JLabel textoEstadoFuncionario = new JLabel("Estado: " + funcionario.getEstado());
		textoEstadoFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoEstadoFuncionario.setBounds(389, 247, 269, 25);
		panel.add(textoEstadoFuncionario);

		JLabel textoCidadeFuncionario = new JLabel("Cidade: " + funcionario.getCidade());
		textoCidadeFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoCidadeFuncionario.setBounds(389, 283, 269, 25);
		panel.add(textoCidadeFuncionario);

		JButton botaoRemover = new JButton("Remover Funcionário");
		botaoRemover.setForeground(Color.WHITE);
		botaoRemover.setBackground(new Color(159, 80, 0));
		botaoRemover.setBounds(413, 428, 173, 21);
		panel.add(botaoRemover);

		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja remover este funcionario?",
						"Confirmar Remoção", JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {
					BDServices.removerFuncionario(funcionario.getId());
					JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso!");
					JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
					f.setContentPane(new FuncionariosConsultaFuncionario());
					f.revalidate();
				}
			}
		});
	}
};
