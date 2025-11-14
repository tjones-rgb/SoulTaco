package com.pluralsight.screens;

import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Topping;
import com.pluralsight.utils.ToppingLoader;

import java.util.List;
import java.util.Scanner;

public class AddDrink {
    private final Scanner scan;
    private final Order order;

    public AddDrink(Scanner scan, Order order) {
        this.scan = scan;
        this.order = order;
    }
    public void display(){

        List<Topping> allToppings = ToppingLoader.loadToppings("src/main/resources/ToppingData.csv");

        System.out.println("\n---Add a Drink---");

        System.out.println("Available Drink Flavors:");

        for (Topping t : allToppings) {
            if (t.getType().equalsIgnoreCase("Drink")) {
                System.out.println("- " + t.getName() + "($" + t.getPrice() + ")" );
            }
        }

        System.out.print("Choose your size (Small/Medium/Large): ");
        String size = scan.nextLine();

        System.out.println("Choose Your Flavor");
        String flavor = scan.nextLine();

        Topping selectedDrink = null;

        for (Topping t : allToppings) {
            if(t.getType().equalsIgnoreCase("Drink")
            && t.getName().equalsIgnoreCase(flavor)) {
            selectedDrink = t;
            break;

            }
        }
        if (selectedDrink == null) {
            System.out.println("Invalid Drink Selected");
            return;
        }

        Drink drink = new Drink(size, selectedDrink.getName(), selectedDrink.getPrice());

        order.addItem(drink);
            System.out.println("Drink added: " + size + " " + flavor);

    }
}
