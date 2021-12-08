package ap.soft;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Shape {
    public Oval(Point position) {
        super(position);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(position.x, position.y, 30, 30);
    }
}
