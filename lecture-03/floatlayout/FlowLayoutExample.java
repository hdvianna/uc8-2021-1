package floatlayout;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {

    public FlowLayoutExample() {
        initializeFrame();
    }

    private void initializeFrame() {
        FlowLayout layout = new FlowLayout();

        JButton okButton = new JButton();
        okButton.setText("Ok");

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name:");

        JTextField nameText = new JTextField();
        nameText.setText("");
        nameText.setColumns(30);
        nameText.setPreferredSize(new Dimension(100, 30));

        setLayout(layout);

        add(nameLabel);
        add(nameText);
        add(okButton);

        setTitle("Float Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 100));

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
        FlowLayoutExample frame = new FlowLayoutExample();
        frame.display();
    }
}
