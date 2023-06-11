package com.testing;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SceneryFrame extends JPanel {

    // Override the paint method to draw the scenery
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw sky
        g.setColor(new Color(135, 206, 250)); // Light blue color
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw sun
        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 80, 80);

        // Draw grass
        g.setColor(new Color(34, 139, 34)); // Dark green color
        g.fillRect(0, 250, getWidth(), getHeight());

        // Draw tree trunk
        g.setColor(new Color(139, 69, 19)); // Brown color
        g.fillRect(100, 150, 20, 100);

        // Draw tree top
        g.setColor(new Color(34, 139, 34)); // Dark green color
        g.fillOval(50, 100, 120, 120);

        // Draw house
        g.setColor(new Color(218, 165, 32)); // Goldenrod color
        g.fillRect(200, 100, 100, 100);

        // Draw roof
        int[] xPoints = {200, 300, 250};
        int[] yPoints = {100, 100, 50};
        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, 3);

        // Draw door
        g.setColor(new Color(139, 69, 19)); // Brown color
        g.fillRect(225, 140, 50, 60);

        // Draw doorknob
        g.setColor(Color.YELLOW);
        g.fillOval(270, 160, 10, 10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Scenery Frame"); // Create a new JFrame with a title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
        frame.setSize(500, 400); // Set the size of the frame
        SceneryFrame scenery = new SceneryFrame(); // Create a new instance of the SceneryFrame class
        frame.add(scenery); // Add the SceneryFrame object to the JFrame
        frame.setVisible(true); // Set the JFrame to be visible
    }
}
