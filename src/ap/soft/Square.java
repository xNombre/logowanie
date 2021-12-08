package ap.soft;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class Square extends Shape {
    public Square(Point position) {
        super(position);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(position.x, position.y, 30, 30);
    }
}
