/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijse.cmjd66.thogaKade.controller;

import ijse.cmjd66.thogaKade.db.DBConnection;
import ijse.cmjd66.thogaKade.model.OrderDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class OrderDetailController {

    public static boolean addOrderDetail(OrderDetail orderDetail) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();

        String SQL = "Insert into OrderDetail Values('" + orderDetail.getOrderId() + "','" + orderDetail.getIteMCode() + "'," + orderDetail.getQty() + "," + orderDetail.getUnitPrice() + ")";
        return stm.executeUpdate(SQL)>0;
    }

    public static boolean addOrderDetail(ArrayList<OrderDetail> orderDetailList) throws ClassNotFoundException, SQLException {
        
        for (OrderDetail orderDetail : orderDetailList) {
           if( ! addOrderDetail(orderDetail)){
              return  false;
           }
        }
        
        return true;
    }

}
