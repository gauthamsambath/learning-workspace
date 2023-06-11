package JavaSwing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DropDownListExample {

    public static void main(String[] args) {

        // Create an ArrayList containing some words
        ArrayList<String> words = new ArrayList<String>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("orange");

        // Create a new JFrame to hold the drop-down list
        JFrame frame = new JFrame("Drop-down List Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        // Create a new JPanel to hold the drop-down list and the side panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a new side panel to hold the "Front" and "Back" switches
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(51, 153, 255));
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create a new JPanel to hold the "Front" switch and add it to the side panel
        JPanel frontPanel = new JPanel(new BorderLayout());
        JToggleButton frontSwitch = new JToggleButton("Front", true);
        frontSwitch.setBackground(new Color(51, 190, 125));
        frontSwitch.setForeground(Color.WHITE);
        frontPanel.add(frontSwitch, BorderLayout.NORTH);
        sidePanel.add(frontPanel);

        // Create a new JPanel to hold the "Back" switch and add it to the side panel
        JPanel backPanel = new JPanel(new BorderLayout());
        JToggleButton backSwitch = new JToggleButton("Back");
        backSwitch.setBackground(new Color(51, 153, 255));
        backSwitch.setForeground(Color.WHITE);
        backPanel.add(backSwitch, BorderLayout.NORTH);
        sidePanel.add(backPanel);

        // Create a new JPanel for the front panel and add a label to it
        JPanel frontContentPanel = new JPanel(new BorderLayout());
        JLabel frontLabel = new JLabel("Front Panel");
        frontContentPanel.add(frontLabel, BorderLayout.CENTER);

        // Create a new JPanel for the back panel and add a label to it
        JPanel backContentPanel = new JPanel(new BorderLayout());
        JLabel backLabel = new JLabel("Back Panel");
        backContentPanel.add(backLabel, BorderLayout.CENTER);

        // Create a new JComboBox to hold the words
        JComboBox<String> dropDownList = new JComboBox<String>();

        // Add the words to the drop-down list
        for (String word : words) {
            dropDownList.addItem(word);
        }

        // Add the drop-down list to the front panel
        frontContentPanel.add(dropDownList, BorderLayout.NORTH);

        // Add the front panel and the back panel to the main panel
        mainPanel.add(frontContentPanel, BorderLayout.CENTER);
        mainPanel.add(backContentPanel, BorderLayout.CENTER);

        // Add an action listener to the "Front" switch to switch to the front panel
        frontSwitch.addActionListener(e -> {
            if (frontSwitch.isSelected()) {
                backSwitch.setSelected(false);
                mainPanel.remove(backContentPanel);
                mainPanel.add(frontContentPanel, BorderLayout.CENTER);
                mainPanel.revalidate();
                mainPanel.repaint();
            } else {
                frontSwitch.setSelected(true);
            }
        });

        // Add an action listener to the "Back" switch to switch to the back panel
        backSwitch.addActionListener(e -> {
            if (backSwitch.isSelected()) {
                frontSwitch.setSelected(false);
                mainPanel.remove(frontContentPanel);
                mainPanel.add(backContentPanel, BorderLayout.CENTER);
                mainPanel.revalidate();
                mainPanel.repaint();
            } else {
                backSwitch.setSelected(true);
            }
        });

        // Add the side panel to the main panel
        mainPanel.add(sidePanel, BorderLayout.WEST);

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
