/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijse.cmjd66.thogaKade.controller;

import ijse.cmjd66.thogaKade.db.DBConnection;
import ijse.cmjd66.thogaKade.model.Item;
import ijse.cmjd66.thogaKade.model.OrderDetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class ItemController {

    public static boolean reduceUpdatStock(ArrayList<OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        for (OrderDetail orderDetail : orderDetailList) {
            String SQL = "Update Item set qtyOnHand=qtyOnHand -" + orderDetail.getQty() + " where code= '" + orderDetail.getIteMCode() + "'";
            if (stm.executeUpdate(SQL) ==0) {
              
                return false;
            }
        }
       
        return true;
    }

    public static ArrayList<String> getAllItemCodes() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select * from Item");
        ArrayList<String> itemCodes = new ArrayList<>();
        while (rst.next()) {
            itemCodes.add(rst.getString("code"));
        }
        return itemCodes;
    }

    public static Item searchItem(String code) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("Select * from Item where code='" + code + "'");
        if (rst.next()) {
            Item item = new Item(code, rst.getString("description"), rst.getDouble("unitPrice"), rst.getInt("qtyOnHand"));
            return item;
        }
        return null;
    }
}
