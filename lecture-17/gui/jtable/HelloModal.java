package gui.jtable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloModal extends JDialog {
    private JPanel rootContainer;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton saveButton;
    private JButton cancelButton;

    public HelloModal(Frame owner, boolean modal) {
        super(owner, modal);
        initializeWindow();
        initializeButtons();
    }
    private void initializeButtons() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }

    private void initializeWindow() {
        setTitle("New Character");
        setContentPane(rootContainer);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void showMe() {
        setLocationRelativeTo(getOwner());
        pack();
        setVisible(true);
    }

}
