package ap.soft;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class Kanwa extends JPanel implements KeyListener, MouseMotionListener, FocusListener {
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    Point mousePosition = new Point(0, 0);

    public Kanwa() {
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        addFocusListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shape shape : shapes) {
            shape.paintComponent(g);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();

        if (key == 'k') {
            shapes.add(new Square(mousePosition));
        } else if (key == 'o') {
            shapes.add(new Oval(mousePosition));
        } else if (key == 'c') {
            shapes.clear();
        }

        // Repaint whole window so badbutton is included and doesn't
        // disappear after drawing a new shape
        SwingUtilities.windowForComponent(this).repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosition = e.getPoint();
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        requestFocus();
    }
}
