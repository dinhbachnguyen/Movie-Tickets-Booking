package GUI;

import DAO.DAO_Film;
import Model.Film;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Employee extends JFrame{

    JPanel p1;
    JLabel l, l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2;
    String url = "jdbc:h2:./default";
    String username = "";
    String password = "";

    public GUI_Employee() {
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBounds(25,25,275,200);

        l = new JLabel("");
        l1 = new JLabel("Name Film");
        l2 = new JLabel("Genre Film");
        l3 = new JLabel("Release Date");
        l4 = new JLabel("Running Time");
        l5 = new JLabel("Price");
        l6 = new JLabel("");
        l7 = new JLabel("");

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);
        t5 = new JTextField(15);

        b1 = new JButton("Update Film");


        add(p1);        add(l);
        p1.add(l1);        p1.add(t1);
        p1.add(l2);        p1.add(t2);
        p1.add(l3);        p1.add(t3);
        p1.add(l4);        p1.add(t4);
        p1.add(l5);        p1.add(t5);
        p1.add(b1);        p1.add(l6);
        p1.add(l7);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ac) {
                String s = "";
                if (t1.getText().equals(s) || t2.getText().equals(s) || t3.getText().equals(s)
                        || t4.getText().equals(s) || t5.getText().equals(s) ){
                    l6.setText("Please fill all the cases");
                }else{
                    try {
                        DAO_Film dao_film = new DAO_Film(url, username,password);
                        Film film = new Film();
                        film.setName(t1.getText());
                        film.setGenre(t2.getText());
                        film.setReleaseDate(t3.getText());
                        film.setRunningTime(t4.getText());
                        film.setPrice(Integer.parseInt(t5.getText()));

                        dao_film.saveFilm(film);

                        GUI_UpdatedFilm u = new GUI_UpdatedFilm();
                        setVisible(false);

                    }catch(Exception e){
//                      e.printStackTrace();
                        l7.setText("Invalid value");
                    }
                }
            }
        });


        setVisible(true);
        setLayout(null);
        setSize(500,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
