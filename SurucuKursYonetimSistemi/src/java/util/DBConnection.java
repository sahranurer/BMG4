package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection connection;

    public Connection connect() {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proje?user=root&password=2697");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return connection;
    }
}
