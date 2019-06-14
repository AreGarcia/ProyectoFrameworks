/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AppConnection {
    
       // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/tallerservicio";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   Connection connection = null;
   
   Statement statement = null;

   PreparedStatement preparedStatement = null;
   
   ResultSet resultSet = null;
   
   public AppConnection(){
       try {
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(AppConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void connect() throws SQLException{
        
        connection = DriverManager.getConnection(DB_URL,USER,PASS);
        
   }
   
   public void close() throws SQLException{
       if(connection != null){
           connection.close();
           connection = null;
       }
   }
    
}
