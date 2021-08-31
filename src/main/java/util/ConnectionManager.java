package util;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String PASSWORD = "123890";
    private static final String USERNAME = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/horse_race";

    public ConnectionManager() {
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Connection ERROR");
        }
    }

    public Connection getConnection() {
        Class<Driver> driverClass = Driver.class;
        Connection connection = null;
        connection = ConnectionManager.open();
        System.out.println("Connection OK");
        return connection;
    }
}
