package com.pluralsight.accountingledger;

import java.util.Scanner;

public class Menus {

    public static void ledgerMenu(Scanner scanner) {

        System.out.print(Prompts.ledgerMenu);
        String userChoice = scanner.nextLine().toUpperCase();
        System.out.println("\n\n\n");
        switch (userChoice) {
            case "A":
                TransactionManager.getAllTransactions();
                break;
            case "D":
                TransactionManager.displayDeposits();
                break;
            case "P":
                TransactionManager.displayPayments();
                break;
            case "R":
                Menus.reportsMenu(scanner);
                break;
            case "H":
                break;
            default:
                System.out.println("Invalid choice");

        }
    }

    public static void reportsMenu(Scanner scanner) {
        boolean done = false;
        while (!done) {

            System.out.print(Prompts.getReportsMenu());
            String userChoice = scanner.nextLine().trim();
            switch (userChoice) {
                case "1":
                    Reports.monthToDate();
                    break;
                case "2":
                    Reports.previousMonth();
                    break;
                case "3":
                    Reports.yearToDate();
                    break;

                case "4":
                    Reports.previousYear();
                    break;
                case "5":
                    System.out.println("Enter the vendor name: ");
                    userChoice = scanner.nextLine();
                    Reports.searchByVendor(userChoice);
                    break;
                case "0":
                    done = true;
                    ledgerMenu(scanner);
            }
        }

    }

    public static boolean mainMenu(Scanner scanner) {
        System.out.print(Prompts.getMainMenu());
        String userChoice = scanner.nextLine().toUpperCase();
        switch (userChoice) {
            case "D":
                TransactionManager.addDeposit(scanner);
                break;
            case "P":
                TransactionManager.makePayment(scanner);
                break;
            case "L":
                Menus.ledgerMenu(scanner);
                break;
            case "X":
                return true;
            default:
                System.out.println("\nInvalid choice\n");
                break;
        }
        return false;
    }

    public static void customSearch(Scanner scanner) {
        System.out.println("Enter the start date: ");
        String startDate = scanner.nextLine();
        System.out.println("Enter the end date: ");
        String endDate = scanner.nextLine();
        System.out.println("Enter the description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Reports.customSearch(startDate, endDate, description, vendor, amount);
    }
}
