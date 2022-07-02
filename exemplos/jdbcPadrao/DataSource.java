package jdbcPadrao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataSource {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "user12";
        String password = "34klq*";

        return DriverManager.getConnection(url, user, password);
    }
}
