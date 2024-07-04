package org.example.entity;

import com.sun.corba.se.pept.encoding.InputObject;
import org.example.inputOutput.InputCommand;
import org.example.inputOutput.OrderInput;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

public class Order {

    String id;
    String customerName;
    OrderInput orderInput;
    Restaurant restaurant;
    Boolean isDelivered = false;
    int totalAmount;
    int totalQuantity = 0;


    public Order(String customerName, OrderInput orderInput, Restaurant restaurant, int amount) {
        this.customerName = customerName;
        this.orderInput = orderInput;
        this.restaurant = restaurant;
        totalAmount = amount;
        this.id = UUID.randomUUID().toString();
        for(String item: orderInput.getItemQuantity().keySet()){
            this.totalQuantity += orderInput.getItemQuantity().get(item);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public OrderInput getOrderInput() {
        return orderInput;
    }

    public void setOrderInput(OrderInput orderInput) {
        this.orderInput = orderInput;
    }

    public Boolean getDelivered() {
        return isDelivered;
    }

    public void setDelivered(Boolean delivered) {
        isDelivered = delivered;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", orderInput=" + orderInput +
                ", restaurant=" + restaurant +
                ", isDelivered=" + isDelivered +
                ", cost=" + totalAmount +
                ", totalQuantity=" + totalQuantity +
                '}';
    }
}
