/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijse.cmjd66.thogaKade.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author student
 */

/*import jdbc drivers and connect to the data base*/

public class DBConnection {
    private Connection connect;
    private static DBConnection dBConnection;
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        //make connection with driver manager
        connect=DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade","root","ijse");
    }
    /*return connection*/
   public Connection getConnection(){
       return connection;
   }
    public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException{
        if(dBConnection==null){
            dBConnection=new DBConnection();
        }
        return dBConnection;
     
    }
}
