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
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public abstract String getDetail();


}
