package com.pluralsight.screens;

import com.pluralsight.model.Order;
import com.pluralsight.model.Taco;
import com.pluralsight.model.Topping;

import java.util.Scanner;

public class AddTaco {
    private final Scanner scan;
    private final Order order;

    public AddTaco(Scanner scan, Order order) {
        this.scan = scan;
        this.order = order;
    }

    public void display() {
        System.out.println("\n---Customize your taco---");
        System.out.println("Shell Type (corn/flour/hard shell/bowl): ");
        String shell = scan.nextLine();

        System.out.println("Taco size (Single/3-Taco/Burrito): ");
        String size = scan.nextLine();

        Taco taco = new Taco(size, shell, false);

        System.out.println("Add Meats");
        while (true) {
            System.out.println("Meat: ");
            String meat = scan.nextLine();
            if (meat.equalsIgnoreCase("done")) break;
            taco.addMeat(new Topping(meat, "preiom", 2.00));
        }
        System.out.println("\n---Add cheese (enter done to stop):");
        while (true) {
            System.out.println("Cheese: ");
            String cheese = scan.nextLine();
            if (cheese.equalsIgnoreCase("done")) break;
            taco.addCheese(new topping(cheese, "premium", 1.50));
        }
        System.out.println("\nAdd other toppings (enter done to stop):");
        while(true){
            System.out.println("Topping: ");
            String Topping = scan.nextLine();
            if(Topping.equalsIgnoreCase("done")) break;
            taco.addTopping(new Topping(topping,"regular", 0.25));
        }
        System.out.println("\nSelect sauaces (enter done to stop): ");
        while(true){
            System.out.println("Sauce: ");
            String sauce = scan.nextLine();
            if(sauce.equalsIgnoreCase("done"))break;
            taco.addSauce(sauce);
        }
        System.out.println("Would you lik it fried: Yes/No ");
        boolean deepFried = scan.nextLine().equalsIgnoreCase("yes");
        if(deepFried) {
            System.out.println("coming right up");
        }
        order.addItem(taco);
        System.out.println("taco added to your order");
    }
}