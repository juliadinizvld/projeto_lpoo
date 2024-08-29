package ui;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

import business.BDServices;
import data.BD;
import ui.entities.MedicosVeterinarios;
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
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JButton botaoRetornar = new JButton(" <- Retornar");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Home());
				f.revalidate();
			}
		});
		botaoRetornar.setBounds(281, 124, 125, 34);
		panel.add(botaoRetornar);

		/**
		 * Create the panel.
		 */

		caixaInserirIDTutor = new JTextField();
		caixaInserirIDTutor.setBounds(414, 75, 63, 20);
		panel.add(caixaInserirIDTutor);
		caixaInserirIDTutor.setColumns(10);

		// Adicionando o filtro de caracteres para aceitar apenas números
		((AbstractDocument) caixaInserirIDTutor.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr)
					throws javax.swing.text.BadLocationException {
				if (string.matches("\\d*")) {
					super.insertString(fb, offset, string, attr);
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text,
					javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
				if (text.matches("\\d*")) {
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});

		JLabel textoIdTutor = new JLabel("ID do tutor:");
		textoIdTutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textoIdTutor.setBounds(327, 77, 77, 14);
		panel.add(textoIdTutor);

		JLabel texConsul = new JLabel("Consulta PET");
		texConsul.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texConsul.setBounds(378, 23, 151, 14);
		panel.add(texConsul);

		JButton botaoConsultar = new JButton("Consultar");
		botaoConsultar.setBackground(new Color(159, 80, 0));
		botaoConsultar.setForeground(new Color(255, 255, 255));
		botaoConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoConsultar.setBounds(436, 124, 119, 34);
		panel.add(botaoConsultar);

		JLabel textAnimaisPorID = new JLabel("Animais encontrados no Id Informado");
		textAnimaisPorID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAnimaisPorID.setBounds(300, 191, 229, 14);
		panel.add(textAnimaisPorID);

		JComboBox<String> ListAnimaisPorID = new JComboBox<>();
		ListAnimaisPorID.setBackground(new Color(192, 192, 192));
		ListAnimaisPorID.setBounds(327, 231, 164, 22);
		panel.add(ListAnimaisPorID);

		botaoConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListAnimaisPorID.removeAllItems();
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;

				try {
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

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o ID do tutor.",
							"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton botaoVerificarFicha = new JButton("Verificar Ficha");
		botaoVerificarFicha.setForeground(new Color(255, 255, 255));
		botaoVerificarFicha.setBackground(new Color(159, 80, 0));
		botaoVerificarFicha.setBounds(349, 283, 125, 34);
		botaoVerificarFicha.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoVerificarFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ListAnimaisPorID.getSelectedItem() == null) {
		            // Exibir alerta
		            JOptionPane.showMessageDialog(null, "Por favor, selecione um pet antes de verificar a ficha.", "Atenção", JOptionPane.WARNING_MESSAGE);
		        } else {
				String[] petSelecionado = String.valueOf(ListAnimaisPorID.getSelectedItem()).split("-");
				int idPetSelecionado = Integer.parseInt(petSelecionado[1].trim());
				Pets pet = BDServices.consultarPet(idPetSelecionado);
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ConsultaPetsDadosPet(pet));
				f.revalidate();
			}

		}}
		);

		panel.add(botaoVerificarFicha);
	}

	public ConsultaPets(MedicosVeterinarios medico) {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JButton botaoRetornar = new JButton(" <- Retornar");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Home());
				f.revalidate();
			}
		});
		botaoRetornar.setBounds(281, 124, 125, 34);
		panel.add(botaoRetornar);

		/**
		 * Create the panel.
		 */

		caixaInserirIDTutor = new JTextField();
		caixaInserirIDTutor.setBounds(414, 75, 63, 20);
		panel.add(caixaInserirIDTutor);
		caixaInserirIDTutor.setColumns(10);

		// Adicionando o filtro de caracteres para aceitar apenas números
		((AbstractDocument) caixaInserirIDTutor.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr)
					throws javax.swing.text.BadLocationException {
				if (string.matches("\\d*")) {
					super.insertString(fb, offset, string, attr);
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text,
					javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
				if (text.matches("\\d*")) {
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});

		JLabel textoIdTutor = new JLabel("ID do tutor:");
		textoIdTutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textoIdTutor.setBounds(327, 77, 77, 14);
		panel.add(textoIdTutor);

		JLabel texConsul = new JLabel("Consulta PET");
		texConsul.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texConsul.setBounds(378, 23, 151, 14);
		panel.add(texConsul);

		JButton botaoConsultar = new JButton("Consultar");
		botaoConsultar.setBackground(new Color(159, 80, 0));
		botaoConsultar.setForeground(new Color(255, 255, 255));
		botaoConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoConsultar.setBounds(436, 124, 119, 34);
		panel.add(botaoConsultar);

		JLabel textAnimaisPorID = new JLabel("Animais encontrados no Id Informado");
		textAnimaisPorID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAnimaisPorID.setBounds(300, 191, 229, 14);
		panel.add(textAnimaisPorID);

		JComboBox<String> ListAnimaisPorID = new JComboBox<>();
		ListAnimaisPorID.setBackground(new Color(192, 192, 192));
		ListAnimaisPorID.setBounds(327, 231, 164, 22);
		panel.add(ListAnimaisPorID);

		botaoConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListAnimaisPorID.removeAllItems();
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;

				try {
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

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o ID do tutor.",
							"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton botaoVerificarFicha = new JButton("Adicionar Consulta");
		botaoVerificarFicha.setForeground(new Color(255, 255, 255));
		botaoVerificarFicha.setBackground(new Color(159, 80, 0));
		botaoVerificarFicha.setBounds(349, 283, 150, 34);
		botaoVerificarFicha.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoVerificarFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] petSelecionado = String.valueOf(ListAnimaisPorID.getSelectedItem()).split("-");
				int idPetSelecionado = Integer.parseInt(petSelecionado[1].trim());
				Pets pet = BDServices.consultarPet(idPetSelecionado);
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new ConsultaInserirDadosConsulta(medico, pet));
				f.revalidate();
			}

		});

		panel.add(botaoVerificarFicha);
	}

}
