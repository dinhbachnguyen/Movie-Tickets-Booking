package DAO;

import Model.User;

import java.sql.*;


public class DAO_User{
    private String url, username,password;
    public DAO_User(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void saveSignup(User user){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            if (user.getId()!=null){
                PreparedStatement statement = connection.prepareStatement
                        ("update user set firstname = ?, lastname = ?, username = ?, password = ?, email = ? where id  = ?;");
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getUsername());
                statement.setString(4, user.getPassword());
                statement.setString(5, user.getEmail());
                statement.setLong(6, user.getId());
                statement.execute();
            }else{
                PreparedStatement statement = connection.prepareStatement
                        ("insert into user (firstname, lastname, username, password, email) values (?, ?, ?, ?, ?);");
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getUsername());
                statement.setString(4, user.getPassword());
                statement.setString(5, user.getEmail());
                statement.execute();

                System.out.println(user.getFirstName()+" Saved into the database'");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to save the user");
        }
    }

    public User getuserbyID(int Id) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement
                    ("select * from user where id  = ?;");

            statement.setLong(1, Id);
            ResultSet resultSet = statement.executeQuery();

            User user = new User();

            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
