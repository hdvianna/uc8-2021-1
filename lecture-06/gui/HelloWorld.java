package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld extends JFrame {


    private JPanel container;
    private JTextField nameField;
    private JButton greeting;

    public static void main(String[] args) {
        (new HelloWorld()).showMe();
    }

    public HelloWorld() {
        greeting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showMessage();
            }
        });
    }

    private void showMessage() {
        String greeting = "Hello, " + nameField.getText() + "!";
        javax.swing.JOptionPane.showMessageDialog(
                this,
                greeting,
                "Hello, World!",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void showMe() {
        setTitle("Hello World");
        setContentPane(container);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }


}
