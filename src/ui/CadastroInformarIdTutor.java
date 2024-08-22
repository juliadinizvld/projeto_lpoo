package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;

import business.BDServices;
import ui.entities.Tutores;

public class CadastroInformarIdTutor extends JPanel {

	private static final long serialVersionUID = 1L;
	public static CadastroInformarIdTutor cadastroInformarIdTutor = new CadastroInformarIdTutor();
	/**
	 * Create the panel.
	 */
	public CadastroInformarIdTutor() {
		setLayout(null);
		// Cria um painel principal com um layout de BorderLayout
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 700, 500);
		add(panel);
		panel.setLayout(null);

		// Adiciona os componentes
		JLabel lblNewLabel = new JLabel("Informe o ID do tutor:");
		lblNewLabel.setBounds(247, 29, 373, 22);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel);

		JButton btnRetornar = new JButton("Retornar ");
		btnRetornar.setForeground(new Color(255, 255, 255));
		btnRetornar.setBackground(new Color(159, 80, 0));
		btnRetornar.setBounds(188, 146, 112, 37);
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new CadastroEscolha());
				f.revalidate();
			}
		});
		panel.add(btnRetornar);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setBackground(new Color(159, 80, 0));
		btnConfirmar.setBounds(340, 146, 148, 37);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel.add(btnConfirmar);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(236, 94, 195, 20);
		panel.add(formattedTextField);
		
		JLabel iDtutor = new JLabel("Id tutor: ");
		iDtutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		iDtutor.setBounds(224, 240, 136, 14);
		panel.add(iDtutor);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do tutor:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(223, 265, 185, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setForeground(new Color(255, 255, 255));
		btnAvancar.setBackground(new Color(159, 80, 0));
		btnAvancar.setBounds(270, 305, 148, 37);
		panel.add(btnAvancar);

		JLabel textoCampoIdTutor = new JLabel("ID:");
		textoCampoIdTutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoCampoIdTutor.setBounds(261, 90, 35, 17);
		panel.add(textoCampoIdTutor);

		JLabel textoIdTutor = new JLabel("Id tutor: ");
		textoIdTutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textoIdTutor.setBounds(223, 240, 279, 14);
		panel.add(textoIdTutor);

		JLabel textoNomeTutor = new JLabel("Nome do tutor:");
		textoNomeTutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textoNomeTutor.setBounds(223, 265, 328, 14);
		panel.add(textoNomeTutor);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idTutor = Integer.parseInt(campoIdTutor.getText());
				Tutores tutor = BDServices.consultarTutor(idTutor);

				textoIdTutor.setText("Id do Tutor: " + tutor.getId());
				textoNomeTutor.setText("Nome do Tutor: " + tutor.getNome());
			}
		});

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				String[] campoIdTutor = textoIdTutor.getText().split(":");
				int idTutor = Integer.parseInt(campoIdTutor[1].trim());
				f.setContentPane(new CadastroCadastroPet(idTutor));
				f.revalidate();
			}
		});

		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new CadastroEscolha());
				f.revalidate();
			}
		});

	}
}
