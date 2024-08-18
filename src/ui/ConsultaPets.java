package ui;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ConsultaPets extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField caixaInserirIDPet;
	public static ConsultaPets consultaPets1 = new ConsultaPets();

	public ConsultaPets() {
		setLayout(null);

		MaskFormatter mfCpf = null;

		try {
			mfCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.getStackTrace();
		}
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
		botaoRetornar.setBounds(222, 206, 125, 23);

		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new Home());
				f.revalidate();
			}

		});
		panel.add(botaoRetornar);

		caixaInserirIDPet = new JTextField();
		caixaInserirIDPet.setBounds(288, 117, 241, 20);
		panel.add(caixaInserirIDPet);
		caixaInserirIDPet.setColumns(10);

		JLabel textoIDPet = new JLabel("CPF do tutor:");
		textoIDPet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textoIDPet.setBounds(121, 120, 157, 14);
		panel.add(textoIDPet);

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
		botaoConsultar.setBounds(483, 206, 119, 23);
		panel.add(botaoConsultar);

		JLabel textAnimaisPorID = new JLabel("Animais encontrados no CPF Informado");
		textAnimaisPorID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAnimaisPorID.setBounds(314, 307, 229, 14);
		panel.add(textAnimaisPorID);

		JComboBox ListAnimaisPorID = new JComboBox();
		ListAnimaisPorID.setModel(new DefaultComboBoxModel(new String[] { "Bob", "Luna", "Ralph", "Amora" }));
		ListAnimaisPorID.setBounds(335, 350, 164, 22);
		panel.add(ListAnimaisPorID);

		JList list = new JList();
		list.setBounds(64, 224, 58, 0);
		panel.add(list);

		JList list_1 = new JList();
		list_1.setBounds(197, 167, 1, 1);
		panel.add(list_1);

		JButton botaoVerificarFicha = new JButton("Verificar Ficha");
		botaoVerificarFicha.setBounds(354, 398, 125, 23);
		botaoVerificarFicha.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoVerificarFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(ConsultaPetsDadosPet.consultaPets2);
				f.revalidate();
			}

		});

		panel.add(botaoVerificarFicha);

	}
}
