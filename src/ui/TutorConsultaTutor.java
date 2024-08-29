package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import business.BDServices;
import data.BD;
import ui.entities.Funcionarios;
import ui.entities.Tutores;

import java.awt.Color;

public class TutorConsultaTutor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoNomeTutor;

	public TutorConsultaTutor() {
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		setBackground(new Color(222, 222, 222));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		JLabel tituloTutores = new JLabel("Tutores", SwingConstants.CENTER);
		tituloTutores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(tituloTutores, gbc);

		gbc.gridy++;
		gbc.gridwidth = 1;
		JLabel textoNomeTutor = new JLabel("Nome do tutor: ");
		textoNomeTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(textoNomeTutor, gbc);

		gbc.gridx++;
		campoNomeTutor = new JTextField(20);
		panel.add(campoNomeTutor, gbc);
		((AbstractDocument) campoNomeTutor.getDocument()).setDocumentFilter(new FiltroApenasLetrasEAcentos());

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 2;
		JButton botaoPesquisarTutor = new JButton("Pesquisar Tutor");
		botaoPesquisarTutor.setForeground(Color.WHITE);
		botaoPesquisarTutor.setBackground(new Color(159, 80, 0));
		panel.add(botaoPesquisarTutor, gbc);

		gbc.gridy++;
		JLabel textoTutoresEncontrados = new JLabel("Funcionários encontrados:", SwingConstants.CENTER);
		textoTutoresEncontrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(textoTutoresEncontrados, gbc);

		gbc.gridy++;
		JComboBox<String> selectResultadoTutores = new JComboBox<>();
		selectResultadoTutores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(selectResultadoTutores, gbc);

		gbc.gridy++;
		JButton botaoVerificarTutor = new JButton("Verificar tutor");
		botaoVerificarTutor.setForeground(Color.WHITE);
		botaoVerificarTutor.setBackground(new Color(159, 80, 0));
		panel.add(botaoVerificarTutor, gbc);

		gbc.gridy++;
		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setForeground(Color.WHITE);
		botaoRetornar.setBackground(new Color(159, 80, 0));
		panel.add(botaoRetornar, gbc);

		add(panel, BorderLayout.CENTER);

		botaoPesquisarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectResultadoTutores.removeAllItems();
				Connection connection = null;
				Statement st = null;
				ResultSet rs = null;
				String nome = campoNomeTutor.getText();
				try {
					connection = BD.getConnection();
					st = connection.createStatement();
					rs = st.executeQuery("SELECT * FROM tutores WHERE nome LIKE '%" + nome + "%';");
					while (rs.next()) {
						selectResultadoTutores.addItem(rs.getString("nome") + " - " + rs.getInt("id"));
					}
				} catch (SQLException i) {
					i.printStackTrace();
				}
			}
		});

		botaoVerificarTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] tutorSelecionado = String.valueOf(selectResultadoTutores.getSelectedItem()).split("-");
				int idTutorSelecionado = Integer.parseInt(tutorSelecionado[1].trim());
				Tutores tutor = BDServices.consultarTutor(idTutorSelecionado);
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new TutorDadosTutor(tutor));
				f.revalidate();
			}
		});

		botaoRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Home());
				f.revalidate();
			}
		});

	}

	class FiltroApenasLetrasEAcentos extends DocumentFilter {
		@Override
		public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr)
				throws BadLocationException {
			if (string != null && string.matches("[\\p{L} ]*")) {
				super.insertString(fb, offset, string, attr);
			}
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs)
				throws BadLocationException {
			if (text != null && text.matches("[\\p{L} ]*")) {
				super.replace(fb, offset, length, text, attrs);
			}
		}
	}
}
