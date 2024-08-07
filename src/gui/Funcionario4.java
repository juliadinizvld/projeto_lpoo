package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Funcionario4 extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Funcionario4() {
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(28, 10, 428, 143);
		add(panel);
		panel.setLayout(null);

		JLabel tituloFuncionarioAdicionado = new JLabel("Funcionário adicionado!");
		tituloFuncionarioAdicionado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tituloFuncionarioAdicionado.setHorizontalAlignment(SwingConstants.CENTER);
		tituloFuncionarioAdicionado.setBounds(111, 41, 197, 20);
		panel.add(tituloFuncionarioAdicionado);

		JButton botaoOk = new JButton("Ok");
		botaoOk.setVerticalAlignment(SwingConstants.BOTTOM);
		botaoOk.setBounds(160, 71, 85, 21);
		panel.add(botaoOk);
	}
};
