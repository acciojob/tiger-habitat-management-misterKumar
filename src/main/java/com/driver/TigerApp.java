package com.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Scanner;

public class TigerApp {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(TigerConfig.class);
        TigerHabitat tigerHabitat = context.getBean(TigerHabitat.class);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Tiger");
            System.out.println("2. List All Tigers");
            System.out.println("3. Get Tiger Details by Type");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTiger(tigerHabitat, scanner);
                    break;
                case 2:
                    listAllTigers(tigerHabitat);
                    break;
                case 3:
                    getTigerDetailsByType(tigerHabitat, scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);

        scanner.close();
    }

    private static void addTiger(TigerHabitat tigerHabitat, Scanner scanner) {
        System.out.print("Enter Tiger Type (Bengal/Siberian/Sumatran): ");
        String type = scanner.next();
        Tiger tiger = null;

        switch (type.toLowerCase()) {
            case "bengal":
                tiger = new BengalTiger();
                break;
            case "siberian":
                tiger = new SiberianTiger();
                break;
            case "sumatran":
                tiger = new SumatranTiger();
                break;
            default:
                System.out.println("Invalid Tiger Type.");
                return;
        }

        tigerHabitat.addTiger(tiger);
        System.out.println("Tiger added to the habitat.");
    }

    private static void listAllTigers(TigerHabitat tigerHabitat) {
        List<Tiger> allTigers = tigerHabitat.getAllTigers();
        for (Tiger tiger : allTigers) {
            System.out.println(tiger.getType());
        }
    }

    private static void getTigerDetailsByType(TigerHabitat tigerHabitat, Scanner scanner) {
        System.out.print("Enter Tiger Type: ");
        String type = scanner.next();
        Tiger tiger = tigerHabitat.getTigerByType(type);

        if (tiger != null) {
            System.out.println("Tiger Details:");
            System.out.println("Type: " + tiger.getType());
            System.out.println("Color: " + tiger.getColor());
            System.out.println("Average Weight: " + tiger.getAverageWeight() + " kg");
            System.out.println("Preferred Climate: " + tiger.getPreferredClimate());
        } else {
            System.out.println("Tiger not found.");
        }
    }
}

