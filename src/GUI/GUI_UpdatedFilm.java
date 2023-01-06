package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_UpdatedFilm extends JFrame{

    JPanel p1;
    JLabel l, l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;

    public GUI_UpdatedFilm() {

        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBounds(100,100,280,200);
//        p1.setBackground(Color.orange);

        l = new JLabel("");
        l1 = new JLabel("Update success. New film is added.");

        b1 = new JButton("Update more");

        add(p1);        add(l);
        p1.add(l1);
        p1.add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI_Employee u = new GUI_Employee();
                setVisible(false);
            }
        });

        setVisible(true);
        setLayout(null);
        setSize(500,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
