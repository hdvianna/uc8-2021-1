package absolute;

import javax.swing.*;
import java.awt.*;

public class AbsolutePositioningExample extends JFrame {
    public AbsolutePositioningExample() {
        initializeFrame();
    }

    private void initializeFrame() {
        setLayout(null);

        JButton okButton = new JButton();
        okButton.setText("Ok");
        okButton.setBounds(50, 40, 100, 30);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name:");
        nameLabel.setBounds(5, 0, 100, 30);

        JTextField nameText = new JTextField();
        nameText.setText("");
        nameText.setColumns(30);
        nameText.setBounds(50, 5, 200, 30);

        setLayout(null);

        add(nameLabel);
        add(nameText);
        add(okButton);
        setTitle("Absolute Positioning Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 110));

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
        AbsolutePositioningExample frame = new AbsolutePositioningExample();
        frame.display();
    }
}
