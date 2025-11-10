package com.pluralsight.screens;

import java.util.Scanner;

public class OrderScreen{
    private final Scanner scan;
    private final Order order;

    public OrderScreen(Scanner scan, Order order) {
        this.scan = scan;
        this.order = order;
    }
        public void display () {
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

        int choice = scanner.nextInt;
        scanner.nextLine();

        switch (choice) {
            case 1 ->
            case
        }
    }
}
