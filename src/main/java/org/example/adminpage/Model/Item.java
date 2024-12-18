package org.example.adminpage.Model;

import javafx.scene.control.Button;

public class Item {

    private int foodId;
    private String name;
    private int stock;
    private Button addButton;
    private Button subtractButton;

    public Item(String name, int stock, int foodId) {
        this.name = name;
        this.stock = stock;
        this.foodId = foodId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
