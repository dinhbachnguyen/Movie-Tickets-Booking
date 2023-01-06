package GUI;

import DAO.DAO_Film;
import Model.Film;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI_Ticket extends JFrame
{
    JPanel p1, p2, p3, p4;
    ImageIcon i1,i2,i3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l81,l82,l83,l9,l91,l92,l93,l10,l101,l102,l103, l11;
    JRadioButton r1,r2,r3,r4,r5;
    JTextField t1;
    JButton b1, b2, b3;
    String url = "jdbc:h2:./default";
    String username = "";
    String password = "";



    public GUI_Ticket() {


        p1 = new JPanel(new FlowLayout());
        p1.setBounds(25,30,300,200);

        p2 = new JPanel(new FlowLayout());
        p2.setBounds(325,30,260,200);

        p3 = new JPanel(new FlowLayout());
        p3.setBounds(575,30,260,200);

        p4 = new JPanel(new FlowLayout());
        p4.setBounds(280,250,350,250);

        i1 = new ImageIcon("src/Pic/1.jpg");
        i2 = new ImageIcon("src/Pic/2.jpg");
        i3 = new ImageIcon("src/Pic/3.jpg");

        Image i4 = i1.getImage();
        Image mi1 = i4.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        i1 =  new ImageIcon(mi1);

        Image i5 = i2.getImage();
        Image mi2 = i5.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        i2 =  new ImageIcon(mi2);

        Image i6 = i3.getImage();
        Image mi3 = i6.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
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
        l82 = new JLabel("     Release Date: May 24, 2007    ");
        l83 = new JLabel("     Running Time: 168     ");
        l9 = new JLabel("   Name: SHREK THE THIRD    ");
        l91 = new JLabel("     Genre: Family    ");
        l92 = new JLabel("Release Date: May 18, 2007");
        l93 = new JLabel("Running Time: 93");
        l10 = new JLabel("Name: SPIDER MAN 3");
        l101 = new JLabel("Genre: Action/Adventure");
        l102 = new JLabel("Release Date: May 4, 2007");
        l103 = new JLabel("Running Time: 140");
        l11 = new JLabel("");

        r1 = new JRadioButton("PIRATES OF THE CARIBBEAN AT WORLD'S END");
        r2 = new JRadioButton("SHREK THE THIRD" +
                "");
        r3 = new JRadioButton("SPIDER MAN 3");
        r4 = new JRadioButton("Yes");
        r5 = new JRadioButton("No");

        t1 = new JTextField(15);

        b1 = new JButton("Buy Tickets");
        b2 = new JButton("Sign out");
        b3 = new JButton("Valider");

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);
        bg1.add(r3);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(r4);
        bg2.add(r5);

        add(p1);   add(p2);   add(p3);   add(p4);

        p1.add(l5);     p1.add(l8);    p1.add(l81);     p1.add(l82);    p1.add(l83);
        p2.add(l6);     p2.add(l9);    p2.add(l91);     p2.add(l92);    p2.add(l93);
        p3.add(l7);     p3.add(l10);   p3.add(l101);    p3.add(l102);   p3.add(l103);

        p4.add(l1);    p4.add(r1);
        p4.add(r2);    p4.add(r3);
        p4.add(l2);    p4.add(t1);
        p4.add(l3);    p4.add(r4);    p4.add(r5);
        p4.add(b1);    p4.add(b2);

        p4.add(l11);


        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ac) {
                try {
                    DAO_Film dao_film = new DAO_Film(url, username,password);
                    double total = 0;
                    double discount = 0.8;
                    int i = 0;
                    if (r1.isSelected()){i=1;}
                    if(r2.isSelected()){i=2;}
                    if (r3.isSelected()){i=3;}
                    if (r5.isSelected()){discount=1;}

                    int n = Integer.parseInt(t1.getText());

                    Film film= dao_film.getfilmbyID(i);
                    int price  = film.getPrice();
                    total = n * (total + price) * discount;
                    String texttotal = String.valueOf(total) + "Euros";
                    l11.setText(texttotal);
                    p4.add(b3);

                }catch(Exception e){
//                    e.printStackTrace();
                }

                String number = t1.getText();
                l4.setText(number);
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI_Login u = new GUI_Login();
                setVisible(false);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI_Bill u = new GUI_Bill();
                setVisible(false);
            }
        });

        setTitle("Welcome to my movie theater");
        setLayout(null);
        setVisible(true);
        setSize(925,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}