package singleresponsibility.violation;

import singleresponsibility.implementation.Circle;
import singleresponsibility.implementation.Frame;

import javax.swing.*;

public class RunMe extends JFrame {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RunMe runMe = new RunMe();
                runMe.showMe();
            }
        });
    }

    private void showMe() {

        FramedCircle framedCircle = new FramedCircle(200, 80, 200, 80, 200, "#00FF00", "#000000");
        add(framedCircle.getComponent());

        setTitle("Single Responsibility Violation");
        setBounds(0, 0, 800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
