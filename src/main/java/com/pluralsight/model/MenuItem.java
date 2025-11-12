package com.pluralsight.model;

import com.pluralsight.tacoApp.Item;

public abstract class MenuItem implements Item {
    protected String name;
    protected double price;

    public MenuItem(String name,double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public abstract String getDetail();


}
