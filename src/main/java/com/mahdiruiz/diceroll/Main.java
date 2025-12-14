package com.mahdiruiz.diceroll;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random random = new Random();

    // The method now accepts the Scanner and throws an exception
    private static void rollDice(int sides, Scanner scanner)
            throws InterruptedException {

        System.out.println("The d" + sides + " tumbles...");

        // Pause for 1 second to simulate rolling
        Thread.sleep(1000);

        int result = random.nextInt(sides) + 1;
        System.out.println("\n*** Result: " + result + " ***");

        // Wait for the user to press Enter
        System.out.println("\nPress ENTER to return to the menu...");
        scanner.nextLine();
    }

    public static void main (String[]args){
        int choice = -1;

        // Use Try-with-Resources to safely handle the Scanner
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Diceroll");
            System.out.println("(C) 2025 by Mahdi Ruiz");

            // Loop runs inside the try block
            while (choice != 0) {
                System.out.println("\n---Choose a dice---");
                System.out.println("1: d4");
                System.out.println("2: d6");
                System.out.println("3. d8");
                System.out.println("4. d10");
                System.out.println("5. d12");
                System.out.println("6. d20");
                System.out.println("0. Exit");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Rolling a d4");
                        rollDice(4, scanner);
                        break;
                    case 2:
                        System.out.println("Rolling a d6");
                        rollDice(6, scanner);
                        break;
                    case 3:
                        System.out.println("Rolling a d8");
                        rollDice(8, scanner);
                        break;
                    case 4:
                        System.out.println("Rolling a d10");
                        rollDice(10, scanner);
                        break;
                    case 5:
                        System.out.println("Rolling a d12");
                        rollDice(12, scanner);
                        break;
                    case 6:
                        System.out.println("Rolling a d20");
                        rollDice(20, scanner);
                        break;
                    case 0:
                        System.out.println("Exiting Diceroll.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (InterruptedException e) {
            // Catches the exception thrown by Thread.sleep()
            System.out.println("\n--- Dice roll simulation interrupted. ---");
            Thread.currentThread().interrupt();
        }
    }
}