package ui;

import java.awt.Dimension;
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
import ui.entities.Pets;

public class CadastroCadastroPet extends JPanel {

	private static final long serialVersionUID = 1L;
	public static CadastroCadastroPet telaCadastro1 = new CadastroCadastroPet();

	private static JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;

	private static JTextField campoNomeAnimal;
	private static JTextField campoRacaAnimal;
	private static JTextField campoDataNascimento;
	private static JTextField campoPesoAnimal;
	private static JTextField campoAlergiasAnimal;
	private static JTextField campoVacinasAnimal;

	/**
	 * Create the panel.
	 */
	public CadastroCadastroPet() {

		SimpleDateFormat fmtBr = new SimpleDateFormat("dd/MM/yyyy");

		MaskFormatter mfDataNascimento = null;
		MaskFormatter mfPeso = null;

		try {
			mfDataNascimento = new MaskFormatter("##/##/####");
			mfPeso = new MaskFormatter("##.##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		setLayout(null);
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		// Cria um painel principal com um layout de BorderLayout
		JPanel panel = new JPanel();
		panel.setBounds(45, 11, 700, 500);
		add(panel);
		panel.setLayout(null);

		// Cria o título
		JLabel titleLabel = new JLabel("Dados do Animal:", JLabel.CENTER);
		titleLabel.setBounds(-24, 10, 800, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		titleLabel.setPreferredSize(new Dimension(800, 50)); // Define o tamanho do título

		// Adiciona o título ao painel principal
		panel.add(titleLabel);

		campoNomeAnimal = new JTextField();
		campoNomeAnimal.setBounds(282, 74, 242, 26);
		campoNomeAnimal.setColumns(10);
		panel.add(campoNomeAnimal);

		JLabel lblNewLabel = new JLabel("Nome do animal:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel.setBounds(185, 74, 100, 24);
		panel.add(lblNewLabel);

		campoRacaAnimal = new JTextField();
		campoRacaAnimal.setColumns(10);
		campoRacaAnimal.setBounds(225, 161, 273, 26);
		panel.add(campoRacaAnimal);

		JLabel lblNewLabel_1 = new JLabel("Espécie:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1.setBounds(185, 118, 49, 24);
		panel.add(lblNewLabel_1);

		String[] especies = { "Cachorro", "Gato" };
		JComboBox<String> selectEspecie = new JComboBox<String>(especies);
		selectEspecie.setFont(new Font("Dialog", Font.PLAIN, 14));
		selectEspecie.setBounds(244, 118, 108, 21);
		panel.add(selectEspecie);

		JLabel lblNewLabel_1_1 = new JLabel("Raça:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(185, 161, 49, 24);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Data de Nascimento: ");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1.setBounds(185, 205, 108, 24);
		panel.add(lblNewLabel_1_1_1);

		campoDataNascimento = new JFormattedTextField(mfDataNascimento);
		campoDataNascimento.setColumns(10);
		campoDataNascimento.setBounds(296, 205, 103, 26);
		panel.add(campoDataNascimento);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sexo:");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1_1.setBounds(185, 255, 49, 24);
		panel.add(lblNewLabel_1_1_1_1);

		String[] sexos = { "Macho", "Fêmea" };
		JComboBox<String> selectSexo = new JComboBox<String>(sexos);
		selectSexo.setFont(new Font("Dialog", Font.PLAIN, 14));
		selectSexo.setBounds(230, 255, 108, 21);
		panel.add(selectSexo);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Peso(kg):");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1_1_1.setBounds(185, 299, 49, 24);
		panel.add(lblNewLabel_1_1_1_1_1);

		campoPesoAnimal = new JFormattedTextField(mfPeso);
		campoPesoAnimal.setColumns(10);
		campoPesoAnimal.setBounds(250, 299, 100, 26);
		panel.add(campoPesoAnimal);

		JLabel lblNewLabel_1_1_2 = new JLabel("Alergia(s):");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_2.setBounds(185, 351, 58, 24);
		panel.add(lblNewLabel_1_1_2);

		campoAlergiasAnimal = new JTextField();
		campoAlergiasAnimal.setColumns(10);
		campoAlergiasAnimal.setBounds(251, 351, 273, 26);
		panel.add(campoAlergiasAnimal);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Vacinas:");
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_2_1.setBounds(185, 398, 58, 24);
		panel.add(lblNewLabel_1_1_2_1);

		campoVacinasAnimal = new JTextField();
		campoVacinasAnimal.setColumns(10);
		campoVacinasAnimal.setBounds(251, 398, 273, 26);
		panel.add(campoVacinasAnimal);

		JButton btnNewButton = new JButton("Avançar ");
		btnNewButton.setBounds(416, 454, 108, 35);
		panel.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastroFinalizarCadastroTutor.showConfirmationDialog(frame);
				String nome = campoNomeAnimal.getText();
				String especie = String.valueOf(selectEspecie.getSelectedItem()).toUpperCase();
				String raca = campoRacaAnimal.getText();
				String dataNascimento = campoDataNascimento.getText();
				Date dataFormatada = null;
				try {
					dataFormatada = new java.sql.Date(fmtBr.parse(dataNascimento).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				String sexo = String.valueOf(selectSexo.getSelectedItem()).toUpperCase();
				Double peso = Double.parseDouble(campoPesoAnimal.getText());
				String alergias = campoAlergiasAnimal.getText();
				String vacinas = campoVacinasAnimal.getText();
				Pets pet = new Pets(null, nome, especie, dataFormatada, sexo, raca, peso, alergias, vacinas, 1);
				BDServices.inserirPet(pet);
			}

		});

		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.setBounds(262, 454, 108, 35);
		panel.add(btnRetornar);

		btnRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(CadastroCadastroTutor.cadastroTutor);
				f.revalidate();
			}
		});

		setVisible(true);
	}
}
