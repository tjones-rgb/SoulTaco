package com.pluralsight.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        if(items != null) items.add(0, item);
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(items);
    }
    public double getTotal(){
        return items.stream().mapToDouble(MenuItem ::getPrice).sum();
    }
    public void printOrder() {
        System.out.println("\n--- ORDER DETAILS ---");
        if(items.isEmpty()) {
            System.out.println("No items in order");
        }else {
            items.forEach(items -> {
                System.out.println(items.getDetail());
                System.out.println("----------------------");
            });
        }
        System.out.printf("Total: $%.2f%n", getTotal());
    }
    public void saveReceipt() {
        try{
            File dir = new File("receipts");
            if (!dir.exists()) dir.mkdir();

            String filename = "receipts/" + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HH")) + ".txt";

            try(FileWriter fw = new FileWriter(filename)) {
                fw.write("SOUL-TACO Receipt\n\n");
                for (MenuItem item : items) {
                    fw.write(item.getDetail() + "\n\n");

                }

                fw.write(String.format("TOTAL: $%.2f\n", getTotal());
            }
                System.out.println("Receipt saved: " + filename);
        }catch (IOException e) {
                e.printStackTrace();
            }
    }
}
