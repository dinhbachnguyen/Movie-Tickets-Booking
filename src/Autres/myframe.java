package Autres;

import java.awt.*;
public class myframe extends Frame{

    Label l=new Label("Xin Chao");
    CheckboxGroup cbg=new CheckboxGroup();
    Checkbox c1=new Checkbox("PIRATES OF THE CARRIBEAN AT WORLD'S END",cbg,true);
    Checkbox c2=new Checkbox("SHREK THE THIRD",cbg,false);
    Checkbox c3=new Checkbox("SPIDER MAN 3",cbg,false);

    public myframe(String title){

        super(title);
        setLayout(new FlowLayout());
        this.add(l);
        this.add(c1);
        this.add(c2);
        this.add(c3);

    }

    public static void main(String[] arg )
    {

        myframe f=new myframe("Welcome to movie theater");
        f.setSize(400,400);
        f.setVisible(true);


    }

}
