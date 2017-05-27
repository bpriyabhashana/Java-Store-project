/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijse.cmjd66.thogaKade.controller;

import ijse.cmjd66.thogaKade.db.DBConnection;
import ijse.cmjd66.thogaKade.model.OrderDetail;
import ijse.cmjd66.thogaKade.model.Orders;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author student
 */
public class OrderController {

    public static boolean addNewOrder(Orders order) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        try {
            Statement stm = connection.createStatement();
            String SQL = "insert into Orders values('" + order.getId() + "','" + order.getDate() + "','" + order.getCustomerId() + "')";
            connection.setAutoCommit(false);
            boolean isAddedOrder = stm.executeUpdate(SQL) > 0;
            if (isAddedOrder) {
                boolean isAddedDetail = OrderDetailController.addOrderDetail(order.getOrderDetails());
                if (isAddedDetail) {
                    boolean isUpdateStock = ItemController.reduceUpdatStock(order.getOrderDetails());
                    if (isUpdateStock) {
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
