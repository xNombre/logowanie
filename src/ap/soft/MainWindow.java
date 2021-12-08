package ap.soft;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MainWindow extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    final int badbuttonSizeX = 120;
    final int badbuttonSizeY = 30;
    final int panelSizeX = 600;
    final int panelSizeY = 400;

    public MainWindow() throws HeadlessException {
        super("Bad button & shapes");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(panelSizeX, panelSizeY);

        JPanel contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton badbutton = new JButton();
        badbutton.setBounds(15, 15, badbuttonSizeX, badbuttonSizeY);
        badbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                if (e.getX() >= 20 && e.getX() <= 40 && e.getY() == 0) // btn 20-40px, top
                    return;

                // jump
                int newX, newY;
                Random randGen = new Random();

                do {
                    newX = randGen.nextInt(panelSizeX - badbuttonSizeX - 4);
                    newY = randGen.nextInt(contentPane.getSize().height - badbuttonSizeY - 4);
                } while (Math.abs(newX - badbutton.getX()) < 30 || Math.abs(newY - badbutton.getY()) < 30);

                badbutton.setLocation(newX, newY);
                contentPane.setBackground(getBackground()); // hacky way to restore default background color
            }
        });
        badbutton.setText("Click me (:");
        badbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contentPane.setBackground(new Color(0, 100, 0));
            }
        });
        contentPane.add(badbutton);

        Kanwa kanwa = new Kanwa();
        contentPane.addMouseMotionListener(kanwa);
        kanwa.setBounds(0, 0, panelSizeX, panelSizeY);
        contentPane.add(kanwa);
    }
}