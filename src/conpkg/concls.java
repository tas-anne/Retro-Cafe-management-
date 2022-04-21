/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conpkg;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author HP
 */
public class concls {
    public Connection connection;
      public Connection getConnection(){
          String username="root";
          String password="";
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              
              connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant",username,password);
          } catch (Exception e) {
              e.printStackTrace();
          }
        return connection;
      }
}
