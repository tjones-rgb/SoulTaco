package com.pluralsight.screens;

import com.pluralsight.model.ChipsAndSalsa;
import com.pluralsight.model.Order;
import com.pluralsight.model.Topping;
import com.pluralsight.utils.ToppingLoader;

import java.util.List;
import java.util.Scanner;

public class AddChips {
    private final Scanner scan;
    private final Order order;

    public AddChips(Scanner scan, Order order) {
        this.scan = scan;
        this.order = order;
    }
    public void display(){
        List<Topping> allToppings = ToppingLoader.loadToppings("src/main/resources/ToppingData.csv");

        System.out.println("\n---Add Chips & Salsa---");
        System.out.println("Available Salsa Types:");

        for (Topping t : allToppings) {
            if (t.getType().equalsIgnoreCase("Salsa")) {
                System.out.println("- " + t.getName() + " ($" + t.getPrice() + ")");
            }
        }
        System.out.println("Choose Your Salsa Type: ");
        String salsa = scan.nextLine();

        Topping selectedSalsa = null;

        for (Topping t : allToppings) {
            if(t.getType().equalsIgnoreCase("Salsa")
            && t.getName().equalsIgnoreCase(salsa)) {
                selectedSalsa = t;
                break;
            }
        }

        if (selectedSalsa == null) {
            System.out.println("Salsa Unavailable");
            return;
        }
        order.addItem(new ChipsAndSalsa(salsa));
        System.out.println("Chips & Salsa added: " + salsa);
    }
}
