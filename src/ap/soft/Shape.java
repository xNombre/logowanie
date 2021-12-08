package ap.soft;

import java.awt.Point;
import javax.swing.JPanel;
import java.awt.Graphics;

abstract class Shape extends JPanel {
    Point position;

    public Shape(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    protected abstract void paintComponent(Graphics g);
}
