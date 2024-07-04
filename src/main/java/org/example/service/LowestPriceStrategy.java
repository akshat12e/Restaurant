package org.example.service;

import javafx.util.Pair;
import org.example.entity.Order;
import org.example.entity.Restaurant;
import org.example.inputOutput.OrderInput;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowestPriceStrategy implements SelectionStrategy{

    @Override
    public Pair<Restaurant, Integer> getBestRestaurant(List<Restaurant> eligibleRestaurant, OrderInput orderInput) {
        int minOrderAmount = 1000000000;
        Restaurant minPriceRestaurant = null;
        for(Restaurant restaurant: eligibleRestaurant){
            int amount = 0;
            for(String item: orderInput.getItemQuantity().keySet()){
                amount = amount + restaurant.getMenu().getItemList().get(item)*orderInput.getItemQuantity().get(item);
            }
            if(amount < minOrderAmount){
                minOrderAmount = amount;
                minPriceRestaurant = restaurant;
            }
        }
        return new Pair<>(minPriceRestaurant, minOrderAmount);
    }
}
