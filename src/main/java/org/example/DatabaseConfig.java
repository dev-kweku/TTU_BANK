package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL="JDBC:postgresql://localhost:5432/ttu_bank";
    private static final String USER="postgres";
    private static final String PASSWORD="silverdollor";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}







