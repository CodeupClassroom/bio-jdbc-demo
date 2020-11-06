import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

public class Demo {
    public static void main(String[] args) {
        long idToUpdate=0;
        Config config = new Config();
        ArrayList<Album> albums = new ArrayList<>();

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM albums");

            // ResultSet loop
            while(rs.next()){

                albums.add(
                        new Album(
                                rs.getLong("id"),
                                rs.getString("artist"),
                                rs.getString("name"),
                                rs.getInt("release_date"),
                                rs.getDouble("sales"),
                                rs.getString("genre")
                        )
                );

//                album.setId(rs.getLong("id"));
//                album.setName(rs.getString(3));
//                album.setSales(rs.getDouble("sales"));

//                System.out.println("rs.getLong(\"id\") = " + rs.getLong("id"));
//                System.out.println("rs.getString(3) = " + rs.getString(3));
//                System.out.println("rs.getDouble(\"sales\") = " + rs.getDouble("sales"));
            }

            // ArrayList loop
            for (Album album: albums) {
                System.out.println("album.getId() = " + album.getId());
                System.out.println("album.getArtist() = " + album.getArtist());
                System.out.println("album.getName() = " + album.getName());
                System.out.println("album.getRelease_date() = " + album.getRelease_date());
                System.out.println("album.getSales() = " + album.getSales());
                System.out.println("album.getGenre() = " + album.getGenre());
            }

//             INSERT EXAMPLE
//            String sql = "INSERT INTO albums (artist, name, release_date, sales, genre) VALUES('Nelly Furtado', 'Folklore', 2003, 50, 'pop')";
//            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
//            rs = statement.getGeneratedKeys();
//            if (rs.next()) {
//                idToUpdate = rs.getLong(1);
//                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
//            }

            //  DELETE EXAMPLE
//            long idToDelete = 34;
//            sql = "DELETE FROM albums where id = " + idToDelete;
//            statement.execute(sql);
//            System.out.println(idToDelete + " is gone");

            // UPDATE EXAMPLE
            double sales = 60.5;
            statement.execute("UPDATE albums SET sales = " + sales + " WHERE id = " + idToUpdate);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
