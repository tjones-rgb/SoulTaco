package com.pluralsight.screens;

import com.pluralsight.model.ChipsAndSalsa;
import com.pluralsight.model.Order;

import java.util.Scanner;

public class AddChips {
    private final Scanner scan;
    private final Order order;

    public AddChips(Scanner scan, Order order) {
        this.scan = scan;
        this.order = order;
    }
    public void display(){
        System.out.println("Salsa type: ");
        String salsa = scan.nextLine();
        order.addItem(new ChipsAndSalsa(salsa));
        System.out.println("Chips & Salsa added");
    }
}
