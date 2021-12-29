package org.youcode.foracademy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String Host = "127.0.0.1";
    private static final int PORT = 5432;
    private static final String DB_NAME = "foracademy ";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";


    private static  Connection connection;

    public static Connection getConnection(){

        try {
            connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%d/%s",Host,PORT,DB_NAME),USERNAME,PASSWORD);
        }catch (SQLException se){
            se.printStackTrace();
        }
        return connection;
    }

}
