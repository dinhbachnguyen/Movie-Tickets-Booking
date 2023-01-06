package Autres;
import javax.swing.*;
import java.awt.*;
public class Brouillon {
    public Brouillon() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel("User");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 45, 80, 25);
        panel.add(passwordLabel);

        JTextField passwordText = new JTextField();
        passwordText.setBounds(100, 45, 165, 25);
        panel.add(passwordText);

        frame.setVisible(true);
    }
}
