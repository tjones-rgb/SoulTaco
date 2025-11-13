package com.pluralsight.model;

public class Topping {
    private String type;
    private String name;
    private double price;

    public Topping(String type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") - $" + String.format("%.2f", price);
    }
}
