package singleresponsibility.implementation;

import javax.swing.*;

public class RunMe extends JFrame {
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RunMe runMe = new RunMe();
                runMe.showMe();
            }
        });
    }

    private void showMe() {

        Frame frame = new Frame(800, 600, "#000000");
        Circle circle = new Circle(200, 80, 200, "#00FF00");

        frame.addPicture(circle);
        add(frame.getComponent());

        setTitle("Single Responsibility Example");
        setBounds(0, 0, 800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
