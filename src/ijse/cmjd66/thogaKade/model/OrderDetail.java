/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijse.cmjd66.thogaKade.model;

/**
 *
 * @author student
 */
public class OrderDetail {
    private String orderId;
    private String iteMCode;
    private int qty;
    private double unitPrice;

    public OrderDetail() {
    }

    public OrderDetail(String orderId, String iteMCode, int qty, double unitPrice) {
        this.orderId = orderId;
        this.iteMCode = iteMCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {

        this.orderId = orderId;
    }

    /**
     * @return the iteMCode
     */
    public String getIteMCode() {
       
        return iteMCode;
    }

    /**
     * @param iteMCode the iteMCode to set
     */
    public void setIteMCode(String iteMCode) {
        this.iteMCode = iteMCode;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
}
