package Autres;

import java.awt.*;
import javax.swing.*;


public class Nhap {
    public static void main(String[] args)
    {
        GUIn g = new GUIn();
    }

}

class GUIn extends JFrame{
    JLabel l1,l2,l3;
    JPanel p1,p2;

    public GUIn(){

        l1 = new JLabel("Hello");
        l2 = new JLabel("Bonjour");
        l3 = new JLabel("Xin Chao");
        p1 = new JPanel();
        p2 = new JPanel();


        add(l1);
        add(l2);
        add(l3);

        p1.setLayout(new GridLayout(1, 3));
        p2.setLayout(new FlowLayout());
        setVisible(true);
        setSize(370,580);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
