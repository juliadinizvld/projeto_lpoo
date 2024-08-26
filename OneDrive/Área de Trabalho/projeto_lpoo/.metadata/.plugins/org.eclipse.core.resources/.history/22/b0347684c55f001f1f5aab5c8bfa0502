package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import business.BDServices;
import data.BD;
import ui.entities.Funcionarios;
import ui.entities.Pets;

public class ConsultaPets extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField caixaInserirIDTutor;
	public static ConsultaPets consultaPets1 = new ConsultaPets();

	/**
	 * Create the panel.
	 */
	public ConsultaPets() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JButton botaoRetornar = new JButton(" <- Retornar");
		botaoRetornar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoRetornar.setBounds(281, 124, 125, 23);

		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Home());
				f.revalidate();
			}

		});
		panel.add(botaoRetornar);

		caixaInserirIDTutor = new JTextField();
		caixaInserirIDTutor.setBounds(414, 75, 63, 20);
		panel.add(caixaInserirIDTutor);
		caixaInserirIDTutor.setColumns(10);

		JLabel textoIdTutor = new JLabel("ID do tutor:");
		textoIdTutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textoIdTutor.setBounds(327, 77, 77, 14);
		panel.add(textoIdTutor);

		JLabel texConsul = new JLabel("Consulta PET");
		texConsul.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texConsul.setBounds(378, 23, 151, 14);
		panel.add(texConsul);

		JButton botaoConsultar = new JButton("Consultar");
		botaoConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoConsultar.setBounds(436, 124, 119, 23);
		panel.add(botaoConsultar);

		JLabel textAnimaisPorID = new JLabel("Animais encontrados no CPF Informado");
		textAnimaisPorID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAnimaisPorID.setBounds(300, 191, 229, 14);
		panel.add(textAnimaisPorID);

		JComboBox<String> ListAnimaisPorID = new JComboBox<>();
		ListAnimaisPorID.setBounds(327, 231, 164, 22);
		panel.add(ListAnimaisPorID);

		botaoConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListAnimaisPorID.removeAllItems();
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;
				int idTutor = Integer.parseInt(caixaInserirIDTutor.getText());
				try {
					connection = BD.getConnection();
					st = connection.createStatement();
					rs = st.executeQuery("SELECT * FROM pets WHERE id_tutor = " + idTutor);
					while (rs.next()) {
						ListAnimaisPorID.addItem(rs.getString("nome") + " - " + rs.getInt("id"));
					}
				} catch (SQLException i) {
					i.printStackTrace();
				}
			}
		});

		JList<String> pets = new JList<>();
		pets.setBounds(197, 167, 1, 1);
		panel.add(pets);

		JButton botaoVerificarFicha = new JButton("Verificar Ficha");
		botaoVerificarFicha.setBounds(349, 283, 125, 23);
		botaoVerificarFicha.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoVerificarFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] petSelecionado = String.valueOf(ListAnimaisPorID.getSelectedItem()).split("-");
				int idPetSelecionado = Integer.parseInt(petSelecionado[1].trim());
				Pets pet = BDServices.consultarPet(idPetSelecionado);
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ConsultaPetsDadosPet(pet));
				f.revalidate();
			}

		});

		panel.add(botaoVerificarFicha);

	}
}
