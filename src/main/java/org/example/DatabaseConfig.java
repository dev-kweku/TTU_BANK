package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL="jdbc:postgresql://localhost:5432/ttu_bank";
    private static final String USER="degraft";
    private static final String PASSWORD="silverdollor";

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("org.postgresql.Driver");

        }catch(ClassNotFoundException e){
            System.out.println("Postgres Driver not found!");
        }
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}







