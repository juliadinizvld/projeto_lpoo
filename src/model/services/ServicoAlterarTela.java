package model.services;

import javax.swing.JFrame;

public class ServicoAlterarTela {

	public static void alterarTela(JFrame frame, int x, int y) {
		frame.setVisible(true);
		frame.setBounds(x, y, 800, 600);;
	}
}
