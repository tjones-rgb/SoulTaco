package com.pluralsight.model;

public class Drink extends MenuItem {
    private final String size;
    private final String flavor;

    public Drink (String size, String flavor) {
        super(flovor + "Drink", determinePrice(size));
        this.size = size;
        this.flavor = flavor;
    }
    public static double determinePrice(String size) {
        if (size == null) return 0.0;
    }
}
