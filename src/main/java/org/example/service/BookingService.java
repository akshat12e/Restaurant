package org.example.service;

import javafx.util.Pair;
import org.example.entity.Order;
import org.example.entity.Restaurant;
import org.example.inputOutput.OrderInput;
import org.example.repository.OrderRepository;
import org.example.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

    RestaurantRepository restaurantRepository;
    OrderRepository orderRepository;

    public BookingService(){
        restaurantRepository = RestaurantRepository.getRestaurantRepoInstance();
        orderRepository = OrderRepository.getOrderRepoInstance();
    }

    public Order placeOrder(String cname, OrderInput orderInput){
        List<Restaurant> restaurants = checkOrderValidity(cname, orderInput);
        if(restaurants.isEmpty())
            return null;
        SelectionStrategy selectionStrategy = new LowestPriceStrategy();
        Pair<Restaurant, Integer> restaurantAmountPair = selectionStrategy.getBestRestaurant(restaurants, orderInput);
        Order order = new Order(cname, orderInput, restaurantAmountPair.getKey(), restaurantAmountPair.getValue());
        orderRepository.addAcceptedOrder(order);
        Restaurant restaurant = restaurantAmountPair.getKey();
        restaurant.setCapacity(restaurant.getCapacity() - order.getTotalQuantity());
        return order;
    }

    private List<Restaurant> checkOrderValidity(String cname, OrderInput orderInput){
        List<Restaurant> restaurants = restaurantRepository.printRestaurantDetails();
        List<Restaurant> eligibleRestaurant = new ArrayList<>();
        for(Restaurant restaurant: restaurants) {
            boolean allPresent = true;
            int sum = 0;
            for (String orderItem : orderInput.getItemQuantity().keySet()) {
                sum += orderInput.getItemQuantity().get(orderItem);
                if(!restaurant.getMenu().getItemList().containsKey(orderItem)){
                    allPresent = false;
                    break;
                }
            }
            if(allPresent){
                if(restaurant.getCapacity() >= sum)
                    eligibleRestaurant.add(restaurant);
            }
        }
        return eligibleRestaurant;
    }
}
