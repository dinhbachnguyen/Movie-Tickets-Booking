package Autres;

import javax.swing.*;

public class Image extends JFrame{
    JPanel p = new JPanel();
    JLabel l = new JLabel();

    public Image(){
        setVisible(true);
//        pack();
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l.setIcon(new ImageIcon("1.jpg"));
        p.add(l);
        add(p);
        validate();
    }

    public static void main(String[] args)
    {
        Image m = new Image();
    }

}
