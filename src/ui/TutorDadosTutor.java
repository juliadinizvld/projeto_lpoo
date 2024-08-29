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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import business.BDServices;
import data.BD;
import ui.entities.Tutores;

public class TutorDadosTutor extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TutorDadosTutor(Tutores tutor) {
		setLayout(null);

		JPanel panel = new JPanel();
		setBackground(new Color(222, 222, 222));
		panel.setBounds(-11, 0, 821, 500);
		add(panel);
		panel.setLayout(null);

		JLabel tituloConsultaTutor = new JLabel("Consulta Tutor");
		tituloConsultaTutor.setHorizontalAlignment(SwingConstants.CENTER);
		tituloConsultaTutor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloConsultaTutor.setBounds(279, 11, 236, 25);
		panel.add(tituloConsultaTutor);

		JLabel textoNomeTutor = new JLabel("Nome do tutor: " + tutor.getNome());
		textoNomeTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNomeTutor.setBounds(103, 69, 588, 25);
		panel.add(textoNomeTutor);

		JLabel textoDataNascimentoTutor = new JLabel(
				"Data de nascimento: " + String.valueOf(tutor.getDataNascimento()));
		textoDataNascimentoTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoDataNascimentoTutor.setBounds(103, 289, 272, 20);
		panel.add(textoDataNascimentoTutor);

		JLabel textoEmailTutor = new JLabel("Email: " + tutor.getEmail());
		textoEmailTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoEmailTutor.setBounds(103, 145, 272, 25);
		panel.add(textoEmailTutor);

		JButton botaoRetornar = new JButton("← Retornar");
		botaoRetornar.setForeground(new Color(255, 255, 255));
		botaoRetornar.setBackground(new Color(159, 80, 0));
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new TutorConsultaTutor());
				f.revalidate();
			}
		});
		botaoRetornar.setBounds(131, 429, 122, 21);
		panel.add(botaoRetornar);

		JLabel textoIdTutor = new JLabel("ID do tutor: " + String.valueOf(tutor.getId()));
		textoIdTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoIdTutor.setBounds(103, 109, 272, 25);
		panel.add(textoIdTutor);

		JLabel textoTelefoneTutor = new JLabel("Telefone: " + tutor.getTelefone());
		textoTelefoneTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoTelefoneTutor.setBounds(103, 181, 272, 25);
		panel.add(textoTelefoneTutor);

		JLabel textpCpfTutor = new JLabel("CPF: " + tutor.getCpf());
		textpCpfTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textpCpfTutor.setBounds(103, 217, 240, 25);
		panel.add(textpCpfTutor);

		JLabel textoSexoTutor = new JLabel("Sexo: " + tutor.getSexo());
		textoSexoTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoSexoTutor.setBounds(103, 253, 250, 25);
		panel.add(textoSexoTutor);

		JLabel textoCepTutor = new JLabel("Cep: " + tutor.getCep());
		textoCepTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoCepTutor.setBounds(469, 106, 236, 25);
		panel.add(textoCepTutor);

		JLabel textoNumeroCasaTutor = new JLabel("Numero da casa: " + tutor.getNumeroCasa());
		textoNumeroCasaTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoNumeroCasaTutor.setBounds(469, 142, 269, 25);
		panel.add(textoNumeroCasaTutor);

		JLabel textoRuaTutor = new JLabel("Rua: " + tutor.getRua());
		textoRuaTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoRuaTutor.setBounds(469, 178, 269, 25);
		panel.add(textoRuaTutor);

		JLabel textoBairroTutor = new JLabel("Bairro: " + tutor.getBairro());
		textoBairroTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoBairroTutor.setBounds(469, 214, 269, 25);
		panel.add(textoBairroTutor);

		JLabel textoEstadoTutor = new JLabel("Estado: " + tutor.getEstado());
		textoEstadoTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoEstadoTutor.setBounds(469, 248, 269, 25);
		panel.add(textoEstadoTutor);

		JLabel textoCidadeTutor = new JLabel("Cidade: " + tutor.getCidade());
		textoCidadeTutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoCidadeTutor.setBounds(469, 284, 269, 25);
		panel.add(textoCidadeTutor);

		JButton botaoRemover = new JButton("Remover Tutor");
		botaoRemover.setForeground(Color.WHITE);
		botaoRemover.setBackground(new Color(159, 80, 0));
		botaoRemover.setBounds(291, 429, 173, 21);
		panel.add(botaoRemover);

		JButton botaoAtualizarDados = new JButton("Atualizar dados");
		botaoAtualizarDados.setForeground(Color.WHITE);
		botaoAtualizarDados.setBackground(new Color(159, 80, 0));
		botaoAtualizarDados.setBounds(509, 429, 173, 21);
		panel.add(botaoAtualizarDados);

		botaoAtualizarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new AtualizacaoAtualizarCadastroTutor(tutor));
				f.revalidate();
			}
		});

		botaoRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmacao = JOptionPane.showConfirmDialog(null,
						"Deseja remover este tutor? (Também removerá todos os pets em seu cadastro)",
						"Confirmar Remoção", JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {
					Connection connection = null;
					Statement st = null;
					ResultSet rs = null;
					int idTutor = tutor.getId();
					try {
						connection = BD.getConnection();
						st = connection.createStatement();
						rs = st.executeQuery("SELECT * FROM pets WHERE id_tutor = " + idTutor);
						while (rs.next()) {
							int idPet = rs.getInt("id");
							BDServices.removerPet(idPet);
						}
					} catch (SQLException i) {
						i.printStackTrace();
					}
					BDServices.removerTutor(tutor.getId());
					JOptionPane.showMessageDialog(null, "Tutor e pets removidos com sucesso!");
					JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
					f.setContentPane(new TutorConsultaTutor());
					f.revalidate();
				}
			}
		});
	}
};
