package com.pluralsight.model;

public class ChipsAndSalsa extends MenuItem {
    private final String salsaType;

    public ChipsAndSalsa(String salsaType) {
        super("Chips & Salsa", 1.50);
        this.salsaType = salsaType;
    }

    @Override
    public String getDetail() {
        return name + "(" + salsaType + ") - $" + String.format("%.2f", price);
    }
}
