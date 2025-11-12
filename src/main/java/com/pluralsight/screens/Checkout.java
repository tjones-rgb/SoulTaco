package com.pluralsight.screens;

import com.pluralsight.model.Order;

import java.util.Scanner;

public class Checkout {
    private final Scanner scan;
    private final Order order;

    public Checkout(Scanner scan, Order order) {
        this.scan = scan;
        this.order = order;
    }

    public void display() {
        System.out.println("\n===============================");
        System.out.println(" CHECKOUT ");
        System.out.println("===============================");
        order.printOrder();

        System.out.println("Confirm Order? yes/no: ");
        String confirm = scan.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            order.saveReceipt();
            System.out.println("Receipt saved Returning Home");
        } else {
            System.out.println("Order canceled.");
        }
    }
}