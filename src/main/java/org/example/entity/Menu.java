package org.example.entity;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;

public class Menu {

    HashMap<String, Integer> itemList;

    public Menu(HashMap<String, Integer> itemList) {
        this.itemList = itemList;
    }

    public HashMap<String, Integer> getItemList() {
        return itemList;
    }

    public void setItemList(HashMap<String, Integer> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "itemList=" + itemList +
                '}';
    }
}
