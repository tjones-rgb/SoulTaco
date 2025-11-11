package com.pluralsight.screens;

import com.pluralsight.model.Order;

import java.util.Scanner;

public class OrderScreen{
    private final Scanner scan;
    private final Order order;

    public OrderScreen(Scanner scan, Order order) {
        this.scan = scan;
        this.order = order;
    }
        public void display() {
        boolean ordering = true;

    while (ordering) {
        System.out.println("\n===============================");
        System.out.println("        ORDER MENU        ");
        System.out.println("===============================");
        System.out.println("1) Add Taco");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips & Salsa");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.println("Please Make Your Choice");

        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1 -> new AddTaco(scan, order).display();
            case 2 -> new AddDrink(scan, order).display();
            case 3 -> new AddChips(scan, order).display();
            case 4 -> new Checkout(scan, order).display();
            case 0 -> {
                System.out.println("Order Has been canceled");
            ordering = false;}
        }
        default -> System.out.println("Error try again");
        }
    }
}
