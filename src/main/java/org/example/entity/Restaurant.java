package org.example.entity;

public class Restaurant {

    String name;
    Menu menu;
    int capacity;

    public Restaurant(String name, Menu menu, int capacity) {
        this.name = name;
        this.menu = menu;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                ", capacity=" + capacity +
                '}';
    }
}
