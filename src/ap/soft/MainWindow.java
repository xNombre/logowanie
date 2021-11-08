
package ap.soft;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

public class MainWindow extends JFrame {
    private HashMap<String, String> users = new HashMap<String, String>(Map.ofEntries(
        entry("pankurczak", "kfc"),
        entry("prezydent", "12345"),
        entry("student", "piwo"),
        entry("admin", "skomplikowanehaslo")));

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

    final Color defaultColor = new Color(200, 200, 200);

    public MainWindow() throws HeadlessException {
        super("Logowanie");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 300);

        JPanel contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(defaultColor);

        JTextField idTextField = new JTextField();
        idTextField.setBounds(60, 25, 160, 20);
        contentPane.add(idTextField);

        JButton loginButton = new JButton();

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(60, 55, 160, 20);
        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        contentPane.add(passwordField);

        loginButton.setBounds(15, 200, 100, 30);
        loginButton.setText("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = users.get(idTextField.getText());
                if (password != null && password.equals(new String(passwordField.getPassword()))) {
                    contentPane.setBackground(new Color(0, 100, 0));
                    return;
                }
                contentPane.setBackground(new Color(100, 0, 0));
            }
        });
        contentPane.add(loginButton);

        JButton resetButton = new JButton();
        resetButton.setBounds(130, 200, 100, 30);
        resetButton.setText("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             
                idTextField.setText("");
                passwordField.setText("");
                contentPane.setBackground(defaultColor);
            }
        });
        contentPane.add(resetButton);

        JLabel txta1 = new JLabel();
        txta1.setBounds(10, 25, 50, 20);
        txta1.setText("ID:");
        contentPane.add(txta1);

        JLabel txta2 = new JLabel();
        txta2.setBounds(10, 55, 50, 20);
        txta2.setText("Pass:");
        contentPane.add(txta2);
    }
}