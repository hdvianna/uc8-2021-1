package singleresponsibility.violation;

import singleresponsibility.Presentable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FramedCircle  extends JPanel implements Presentable {

    private Color circleColor;
    private int radius;
    private int x;
    private int y;
    private JPanel frame;

    public FramedCircle(int width, int height, int x, int y, int radius, String borderColor, String circleColor) {
        super();
        this.circleColor = Color.decode(circleColor);
        this.radius = radius;
        this.x = x;
        this.y = y;
        frame = new JPanel();
        frame.setLayout(null);
        frame.setBounds(0,0,width, height);
        frame.setBorder(new LineBorder(Color.decode(borderColor), 20));
        setBounds(x, y, radius * 2, radius* 2);
        frame.add(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(circleColor);
        g.fillOval(0, 0, radius * 2, radius* 2);
    }

    @Override
    public Component getComponent() {
        return frame;
    }
}
