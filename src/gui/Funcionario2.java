package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class Funcionario2 extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField campoEspecialidade;
	private JTextField campoRmv;
	private JTextField campoNomeFuncionario;
	private JTextField campoCpf;

	/**
	 * Create the panel.
	 */
	public Funcionario2() {
		setLayout(null);
		MaskFormatter mfIdade = null;
		MaskFormatter mfCpf = null;
		MaskFormatter mfCrmv = null;
		try {
			mfIdade = new MaskFormatter("##");
			mfCpf = new MaskFormatter("###.###.###-##");
			mfCrmv = new MaskFormatter("CRM/UU#####-##");
		} catch (ParseException e) {
			e.getStackTrace();
		}

		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 700, 500);
		add(panel);
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
		campoNomeFuncionario.setFont(new Font("Dialog", Font.PLAIN, 14));
		campoNomeFuncionario.setBounds(306, 90, 278, 22);
		panel.add(campoNomeFuncionario);
		campoNomeFuncionario.setColumns(10);

		JLabel textoIdade = new JLabel("Idade:");
		textoIdade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoIdade.setBounds(137, 131, 62, 20);
		panel.add(textoIdade);

		JFormattedTextField campoIdade = new JFormattedTextField(mfIdade);
		campoIdade.setToolTipText("");
		campoIdade.setFont(new Font("Dialog", Font.PLAIN, 14));
		campoIdade.setBounds(203, 131, 62, 22);
		campoIdade.setColumns(10);
		panel.add(campoIdade);

		JLabel textoCpf = new JLabel("CPF: ");
		textoCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoCpf.setBounds(137, 162, 46, 25);
		panel.add(textoCpf);

		campoCpf = new JFormattedTextField(mfCpf);
		campoCpf.setFont(new Font("Dialog", Font.PLAIN, 14));
		campoCpf.setBounds(193, 162, 111, 25);
		panel.add(campoCpf);
		campoCpf.setColumns(10);

		JLabel textoFuncao = new JLabel("Função:");
		textoFuncao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoFuncao.setBounds(137, 198, 56, 20);
		panel.add(textoFuncao);

		String[] funcoes = { "", "Médico Veterinário", "Atendente", "Vendedor" };
		JComboBox<String> selectFuncao = new JComboBox<String>(funcoes);
		selectFuncao.setFont(new Font("Dialog", Font.PLAIN, 14));
		selectFuncao.setBounds(203, 198, 149, 23);
		panel.add(selectFuncao);

		JLabel textoEspecialidade = new JLabel("Especialidade:");
		textoEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoEspecialidade.setBounds(137, 229, 109, 20);
		panel.add(textoEspecialidade);

		campoEspecialidade = new JTextField();
		campoEspecialidade.setFont(new Font("Dialog", Font.PLAIN, 14));
		campoEspecialidade.setBounds(249, 229, 260, 25);
		panel.add(campoEspecialidade);
		campoEspecialidade.setColumns(10);
		campoEspecialidade.setEditable(false);

		JLabel textoRmv = new JLabel("RMV:");
		textoRmv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoRmv.setBounds(137, 260, 62, 20);
		panel.add(textoRmv);

		campoRmv = new JFormattedTextField(mfCrmv);
		campoRmv.setFont(new Font("Dialog", Font.PLAIN, 14));
		campoRmv.setBounds(206, 260, 120, 25);
		panel.add(campoRmv);
		campoRmv.setColumns(10);
		campoRmv.setEditable(false);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setBounds(225, 341, 120, 21);
		panel.add(botaoRetornar);

		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(400, 340, 109, 23);
		panel.add(botaoConfirmar);

		botaoConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(campoNomeFuncionario.getText());
				System.out.println(campoIdade.getText());
				System.out.println(campoCpf.getText());
				if (selectFuncao.getSelectedItem() == "Médico Veterinário")
					;
				{
					System.out.println(selectFuncao.getSelectedItem());
					System.out.println(campoEspecialidade.getText());
					System.out.println(campoRmv.getText());
				}

			}
		});

		ActionListener verificarFuncao = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectFuncao.getSelectedItem() != "Médico Veterinário") {
					campoEspecialidade.setEditable(false);
					campoEspecialidade.setText("");
					campoRmv.setEditable(false);
					campoRmv.setText("");
				} else {
					campoEspecialidade.setEditable(true);
					campoRmv.setEditable(true);
				}
			}
		};

		selectFuncao.addActionListener(verificarFuncao);
		botaoRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(Funcionario1.funcionario1);
				f.revalidate();
			}
		});
	}
}
