/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jsandwhich.java;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JSandwich extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Components
    private JComboBox<String> sandwichBox;
    private JComboBox<String> breadBox;
    private JLabel resultLabel;

    // Sandwiches and prices
    String[] sandwiches = {
            "Chicken",
            "Beef",
            "Veggie"
    };

    double[] sandwichPrices = {
            45.0,
            55.0,
            35.0
    };

    // Bread types
    String[] breads = {
            "White Bread",
            "Brown Bread",
            "Rye Bread"
    };

    double[] breadPrices = {
            10.0,
            12.0,
            15.0
    };

    public JSandwich() {

        setTitle("Sublime Sandwich Shop");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
        resultLabel = new JLabel("", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

    
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add panels
        mainPanel.add(createWelcomePanel(), "Welcome");
        mainPanel.add(createOrderPanel(), "Order");
        mainPanel.add(createReceiptPanel(), "Receipt");

        add(mainPanel);

        setVisible(true);
    }

 
    private JPanel createWelcomePanel() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(200, 230, 255));

        JLabel title = new JLabel(
                "Welcome to Sublime Sandwich Shop",
                JLabel.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 28));

        JButton startBtn = new JButton("Start Order");

        startBtn.setFont(new Font("Arial", Font.BOLD, 20));

        startBtn.addActionListener(e ->
                cardLayout.show(mainPanel, "Order"));

        panel.add(title, BorderLayout.CENTER);
        panel.add(startBtn, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createOrderPanel() {

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBorder(
                BorderFactory.createEmptyBorder(30,30,30,30)
        );

        JLabel heading = new JLabel("Choose Your Sandwich");

        heading.setFont(new Font("Arial", Font.BOLD, 24));

        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

     
        sandwichBox = new JComboBox<>(sandwiches);

        breadBox = new JComboBox<>(breads);

        JButton calculateBtn = new JButton("Calculate Price");

        calculateBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        calculateBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int sandwichIndex =
                        sandwichBox.getSelectedIndex();

                int breadIndex =
                        breadBox.getSelectedIndex();

                double total =
                        sandwichPrices[sandwichIndex]
                                + breadPrices[breadIndex];

                String message =
                        "You selected "
                                + sandwiches[sandwichIndex]
                                + " with "
                                + breads[breadIndex]
                                + " | Total Price: R"
                                + total;

                resultLabel.setText(message);

                cardLayout.show(mainPanel, "Receipt");
            }
        });

        panel.add(heading);

        panel.add(Box.createRigidArea(
                new Dimension(0,20)));

        panel.add(new JLabel("Choose Sandwich:"));
        panel.add(sandwichBox);

        panel.add(Box.createRigidArea(
                new Dimension(0,20)));

        panel.add(new JLabel("Choose Bread Type:"));
        panel.add(breadBox);

        panel.add(Box.createRigidArea(
                new Dimension(0,30)));

        panel.add(calculateBtn);

        return panel;
    }

    
    private JPanel createReceiptPanel() {

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBorder(
                BorderFactory.createEmptyBorder(30,30,30,30)
        );

        JLabel title = new JLabel("Order Receipt");

        title.setFont(new Font("Arial", Font.BOLD, 28));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backBtn = new JButton("Back to Start");

        backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        backBtn.addActionListener(e ->
                cardLayout.show(mainPanel, "Welcome"));

        panel.add(title);

        panel.add(Box.createRigidArea(
                new Dimension(0,30)));

        panel.add(resultLabel);

        panel.add(Box.createRigidArea(
                new Dimension(0,30)));

        panel.add(backBtn);

        return panel;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new JSandwich());
    }
}