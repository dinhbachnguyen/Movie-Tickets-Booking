package GUI;

import DAO.DAO_User;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Login extends JFrame{

    JPanel p1;
    JLabel l, l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;
    String url = "jdbc:h2:./default";
    String username = "";
    String password = "";

    public GUI_Login() {

        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBounds(25,25,280,200);
//        p1.setBackground(Color.orange);

        l = new JLabel("");
        l3 = new JLabel("Username");
        l4 = new JLabel("Password");
        l6 = new JLabel("");

        t3 = new JTextField(15);
        t4 = new JTextField(15);

        b1 = new JButton("Login");
        b2 = new JButton("Signup");
        b3 = new JButton("Login as Guest");

        add(p1);        add(l);
        p1.add(l3);     p1.add(t3);
        p1.add(l4);     p1.add(t4);
        p1.add(b1);     p1.add(b2);
        p1.add(b3);     p1.add(l6);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ac) {
                try {
                    DAO_User dao_login = new DAO_User(url, username,password);
                    for (int i = 1; i<100;i++){
                        User user= dao_login.getuserbyID(i);
                        String username = user.getUsername();
                        String password = user.getPassword();
                        if (username.equals(t3.getText()) && password.equals(t4.getText())){
                            GUI_Ticket u = new GUI_Ticket();
                            setVisible(false);
                            break;
                        } else {
                            l6.setText("Invalid Password or Username. Please try again");
//
                        }
                    }
                }catch(Exception e){
//                    e.printStackTrace();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ac) {
                GUI_Signup u = new GUI_Signup();
                setVisible(false);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ac) {
                GUI_Guest u = new GUI_Guest();
                setVisible(false);
            }
        });

        setVisible(true);
        setLayout(null);
        setSize(500,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
