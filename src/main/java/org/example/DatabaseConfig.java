package org.example;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

//public class DatabaseConfig {
//    private static final String URL="jdbc:postgresql://localhost:5432/ttu_bank";
//    private static final String USER="";
//    private static final String PASSWORD="";
//
//    public static Connection getConnection() throws SQLException {
//        try{
//            Class.forName("org.postgresql.Driver");
//
//        }catch(ClassNotFoundException e){
//            System.out.println("Postgres Driver not found!");
//        }
//        return DriverManager.getConnection(URL,USER,PASSWORD);
//    }
//}

public class DatabaseConfig {
    private static final Dotenv dotenv=Dotenv.load();
    private static  final String URL=dotenv.get("DB_URL");
    private static final String USER=dotenv.get("DB_USER");
    private static final String PASSWORD=dotenv.get("DB_PASSWORD");

    public static Connection getConnection()throws SQLException{
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("Postgresql driver not found!");
        }
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    public static String getDbUrl(){
        return dotenv.get("DB_URL");
    }
}






