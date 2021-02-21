package boxlayout;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutExample extends JFrame {

    public GridBagLayoutExample() {
        init();
    }

    private void init() {
        GridBagLayout layout = new GridBagLayout();
        getContentPane().setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel  = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        getContentPane().add(nameLabel, constraints);

        JTextField nameText = new JTextField();
        nameText.setColumns(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        getContentPane().add(nameText, constraints);

        JLabel countryLabel  = new JLabel("Country:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        getContentPane().add(countryLabel, constraints);

        JTextField countryText = new JTextField();
        nameText.setColumns(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        getContentPane().add(countryText, constraints);

        JButton okButton = new JButton("Ok");
        JPanel deck = new JPanel();
        deck.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        deck.add(okButton);
        constraints.gridx = 1;
        constraints.gridy = 2;
        getContentPane().add(deck, constraints);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(350, 120));
        setTitle("Grid Bag Layout Example");

        pack();
        setLocationRelativeTo(null);
    }

    public void display() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        GridBagLayoutExample frame = new GridBagLayoutExample();
        frame.display();
    }

}
