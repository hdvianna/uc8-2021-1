package singleresponsibility.implementation;

import singleresponsibility.Presentable;

import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel implements Presentable {

    private Color color;
    private int radius;
    private int x;
    private int y;

    public Circle(int x, int y, int radius, String color) {
        super();
        this.color = Color.decode(color);
        this.radius = radius;
        this.x = x;
        this.y = y;
        setBounds(x, y, radius * 2, radius* 2);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, radius * 2, radius* 2);
    }

    @Override
    public Component getComponent() {
        return this;
    }
}
