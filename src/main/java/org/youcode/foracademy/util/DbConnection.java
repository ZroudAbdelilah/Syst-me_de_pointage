package org.youcode.foracademy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static String url = "jdbc:postgresql://localhost:5432/foracademy";
    private static String user = "postgres";
    private static String passwd = "password";

    private static Connection connect;

    public static Connection getConnection(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}




