package org.example.repository;

import org.example.entity.Menu;
import org.example.entity.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantRepository {

    Map<String, Restaurant> restaurantMap;
    private static RestaurantRepository restaurantRepository = null;

    private RestaurantRepository(){
        restaurantMap = new HashMap<>();
    }

    public static RestaurantRepository getRestaurantRepoInstance(){
        if(restaurantRepository == null){
            restaurantRepository = new RestaurantRepository();
        }
        return restaurantRepository;
    }

    public Restaurant addRestaurant(String name, Menu menu, int cap){
        Restaurant restaurant = new Restaurant(name, menu, cap);
        restaurantMap.put(name, restaurant);
        return restaurant;
    }

    public void updateMenu(String name, Menu menu){
        Restaurant restaurant = restaurantMap.get(name);
        Menu menu1 = restaurant.getMenu();
        for(String item: menu.getItemList().keySet()){
            menu1.getItemList().put(item, menu.getItemList().get(item));
        }
    }

    public List<Restaurant> printRestaurantDetails(){
        List<Restaurant> restaurants = new ArrayList<>();
        for(String name: restaurantMap.keySet()){
            restaurants.add(restaurantMap.get(name));
        }
        return restaurants;
    }

}
