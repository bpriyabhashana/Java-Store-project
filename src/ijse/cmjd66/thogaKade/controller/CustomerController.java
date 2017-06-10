/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijse.cmjd66.thogaKade.controller;

import ijse.cmjd66.thogaKade.db.DBConnection;
import ijse.cmjd66.thogaKade.model.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class CustomerController {
    public static ArrayList<String> getAllCustomerIds() throws ClassNotFoundException, SQLException{
        Connection connect=DBConnection.getDBConnection().getConnection();
        Statement stm=connect.createStatement();
        String SQL="Select id from Customer";
        ResultSet rst=stm.executeQuery(SQL);
        ArrayList<String>customerIds=new ArrayList<>();
        while(rst.next()){
            customerIds.add(rst.getString("id"));
        }
       
        return customerIds;
    }
    public static Customer searchCustomer(String id)throws ClassNotFoundException,SQLException{
        Connection connect=DBConnection.getDBConnection().getConnection();
        Statement stm=connect.createStatement();
        String SQL="Select * From Customer where id='"+id+"'";
        ResultSet rst=stm.executeQuery(SQL);
        if(rst.next()){
            Customer customer=new Customer(id, rst.getString("name"),rst.getString("address"),rst.getDouble("salary"));
            return customer;
        }
       
        return null;

    }


}
