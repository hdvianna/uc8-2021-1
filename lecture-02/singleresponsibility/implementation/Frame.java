package singleresponsibility.implementation;

import singleresponsibility.Presentable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Frame implements Presentable {

    private JPanel frame;

    public Frame(int width, int height, String color) {
        frame = new JPanel();
        frame.setLayout(null);
        frame.setBounds(0,0,width, height);
        frame.setBorder(new LineBorder(Color.decode(color), 20));
    }

    public void addPicture(Presentable presentable) {
        frame.add(presentable.getComponent());
    }

    @Override
    public Component getComponent() {
        return frame;
    }
}
