package com.pluralsight.model;

public class Drink extends MenuItem {
    private final String size;
    private final String flavor;

    public Drink (String size, String flavor) {
        super(flavor + "Drink", determinePrice(size));
        this.size = size;
        this.flavor = flavor;
    }
    public static double determinePrice(String size) {
        if (size == null) return 0.0;
        switch (size.trim().toLowerCase()) {
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: return 0.0;
        }
    }

    @Override
    public String getDetail() {
        return size + " " + flavor + "Drink -$" + String.format("5.2f" , getPrice());
    }
}
