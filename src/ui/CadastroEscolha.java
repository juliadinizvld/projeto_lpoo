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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.Color;

public class CadastroEscolha extends JPanel {

	private static final long serialVersionUID = 1L;
	public static CadastroCadastroTutor cadastroEscolha = new CadastroCadastroTutor();
	private static JFrame frame;

	/**
	 * Create the panel.
	 */
	public CadastroEscolha() {
		setLayout(null);
		// Cria um painel principal com um layout de BorderLayout
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(-11, 0, 700, 500);
		add(panel);
		panel.setLayout(null);

		// Adiciona os componentes
		JLabel lblNewLabel = new JLabel("Tutor já é cadastrado?");
		lblNewLabel.setBounds(239, 30, 373, 22);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblNewLabel);

		JButton btnRetornar = new JButton("Retornar ");
		btnRetornar.setForeground(new Color(255, 255, 255));
		btnRetornar.setBackground(new Color(159, 80, 0));
		btnRetornar.setBounds(134, 136, 112, 37);
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Home());
				f.revalidate();
			}
		});
		panel.add(btnRetornar);

		JButton btnNovoCadastro = new JButton("Novo Cadastro");
		btnNovoCadastro.setForeground(new Color(255, 255, 255));
		btnNovoCadastro.setBackground(new Color(159, 80, 0));
		btnNovoCadastro.setBounds(275, 136, 148, 37);
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new CadastroCadastroTutor());
				f.revalidate();
			}
		});
		panel.add(btnNovoCadastro);
		
		JButton btnJaCadastrado = new JButton("Já sou cadastrado");
		btnJaCadastrado.setForeground(new Color(255, 255, 255));
		btnJaCadastrado.setBackground(new Color(159, 80, 0));
		btnJaCadastrado.setBounds(457, 136, 148, 37);
		panel.add(btnJaCadastrado);
		
		btnJaCadastrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new CadastroInformarIdTutor());
				f.revalidate();
			}
		});

		// Agrupa os botões de rádio
		ButtonGroup genderGroup = new ButtonGroup();
	}
}
