
package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import business.BDServices;
import ui.ConsultaDadosTutor;
import ui.entities.Tutores;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		Tutores tutor = BDServices.consultarTutor(2);
		setContentPane(new ConsultaDadosTutor(tutor));

	}

	public void setPanel(JPanel newPanel) {
		setContentPane(newPanel);
	}

}
