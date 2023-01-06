package Autres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Driver {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guestmanager", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from guest");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Name_Guest"));

            }
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }
}
