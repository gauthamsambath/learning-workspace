package com.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RotatingDonut extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private double theta = 0;
    private double phi = 0;
    private BufferedImage image;

    public RotatingDonut() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    private void render() {
        double sinTheta = Math.sin(theta);
        double cosTheta = Math.cos(theta);
        double sinPhi = Math.sin(phi);
        double cosPhi = Math.cos(phi);

        for (int y = 0; y < HEIGHT; y++) {
            double y1 = (y - HEIGHT / 2.0) / (HEIGHT / 2.0);
            for (int x = 0; x < WIDTH; x++) {
                double x1 = (x - WIDTH / 2.0) / (WIDTH / 2.0);
                double z1 = Math.sin(Math.sqrt(x1 * x1 + y1 * y1));
                double z2 = cosPhi * z1 + sinPhi * x1;
                double z3 = cosTheta * z2 - sinTheta * y1;
                double d = 1 / (z3 + 2);
                int r = (int) (Math.cos(x1 * y1 + phi) * 128 + 127);
                int g = (int) (Math.cos(z1 + theta) * 128 + 127);
                int b = (int) (Math.sin(x1 * y1 - phi) * 128 + 127);
                int a = 255;
                image.setRGB(x, y, (a << 24) | (r << 16) | (g << 8) | b);
            }
        }

        theta += 0.03;
        phi += 0.01;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        render();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rotating Donut");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new RotatingDonut());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
