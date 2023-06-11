package com.testing;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PaintApp extends JFrame implements ActionListener, MouseMotionListener {

    // Declare GUI components
    private JPanel drawingBoard;
    private JButton saveButton;
    private BufferedImage image;
    private Graphics2D g2;
    private int lastX, lastY;

    public PaintApp() {
        // Set up the JFrame
        setTitle("Paint App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the drawing board
        drawingBoard = new JPanel();
        drawingBoard.setBackground(Color.WHITE);
        drawingBoard.setPreferredSize(new Dimension(800, 600));
        drawingBoard.addMouseMotionListener(this);

        // Create the save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);

        // Add the components to the JFrame
        add(drawingBoard, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        // Set up the BufferedImage and Graphics2D
        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        g2 = image.createGraphics();
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
    }

    // ActionListener method for the save button
    public void actionPerformed(ActionEvent e) {
        try {
            // Get the file path from the user
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();

                // Write the BufferedImage to the file
                ImageIO.write(image, "png", file);
                JOptionPane.showMessageDialog(this, "Image saved successfully!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving image: " + ex.getMessage());
        }
    }

    // MouseMotionListener method for drawing
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        g2.drawLine(lastX, lastY, x, y);
        lastX = x;
        lastY = y;
        drawingBoard.repaint();
    }

    public void mouseMoved(MouseEvent e) {
        // Not needed
    }

    public static void main(String[] args) {
        // Create a new PaintApp object and show it
        PaintApp paintApp = new PaintApp();
        paintApp.pack();
        paintApp.setVisible(true);
    }
}

