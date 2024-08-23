package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Sobre extends JPanel {

    private static final long serialVersionUID = 1L;

    public Sobre() {
        setLayout(new BorderLayout());
        setBackground(new Color(222, 222, 222)); 

       
        JLabel titleLabel = new JLabel("CLÍNICA VETERINÁRIA", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setPreferredSize(new Dimension(800, 100));
        titleLabel.setForeground(Color.BLACK); 
        add(titleLabel, BorderLayout.NORTH);

       
        JTextArea textArea = new JTextArea();
        textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sollicitudin, nisi vel pellentesque interdum, nunc magna ultrices est, vel cursus ipsum dui et ante. Nulla facilisi. Duis volutpat turpis vel bibendum hendrerit. In sit amet nisl urna. Nullam ultricies turpis non felis imperdiet facilisis. Vivamus non malesuada urna. Integer ut ante felis. Fusce viverra mollis sem, non dapibus justo hendrerit sed. Nullam lobortis purus id velit commodo, in euismod velit iaculis. Nulla facilisi. Ut non augue nec libero commodo consequat. Ut convallis, libero nec bibendum sagittis, sapien nunc scelerisque justo, nec vehicula nunc lectus non ligula. Nullam a fermentum tortor. Integer nec libero felis. Morbi non consectetur magna. Duis a dui leo. Ut faucibus lectus sit amet sapien cursus, nec dictum neque varius. Vivamus efficitur sapien a fermentum aliquet. Donec gravida eros eu urna fermentum, non hendrerit libero convallis. Aliquam erat volutpat. Integer vehicula lorem orci, vel hendrerit metus dictum sed. Aenean id felis turpis. Duis euismod nibh vitae erat vehicula, a vehicula ligula maximus.");
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBackground(new Color(222, 222, 222)); 

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        scrollPane.setBackground(new Color(222, 222, 222)); 
        add(scrollPane, BorderLayout.CENTER);

        JButton returnButton = new JButton("Retornar");
        returnButton.setFont(new Font("Arial", Font.PLAIN, 20));
        returnButton.setBackground(new Color(159, 80, 0));
        returnButton.setForeground(Color.WHITE);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, Sobre.this);
                f.setContentPane(new Home());
                f.revalidate();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(222, 222, 222)); 
        buttonPanel.add(returnButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}

