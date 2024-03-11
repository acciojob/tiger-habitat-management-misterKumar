package com.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Scanner;

public class TigerApp {
    public static void main(String[] args) {
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
            scanner.nextLine(); // Consume newline character

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
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);

        scanner.close();
    }

    private static void addTiger(TigerHabitat tigerHabitat, Scanner scanner) {
        System.out.print("Enter Tiger Type (Bengal/Siberian/Sumatran): ");
        String type = scanner.next().toLowerCase();
        Tiger tiger;

        switch (type) {
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

        // Consume newline character
        scanner.nextLine();

        System.out.print("Enter Tiger Color: ");
        String color = scanner.nextLine().trim();

        System.out.print("Enter Average Weight: ");
        double weight = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Enter Preferred Climate: ");
        String climate = scanner.nextLine().trim();

        // Set the attributes for the tiger based on its type
        tiger.setColor(color);
        tiger.setAverageWeight(weight);
        tiger.setPreferredClimate(climate);

        tigerHabitat.addTiger(tiger);
        System.out.println("Tiger added to the habitat.");
    }


    private static void listAllTigers(TigerHabitat tigerHabitat) {
        List<Tiger> allTigers = tigerHabitat.getAllTigers();
        if (allTigers.isEmpty()) {
            System.out.println("No tigers in the habitat.");
            return;
        }
        System.out.println("Tigers in the Habitat:");
        for (int i = 0; i < allTigers.size(); i++) {
            Tiger tiger = allTigers.get(i);
            System.out.println((i + 1) + ". Type: " + tiger.getType() +
                    ", Color: " + tiger.getColor() +
                    ", Average Weight: " + tiger.getAverageWeight() + " kg" +
                    ", Preferred Climate: " + tiger.getPreferredClimate());
        }
    }

    private static void getTigerDetailsByType(TigerHabitat tigerHabitat, Scanner scanner) {
        System.out.print("Enter Tiger Type (Bengal/Siberian/Sumatran): ");
        String type = scanner.next().toLowerCase();

        Tiger foundTiger = null;
        for (Tiger tiger : tigerHabitat.getAllTigers()) {
            if (tiger instanceof BengalTiger && type.equals("bengal")) {
                foundTiger = tiger;
                break;
            } else if (tiger instanceof SiberianTiger && type.equals("siberian")) {
                foundTiger = tiger;
                break;
            } else if (tiger instanceof SumatranTiger && type.equals("sumatran")) {
                foundTiger = tiger;
                break;
            }
        }

        if (foundTiger != null) {
            System.out.println("Tiger Details:");
            System.out.println("Type: " + foundTiger.getType());
            System.out.println("Color: " + foundTiger.getColor());
            System.out.println("Average Weight: " + foundTiger.getAverageWeight() + " kg");
            System.out.println("Preferred Climate: " + foundTiger.getPreferredClimate());
        } else {
            System.out.println("Tiger not found.");
        }
    }

}
