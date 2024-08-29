package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import business.BDServices;
import data.BD;
import ui.entities.Consultas;
import ui.entities.Pets;
import java.awt.Color;
import ui.entities.Tutores;
import javax.swing.JComboBox;

public class ConsultaPetsDadosPet extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public ConsultaPetsDadosPet(Pets pet) {
		setLayout(null);
		Tutores tutor = BDServices.consultarTutor(pet.getId_tutor());

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JLabel textNomeTutor = new JLabel("Nome do Tutor: " + tutor.getNome());
		textNomeTutor.setBounds(510, 28, 264, 14);
		panel.add(textNomeTutor);

		JLabel textCpfTutor = new JLabel("ID do tutor: " + pet.getId_tutor());
		textCpfTutor.setBounds(546, 51, 155, 14);
		panel.add(textCpfTutor);

		JLabel tituloDadosPet = new JLabel("Dados do PET");
		tituloDadosPet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tituloDadosPet.setBounds(271, 13, 132, 41);
		panel.add(tituloDadosPet);

		table = new JTable();
		table.setBounds(149, 109, 1, 1);
		panel.add(table);

		table_1 = new JTable();
		table_1.setBounds(271, 147, 1, 1);
		panel.add(table_1);

		table_2 = new JTable();
		table_2.setBounds(197, 109, 1, 1);
		panel.add(table_2);

		JLabel textIDPet = new JLabel("ID: " + pet.getId());
		textIDPet.setBounds(85, 138, 86, 14);
		panel.add(textIDPet);

		JLabel TextNomePet = new JLabel("Nome: " + pet.getNome());
		TextNomePet.setBounds(85, 165, 226, 14);
		panel.add(TextNomePet);

		JLabel TextEspeciePet = new JLabel("Espécie: " + pet.getEspecie());
		TextEspeciePet.setBackground(new Color(255, 255, 255));
		TextEspeciePet.setBounds(85, 182, 226, 14);
		panel.add(TextEspeciePet);

		JLabel TextracaPet = new JLabel("Raça: " + pet.getRaca());
		TextracaPet.setBounds(85, 207, 190, 14);
		panel.add(TextracaPet);

		JLabel Alergias = new JLabel("Alergias: " + pet.getAlergias());
		Alergias.setBounds(85, 260, 142, 14);
		panel.add(Alergias);

		JLabel TextSexoPet = new JLabel("Sexo: " + pet.getSexo());
		TextSexoPet.setBounds(85, 285, 142, 14);
		panel.add(TextSexoPet);

		JLabel textPesoPet = new JLabel("Peso: " + pet.getPeso());
		textPesoPet.setBounds(85, 310, 114, 14);
		panel.add(textPesoPet);

		JLabel textVacinasPet = new JLabel("Vacinas: " + pet.getVacinas());
		textVacinasPet.setBounds(85, 335, 155, 14);
		panel.add(textVacinasPet);

		JLabel textListaDeConsulta = new JLabel("Lista de Consultas ");
		textListaDeConsulta.setBounds(546, 147, 108, 14);
		panel.add(textListaDeConsulta);

		JComboBox<String> listaConsultas = new JComboBox<>();
		listaConsultas.setBounds(536, 178, 118, 22);
		panel.add(listaConsultas);

		listaConsultas.removeAllItems();
		int idPet = pet.getId();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = BD.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM consultas WHERE id_pet = " + idPet);
			while (rs.next()) {
				listaConsultas.addItem(rs.getString("dataConsulta") + " - " + rs.getInt("id"));
			}
		} catch (SQLException i) {
			i.printStackTrace();
		}

		JButton botaoVerificarConsulta = new JButton("Verificar Consulta");
		botaoVerificarConsulta.setBackground(new Color(159, 80, 0));
		botaoVerificarConsulta.setForeground(new Color(255, 255, 255));
		botaoVerificarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		botaoVerificarConsulta.setBounds(514, 283, 140, 23);
		panel.add(botaoVerificarConsulta);

		botaoVerificarConsulta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] consultaSelecionada = String.valueOf(listaConsultas.getSelectedItem()).split(" - ");
				int idConsultaSelecionada = Integer.parseInt(consultaSelecionada[1].trim());
				Consultas consulta = BDServices.consultarConsulta(idConsultaSelecionada);
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ConsultaPetsDadosConsulta(consulta));
				f.revalidate();

			}
		});

		JLabel TextNascPet = new JLabel("Nascimento: " + pet.getDataNascimento());
		TextNascPet.setBounds(85, 230, 208, 27);
		panel.add(TextNascPet);

		JButton botaoRetornar = new JButton("Retornar");
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBounds(106, 405, 114, 23);
		panel.add(botaoRetornar);

		botaoRetornar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ConsultaPets());
				f.revalidate();
			}

		});

		JButton botaoRemoverPet = new JButton("Remover Pet");
		botaoRemoverPet.setForeground(Color.WHITE);
		botaoRemoverPet.setBackground(new Color(159, 80, 0));
		botaoRemoverPet.setBounds(299, 405, 195, 23);
		panel.add(botaoRemoverPet);

		JButton botaoAtualizarDados = new JButton("Atualizar Dados");
		botaoAtualizarDados.setForeground(Color.WHITE);
		botaoAtualizarDados.setBackground(new Color(159, 80, 0));
		botaoAtualizarDados.setBounds(526, 405, 195, 23);
		panel.add(botaoAtualizarDados);

		botaoAtualizarDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new AtualizacaoAtualizarCadastroPet(pet));
				f.revalidate();
			}

		});

		botaoRemoverPet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja remover este Pet?", "Confirmar Remoção",
						JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {
					BDServices.removerPet(pet.getId());
					JOptionPane.showMessageDialog(null, "Pet removido com sucesso!");
					JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
					f.setContentPane(new ConsultaPets());
					f.revalidate();
				}
			}

		});

	}
}
