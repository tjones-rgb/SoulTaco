package com.pluralsight.screens;

import com.pluralsight.model.Order;

import java.util.Scanner;

public class AddDrink {
    private final Scanner scan;
    private final Order order;

    public AddDrink(Scanner scan, Order order) {
        this.scan = scan;
        this.order = order;
    }
    public void display(){
        System.out.println("Choose your size (Small/Medium/Large): ");
        String size scan.nextLine();
        System.out.println("Flavor: ");
        String flavor = scan.nextLine();
        order.addItem(new Drink(size, flour));
        System.out.println('Drink Added');

    }
}
