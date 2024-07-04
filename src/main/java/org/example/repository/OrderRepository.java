package org.example.repository;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.example.entity.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {

    Map<String, Order> ordersAccepted;
    Map<String, Order> ordersDelivered;
    private static OrderRepository orderRepository = null;

    private OrderRepository(){
        ordersAccepted = new HashMap<>();
        ordersDelivered = new HashMap<>();
    }

    public static OrderRepository getOrderRepoInstance(){
        if(orderRepository == null)
            orderRepository = new OrderRepository();
        return orderRepository;
    }

    public void addAcceptedOrder(Order order){
        ordersAccepted.put(order.getId(), order);
    }

    public void markDelivered(String orderId){
        Order order = ordersAccepted.get(orderId);
        order.getRestaurant().setCapacity(order.getTotalQuantity() + order.getRestaurant().getCapacity());
        order.setDelivered(true);
        ordersDelivered.put(orderId, order);
        ordersAccepted.remove(orderId);
    }

    public List<Order> printOrder(){
        List<Order> orders = new ArrayList<>();
        for(String orderId: ordersAccepted.keySet()){
            orders.add(ordersAccepted.get(orderId));
        }
        return orders;
    }
}
