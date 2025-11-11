package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Taco extends MenuItem{
    private final String size;
    private final String shell;
    private final boolean deepFried;

    private final List<Topping> meats = new ArrayList<>();
    private final List<Topping> cheeses = new ArrayList<>();
    private final List<Topping> toppings = new ArrayList<>();
    private final List<String> sauces = new ArrayList<>();

    public Taco(String name, double price, String size, String shell, boolean deepFried) {
        super(name, price);
        this.size = size;
        this.shell = shell;
        this.deepFried = deepFried;
    }
    public void addMeat(Topping meat) {meats.add(meat); }
    public void addCheese(Topping cheese){ cheeses.add(cheese); }
    public void addTopping (Topping topping) { toppings.add(topping) ;}
    public void addSauce(String sauce) {sauces.add(sauce);}

    public double getBasePrice(){
        String Size = size == null ? "" : size.trim().toLowerCase();
        if (size.equals("single")) return 3.50;
        if (size.equals("3-tacos") || size.equals("3-taco")) return 9.00;
        if (size.equals("burrito")) return 8.50;
        return 0.0;
    }

}
