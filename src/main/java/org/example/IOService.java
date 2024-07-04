package org.example;

import org.example.entity.Menu;
import org.example.entity.Order;
import org.example.entity.Restaurant;
import org.example.inputOutput.InputCommand;
import org.example.inputOutput.OrderInput;
import org.example.repository.OrderRepository;
import org.example.repository.RestaurantRepository;
import org.example.service.BookingService;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IOService {


    RestaurantRepository restaurantRepository;
    OrderRepository orderRepository;
    BookingService bookingService;

    public IOService(){
        restaurantRepository = RestaurantRepository.getRestaurantRepoInstance();
        bookingService = new BookingService();
        orderRepository = OrderRepository.getOrderRepoInstance();
    }

    public void takeInput(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command in - (add_restaurant, update_menu, book, Print_all_restaurant_details, MarkAsDelivered, Print_all_orders_placed, exit)");
            InputCommand inputCommand = null;
            try {
                inputCommand = InputCommand.valueOf(sc.next());
            }catch (Exception e){
                System.out.println("Incorrect command try again");
                continue;
            }
            switch (inputCommand) {
                case add_restaurant: {
                    System.out.println("Please enter restaurant name");
                    String name = sc.next();
                    System.out.println("PLease enter no. of items ");
                    int itemNo = sc.nextInt();
                    Menu menu = new Menu(new HashMap<>());
                    for (int i = 0; i < itemNo; i++) {
                        System.out.println("Enter item name");
                        String itemName = sc.next();
                        System.out.println("Enter item price");
                        int itemPrice = sc.nextInt();
                        menu.getItemList().put(itemName, itemPrice);
                    }
                    System.out.println("Please enter processing capacity");
                    int quantity = sc.nextInt();
                    Restaurant restaurant = restaurantRepository.addRestaurant(name, menu, quantity);
                    System.out.println("Restaurant added successfully " + restaurant);
                    break;
                }
                case update_menu: {
                    System.out.println("Please enter restaurant name to updatemenu");
                    String name = sc.next();
                    System.out.println("PLease enter no. of items ");
                    int itemNo = sc.nextInt();
                    Menu menu = new Menu(new HashMap<>());
                    for (int i = 0; i < itemNo; i++) {
                        System.out.println("Enter item name");
                        String itemName = sc.next();
                        System.out.println("Enter item price");
                        int itemPrice = sc.nextInt();
                        menu.getItemList().put(itemName, itemPrice);
                    }
                    restaurantRepository.updateMenu(name, menu);
                    break;
                }
                case Print_all_restaurant_details: {
                    List<Restaurant> restaurants = restaurantRepository.printRestaurantDetails();
                    System.out.println(restaurants);
                    break;
                }
                case book:{
                    System.out.println("Enter customer name");
                    String cname = sc.next();
                    System.out.println("PLease enter no. of items to be ordered");
                    int itemNo = sc.nextInt();
                    OrderInput orderInput = new OrderInput(new HashMap<>());
                    for(int i= 0;i<itemNo;i++){
                        System.out.println("Enter item name");
                        String itemName = sc.next();
                        System.out.println("Enter item quantity");
                        int itemQuantity = sc.nextInt();
                        orderInput.getItemQuantity().put(itemName, itemQuantity);
                    }
                    Order order = bookingService.placeOrder(cname, orderInput);
                    if(order == null)
                        System.out.println("Order Rejected");
                    else
                        System.out.println("Order Placed from restaurant "+ order.getRestaurant()+ " and order Id is " + order.getId() + "and total amount " + order.getTotalAmount());
                    break;
                }
                case exit:{
                    return;
                }
                case MarkAsDelivered:{
                    System.out.println("Enter OrderId");
                    orderRepository.markDelivered(sc.next());
                    break;
                }
                case Print_all_orders_placed:{
                    System.out.println(orderRepository.printOrder());
                }
            }
        }
    }
}
