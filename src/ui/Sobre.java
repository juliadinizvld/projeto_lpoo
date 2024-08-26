package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Sobre extends JPanel {

    private static final long serialVersionUID = 1L;

    public Sobre() {
        setLayout(new BorderLayout());
        setBackground(new Color(222, 222, 222));

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(new Color(222, 222, 222));
        try {
            URL imageUrl = new URL("https://img.freepik.com/fotos-gratis/close-no-veterinario-cuidando-do-animal-de-estimacao_23-2149143875.jpg?t=st=1724438996~exp=1724442596~hmac=60f11e88bf49ee80708a0ddb04bd47512ef95f0bb4eb113c9b028ad0ae306548&w=740");
            InputStream inputStream = imageUrl.openStream();
            BufferedImage originalImage = ImageIO.read(inputStream);
            BufferedImage resizedImage = resizeImage(originalImage, 600, 300); // Redimensiona a imagem

            ImageIcon imageIcon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imagePanel.add(imageLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(imagePanel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setText("Nossa Clínica Veterinária oferece cuidados especializados para animais de estimação, incluindo consultas, procedimentos cirúrgicos e serviços de emergência. Com uma equipe de veterinários experientes, proporcionamos tratamentos de alta qualidade e serviços de diagnóstico avançados. Além disso, disponibilizamos medicamentos e produtos para garantir o bem-estar contínuo dos seus pets. Estamos comprometidos em proporcionar um atendimento gentil e eficaz para a saúde do seu animal.");
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

    // redimensionar a imagem
    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image tmp = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }
}
