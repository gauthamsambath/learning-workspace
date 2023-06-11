package com.testing;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleFrame extends JPanel {

    // Override the paint method to draw a circle
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(50, 50, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Frame"); // Create a new JFrame with a title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
        frame.setSize(300, 300); // Set the size of the frame
        CircleFrame circle = new CircleFrame(); // Create a new instance of the CircleFrame class
        frame.add(circle); // Add the CircleFrame object to the JFrame
        frame.setVisible(true); // Set the JFrame to be visible
    }
}
