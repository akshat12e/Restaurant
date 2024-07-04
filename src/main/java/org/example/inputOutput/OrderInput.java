package org.example.inputOutput;

import java.util.Map;

public class OrderInput {

    Map<String, Integer> itemQuantity;

    public OrderInput(Map<String, Integer> itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Map<String, Integer> getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Map<String, Integer> itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "OrderInput{" +
                "itemQuantity=" + itemQuantity +
                '}';
    }
}
