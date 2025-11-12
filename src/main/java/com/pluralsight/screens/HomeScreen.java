package com.pluralsight.screens;

import com.pluralsight.model.Order;

import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    //  private static final MusicPlayer music = new MusicPlayer();

    public static void main(String[] args) {
        //  music.playMusic ("resources/background.wav");
        //  HomeScreen();
    }


    public void Homescreen() {
        boolean running = true;

        while (running) {

            System.out.println("\n===============================");
            System.out.println("  S O U L   T A C O  ");
            System.out.println("===============================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Please Choose");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    OrderScreen orderScreen = new OrderScreen(scanner, new Order());
                    orderScreen.display();
                }

                case 0 -> {
                    running = false;
                    //  music.stopMusic();
                    System.out.println("Stay Blessed");
                }
                default -> System.out.println("Error PLease Try Again");

            }
        }
    }
}