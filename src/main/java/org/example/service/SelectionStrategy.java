package org.example.service;

import javafx.util.Pair;
import org.example.entity.Order;
import org.example.entity.Restaurant;
import org.example.inputOutput.OrderInput;

import java.util.List;

public interface SelectionStrategy {

    public Pair<Restaurant, Integer> getBestRestaurant(List<Restaurant> eligibleRestaurant, OrderInput orderInput);
}
