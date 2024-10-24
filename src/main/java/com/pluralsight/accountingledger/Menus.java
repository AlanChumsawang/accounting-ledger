package com.pluralsight.accountingledger;

import java.util.Scanner;

public class Menus {

    /*************************************************************
     The following methods handle user input in the multiple menus presented to the user.
     Based on the users input the methods either exit, throw errors or calls the class
     for the desired outcome.
     *************************************************************/
    public static void ledgerMenu(Scanner scanner) {
        boolean done = false;
        while (!done) {
            System.out.print(Prompts.getLedgerMenu());
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
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
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
                case "6":
                       customSearchMenu(scanner);
                case "0":
                    done = true;
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

    public static void customSearchMenu(Scanner scanner) {
        System.out.println("Enter the start date: ");
        String startDate = scanner.nextLine();
        System.out.println("Enter the end date: ");
        String endDate = scanner.nextLine();
        System.out.println("Enter the description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the vendor: ");
        String vendor = scanner.nextLine().trim();
        System.out.println("Enter the amount: ");
        String inputAmount = scanner.nextLine();
        double amount = 0.0;
        if (!inputAmount.isEmpty()) {
            try {
                amount = Double.parseDouble(inputAmount);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        Reports.customSearch(startDate, endDate, description, vendor, amount);
    }
}
