package GUI;

import DAO.DAO_User;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Signup extends JFrame{

    JPanel p1;
    JLabel l, l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    String url = "jdbc:h2:./default";
    String username = "";
    String password = "";

    public GUI_Signup() {
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBounds(25,25,250,200);

        l = new JLabel("");
        l1 = new JLabel("Firstname");
        l2 = new JLabel("Lastname");
        l3 = new JLabel("Username");
        l4 = new JLabel("Password");
        l5 = new JLabel("Email");
        l6 = new JLabel("");

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);
        t5 = new JTextField(15);

        b1 = new JButton("Signup");
        b2 = new JButton("Login");

        add(p1);        add(l);
        p1.add(l1);        p1.add(t1);
        p1.add(l2);        p1.add(t2);
        p1.add(l3);        p1.add(t3);
        p1.add(l4);        p1.add(t4);
        p1.add(l5);        p1.add(t5);
        p1.add(b1);        p1.add(b2);
        p1.add(l6);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ac) {
                String s = "";
                if (t1.getText().equals(s) || t2.getText().equals(s) || t3.getText().equals(s)
                        || t4.getText().equals(s) || t5.getText().equals(s) ){
                    l6.setText("Please fill all the cases");
                }else{
                    try {
                        DAO_User dao_signup = new DAO_User(url, username,password);
                        User user = new User();
                        user.setFirstName(t1.getText());
                        user.setLastName(t2.getText());
                        user.setUsername(t3.getText());
                        user.setPassword(t4.getText());
                        user.setEmail(t5.getText());

                        dao_signup.saveSignup(user);

                        GUI_Ticket u = new GUI_Ticket();
                        setVisible(false);

                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ac) {
                GUI_Login u = new GUI_Login();
                setVisible(false);
            }
        });

        setVisible(true);
        setLayout(null);
        setSize(500,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
