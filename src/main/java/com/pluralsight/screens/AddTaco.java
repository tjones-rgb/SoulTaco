package com.pluralsight.screens;

import com.pluralsight.model.Order;
import com.pluralsight.model.Taco;
import com.pluralsight.model.Topping;
import com.pluralsight.utils.ToppingLoader;

import java.util.List;
import java.util.Scanner;

public class AddTaco {
    private final Scanner scan;
    private final Order order;

    public AddTaco(Scanner scan, Order order) {
        this.scan = scan;
        this.order = order;
    }

    public void display() {
        List<Topping> allToppings = ToppingLoader.loadToppings("src/resources/ToppingsData.csv");


        System.out.println("\n---Customize your taco---");

        System.out.println("Shell Type (corn/flour/hard shell/bowl): ");
        String shell = scan.nextLine();

        System.out.println("Taco size (Single/3-Taco/Burrito): ");
        String size = scan.nextLine();

        Taco taco = new Taco("Custom Taco", 0.0, size ,shell ,false);

        System.out.println("\nAvailable Meats:");
        allToppings.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Meat"))
                .forEach(t -> System.out.println("- " + t.getName() + " ($" + t.getPrice() + ")"));

        System.out.println("Add Meats");
        while (true) {
            System.out.println("Meat: ");
            String meat = scan.nextLine();
            if (meat.equalsIgnoreCase("done")) break;

            allToppings.stream()
                    .filter(t -> t.getName().equalsIgnoreCase(meat))
                    .findFirst()
                    .ifPresentOrElse(
                            taco ::addMeat,
                            ()-> System.out.println("Not found.Try again")
                    );
        }

        System.out.println("\nAvailable Cheese:");
        allToppings.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Cheese"))
                .forEach(t -> System.out.println("- " + t.getName() + " ($" + t.getPrice() + ")"));

        System.out.println("\n---Add cheese (enter done to stop):");
        while (true) {
            System.out.println("Cheese: ");
            String cheese = scan.nextLine();
            if (cheese.equalsIgnoreCase("done")) break;

            allToppings.stream()
                    .filter(t -> t.getName().equalsIgnoreCase(cheese))
                    .findFirst()
                    .ifPresentOrElse(
                            taco::addCheese,
                            () -> System.out.println("Not Found Try Again")
                    );
        }

        System.out.println("\nAvailable Toppings:");
        allToppings.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Toppings"))
                .forEach(t -> System.out.println("- " + t.getName() + " ($" + t.getPrice() + ")"));

        System.out.println("\nAdd other toppings (enter done to stop):");
        while(true){
            System.out.println("Topping: ");
            String Topping = scan.nextLine();
            if(Topping.equalsIgnoreCase("done")) break;

            allToppings.stream()
                    .filter(t -> t.getName().equalsIgnoreCase(Topping))
                    .findFirst()
                    .ifPresentOrElse(
                            taco ::addTopping,
                            ()-> System.out.println("Not found.Try again")
                    );
        }

        System.out.println("\nAvailable Sauces:");
        allToppings.stream()
                .filter(t -> t.getType().equalsIgnoreCase("Sauces"))
                .forEach(t -> System.out.println("- " + t.getName()));

        System.out.println("\nSelect sauces (enter done to stop): ");
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
        System.out.println("Taco added to your order");
    }
}