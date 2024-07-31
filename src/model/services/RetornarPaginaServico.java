package model.services;

import javax.swing.JFrame;

public class RetornarPaginaServico {

	public static void returnPage(JFrame frame, int x, int y) {
		frame.setVisible(true);
		frame.setBounds(x, y, 800, 600);;
	}
}
