package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import business.BDServices;
import ui.entities.Tutores;

public class CadastroCadastroTutor extends JPanel {

	private static final long serialVersionUID = 1L;
	public static CadastroCadastroTutor cadastroTutor = new CadastroCadastroTutor();
	private static JTextField campoTelefone;
	private static JTextField campoDataNascimento;
	private static JTextField campoCep;
	private static JTextField campoNumeroCasa;
	private static JTextField campoBairro;
	private static JTextField campoRua;
	private static JTextField campoEmail;
	private static JTextField campoNome;
	private static JTextField campoCidade;

	/**
	 * Create the panel.
	 */
	public CadastroCadastroTutor() {

		SimpleDateFormat fmtBr = new SimpleDateFormat("dd/MM/yyyy");

		MaskFormatter mfcpf = null;
		MaskFormatter mfDataNascimento = null;
		MaskFormatter mfTelefone = null;
		MaskFormatter mfEstado = null;

		try {
			mfcpf = new MaskFormatter("###.###.###-##");
			mfDataNascimento = new MaskFormatter("##/##/####");
			mfTelefone = new MaskFormatter("### #####-####");
			mfEstado = new MaskFormatter("UU");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		setLayout(null);
		// Cria um painel principal com um layout de BorderLayout
		JPanel panel = new JPanel();
		panel.setBounds(45, 0, 700, 500);
		add(panel);
		panel.setLayout(null);

		// Adiciona os componentes
		JLabel lblNewLabel = new JLabel("Dados do tutor:");
		lblNewLabel.setBounds(332, 32, 373, 22);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel);

		JLabel lblCPF = new JLabel("CPF :");
		lblCPF.setBounds(200, 126, 45, 13);
		lblCPF.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblCPF);

		JLabel lblNomeCompleto = new JLabel("Nome Completo :");
		lblNomeCompleto.setBounds(200, 87, 98, 13);
		lblNomeCompleto.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblNomeCompleto);

		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setBounds(200, 156, 45, 13);
		lblSexo.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblSexo);

		JLabel lblDataNascimento = new JLabel("Data de nascimento :");
		lblDataNascimento.setBounds(397, 126, 114, 13);
		lblDataNascimento.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblDataNascimento);

		JLabel lblTelefone = new JLabel("Telefone :");
		lblTelefone.setBounds(413, 149, 74, 13);
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblTelefone);

		JLabel lblCidade = new JLabel("Cidade : ");
		lblCidade.setBounds(200, 309, 56, 13);
		lblCidade.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblCidade);

		JLabel lblCep = new JLabel("CEP :");
		lblCep.setBounds(200, 233, 45, 13);
		lblCep.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblCep);

		JLabel lblRua = new JLabel("Rua/Av");
		lblRua.setBounds(397, 236, 45, 13);
		lblRua.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblRua);

		JLabel lblBairro = new JLabel("Bairro :");
		lblBairro.setBounds(200, 273, 45, 13);
		lblBairro.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblBairro);

		JLabel lblNumero = new JLabel("Número : ");
		lblNumero.setBounds(397, 273, 56, 13);
		lblNumero.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblNumero);

		campoTelefone = new JFormattedTextField(mfTelefone);
		campoTelefone.setBounds(521, 146, 96, 19);
		panel.add(campoTelefone);
		campoTelefone.setColumns(10);

		campoDataNascimento = new JFormattedTextField(mfDataNascimento);
		campoDataNascimento.setBounds(521, 123, 96, 19);
		panel.add(campoDataNascimento);
		campoDataNascimento.setColumns(10);

		campoCep = new JTextField();
		campoCep.setBounds(255, 230, 96, 19);
		panel.add(campoCep);
		campoCep.setColumns(10);

		campoNumeroCasa = new JTextField();
		campoNumeroCasa.setBounds(447, 273, 40, 19);
		panel.add(campoNumeroCasa);
		campoNumeroCasa.setColumns(10);

		campoBairro = new JTextField();
		campoBairro.setBounds(255, 270, 96, 19);
		panel.add(campoBairro);
		campoBairro.setColumns(10);

		campoRua = new JTextField();
		campoRua.setBounds(457, 230, 96, 19);
		panel.add(campoRua);
		campoRua.setColumns(10);

		JButton btnRetornar = new JButton("Retornar ");
		btnRetornar.setBounds(255, 448, 112, 37);
		panel.add(btnRetornar);

		btnRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new CadastroEscolha());
				f.revalidate();
			}
		});

		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setBounds(436, 448, 148, 37);
		panel.add(btnAvancar);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(200, 188, 45, 13);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 10));
		panel.add(lblEmail);

		campoEmail = new JTextField();
		campoEmail.setBounds(239, 188, 189, 16);
		campoEmail.setColumns(10);
		panel.add(campoEmail);

		campoNome = new JTextField();
		campoNome.setBounds(296, 84, 304, 19);
		campoNome.setColumns(10);
		panel.add(campoNome);

		String[] sexos = { "Masculino", "Feminino" };
		JComboBox<String> selectSexo = new JComboBox<String>(sexos);
		selectSexo.setFont(new Font("Dialog", Font.PLAIN, 14));
		selectSexo.setBounds(239, 150, 112, 21);
		panel.add(selectSexo);

		campoCidade = new JTextField();
		campoCidade.setBounds(255, 306, 96, 19);
		campoCidade.setColumns(10);
		panel.add(campoCidade);

		JFormattedTextField campoCpf = new JFormattedTextField(mfcpf);
		campoCpf.setBounds(239, 123, 112, 19);
		panel.add(campoCpf);

		JFormattedTextField campoEstado = new JFormattedTextField(mfEstado);
		campoEstado.setToolTipText("");
		campoEstado.setBounds(446, 305, 41, 20);
		panel.add(campoEstado);

		JLabel textoEstado = new JLabel("Estado:");
		textoEstado.setFont(new Font("Arial", Font.BOLD, 10));
		textoEstado.setBounds(396, 308, 46, 14);
		panel.add(textoEstado);

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = campoNome.getText();
				String cpf = campoCpf.getText().replace(".", "").replace("-", "");
				String sexo = String.valueOf(selectSexo.getSelectedItem()).toUpperCase();
				String email = campoEmail.getText();
				String estado = campoEstado.getText();
				String cidade = campoCidade.getText();
				String telefone = campoTelefone.getText().replace("-", "").replace(" ", "");
				int numeroCasa = Integer.parseInt(campoNumeroCasa.getText());
				String dataNascimento = campoDataNascimento.getText();
				Date dataFormatada = null;
				try {
					dataFormatada = new java.sql.Date(fmtBr.parse(dataNascimento).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				String cep = campoCep.getText();
				String bairro = campoBairro.getText();
				String rua = campoRua.getText();

				Tutores tutor = new Tutores(null, nome, cpf, sexo, email, estado, cidade, telefone, numeroCasa,
						dataFormatada, cep, bairro, rua);

				BDServices.inserirTutor(tutor);

				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new CadastroCadastroPet());
				f.revalidate();
			}
		});

	}
}
