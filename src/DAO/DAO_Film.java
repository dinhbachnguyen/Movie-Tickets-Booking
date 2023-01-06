package DAO;

import Model.Film;

import java.sql.*;

public class DAO_Film{
    private String url, username,password;
    public DAO_Film(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    public void saveFilm(Film film){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            if (film.getId()!=null){
                PreparedStatement statement = connection.prepareStatement
                        ("update film set name = ?, genre = ?, releasedate = ?, runningtime = ?, price = ?, where id  = ?;");
                statement.setString(1, film.getName());
                statement.setString(2, film.getGenre());
                statement.setString(3, film.getReleaseDate());
                statement.setString(4, film.getRunningTime());
                statement.setInt(5, film.getPrice());
                statement.setLong(6, film.getId());
                statement.execute();
            }else{
                PreparedStatement statement = connection.prepareStatement
                        ("insert into film (name, genre, releasedate,runningtime, price) values (?, ?, ?, ?, ?);");
                statement.setString(1, film.getName());
                statement.setString(2, film.getGenre());
                statement.setString(3, film.getReleaseDate());
                statement.setString(4, film.getRunningTime());
                statement.setInt(5, film.getPrice());
                statement.execute();

                System.out.println(film.getName()+" Saved into the database'");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to save the film");
        }
    }

    public Film getfilmbyID(int Id) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement
                    ("select * from film where id  = ?;");

            statement.setLong(1, Id);
            ResultSet resultSet = statement.executeQuery();

            Film film = new Film();

            while (resultSet.next()){
                film.setId(resultSet.getLong("id"));
                film.setName(resultSet.getString("name"));
                film.setGenre(resultSet.getString("genre"));
                film.setReleaseDate(resultSet.getString("releasedate"));
                film.setRunningTime(resultSet.getString("runningtime"));
                film.setPrice(resultSet.getInt("price"));

            }
            return film;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
