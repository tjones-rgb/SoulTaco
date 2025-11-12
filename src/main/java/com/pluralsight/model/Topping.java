package com.pluralsight.model;

public class Topping {
    private final String name;
    private final String type;
    private final double price;


    public Topping (String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public String getName(){return name;}
    public String getType() {return type;}
    public boolean isPremium() {return "premium".equalsIgnoreCase(type); }
    public double getPrice() {return price; }

    @Override
    public String toString() {
        return name + (isPremium() ? "(Premium)" : "") + " -$" + String.format("%.2f" , price);
    }
}
