package Autres;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Ticket extends JFrame
{
    JPanel p;
    ImageIcon i1,i2,i3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l81,l82,l9,l91,l92,l10,l101,l102;
    JRadioButton r1,r2,r3,r4,r5;
    JTextField t1;
    JButton b;

    public GUI_Ticket() {

        p = new JPanel();
        p.setLayout(null);


//        i1 = new ImageIcon(getClass().getResource("1.png"));
        i1 = new ImageIcon("1.jpg");
        i2 = new ImageIcon("2.jpg");
        i3 = new ImageIcon("3.jpg");

        java.awt.Image i4 = i1.getImage();
        java.awt.Image mi1 = i4.getScaledInstance(150, 100, java.awt.Image.SCALE_SMOOTH);
        i1 =  new ImageIcon(mi1);

        java.awt.Image i5 = i2.getImage();
        java.awt.Image mi2 = i5.getScaledInstance(150, 100, java.awt.Image.SCALE_SMOOTH);
        i2 =  new ImageIcon(mi2);

        java.awt.Image i6 = i3.getImage();
        java.awt.Image mi3 = i6.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        i3 =  new ImageIcon(mi3);


        l1 = new JLabel("Choose the movie you want to watch");
        l2 = new JLabel("Number of tickets:");
        l3 = new JLabel("Do you want a student discounts");
        l4 = new JLabel("0");
        l5 = new JLabel(i1);
        l6 = new JLabel(i2);
        l7 = new JLabel(i3);
        l8 = new JLabel("PIRATES OF THE CARIBBEAN AT WORLD'S END");
        l81 = new JLabel("Genre: Action/Adventure");
        l82 = new JLabel("Release Date: May 24, 2007 Running Time: 168");
        l9 = new JLabel("SHREK THE THIRD");
        l91 = new JLabel("Genre: Family");
        l92 = new JLabel("Release Date: May 18, 2007 Running Time: 93");
        l10 = new JLabel("SPIDER MAN 3");
        l101 = new JLabel("Genre: Action/Adventure");
        l102 = new JLabel("Release Date: May 4, 2007 Running Time: 140");

        r1 = new JRadioButton("PIRATES OF THE CARIBBEAN AT WORLD'S END");
        r2 = new JRadioButton("SHREK THE THIRD" +
                "");
        r3 = new JRadioButton("SPIDER MAN 3");
        r4 = new JRadioButton("Yes");
        r5 = new JRadioButton("No");

        t1 = new JTextField(15);

        b = new JButton("Buy Tickets");

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);
        bg1.add(r3);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(r4);
        bg2.add(r5);


        add(l5);     add(l8);
        add(l6);     add(l9);
        add(l7);     add(l10);


        add(l1);    add(r1);
        add(r2);    add(r3);
        add(l2);    add(t1);
        add(l3);    add(r4);    add(r5);

        add(b);


        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String number = t1.getText();
                l4.setText(number);
            }
        });


        setTitle("Welcome to my movie theater");
//        setLayout(new GridLayout(2, 3));
        setLayout(new FlowLayout());
        setVisible(true);
//        pack();
        setSize(370,580);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}