package Autres;

import java.sql.*;

public class ProductDAO {
    private String url;
    private String username;
    private String password;

    public ProductDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void saveProduct(Products products){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            if (products.getId()!=null){
                PreparedStatement statement = connection.prepareStatement
                        ("update products set name = ? where id  = ?;");
                statement.setString(1, products.getName());
                statement.setLong(2, products.getId());
                statement.execute();
            }else{
                PreparedStatement statement = connection.prepareStatement
                        ("insert into products (name) values (?);");
                statement.setString(1, products.getName());
                statement.execute();

                System.out.println(products.getName()+"save into the database'");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("unable to save the products");
        }
    }

    public Products getProductbyID(Long Id) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement
                    ("select * from products where id  = ?;");

                statement.setLong(1, Id);
                ResultSet resultSet = statement.executeQuery();

                Products products = new Products();

                while (resultSet.next()){
                    products.setId(resultSet.getLong("id"));
                    products.setName(resultSet.getString("name"));
                }
                return products;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

