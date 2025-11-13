package com.pluralsight.utils;

import com.pluralsight.model.Topping;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class ToppingLoader {

    public static List<Topping>loadToppings(String filePath) {
        try {
            return Files.lines(Path.get(filePath))
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(data -> new Topping(
                            data[1].trim(),
                            data[0],
                            Double.parseDouble(data[2].trim())

                    ))
                    .collect(Collectors.toList());

            }catch (IOException e) {
            System.out.println("Error loading topping: " + e.getMessage());
            return List.of();
        }
    }
}
