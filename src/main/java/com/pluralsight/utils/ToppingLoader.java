package com.pluralsight.utils;

import com.pluralsight.model.Topping;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ToppingLoader {

    public static List<Topping> loadToppings(String filePath) {
        List<Topping> toppings = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;


            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }


                String[] values = line.split(",");


                if (values.length == 3) {
                    String category = values[0].trim();
                    String name = values[1].trim();
                    double price = Double.parseDouble(values[2].trim());


                    Topping topping = new Topping(name, category, price);
                    toppings.add(topping);
                }
            }

            System.out.println("Successfully loaded " + toppings.size() + " toppings.");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing price: " + e.getMessage());
        }

        return toppings;
    }
}

