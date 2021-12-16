package org.youcode.foracademy.test;

import org.youcode.foracademy.util.DbConnection;

import java.sql.Connection;

public class app {
    public static void main(String[] args) {
      Connection con = DbConnection.getConnection();
      if(con == null){
          System.out.println("Connection failed!!");
      }else{
          System.out.println("Connection Success");
      }
    }
}
