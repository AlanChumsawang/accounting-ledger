package com.pluralsight.accountingledger;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionManager {
    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static LocalDateTime today = LocalDateTime.now();
    static DateTimeFormatter monthDayYear = DateTimeFormatter.ofPattern("MMM-dd-yyyy ");
    static DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm ");

    public static void addDeposit(Scanner scanner) {
        String date = today.format(monthDayYear);
        String transactionTime = today.format(time);
        System.out.print("Enter the description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter the amount: ");
        double amount = (scanner.nextDouble());
        scanner.nextLine();
        Transaction transaction = new Transaction(date, transactionTime, description, vendor, amount);
        transactions.add(transaction);
        FileIO.writeToCSV(transaction);
    }


    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public static void makePayment(Scanner scanner) {
        String date = today.format(monthDayYear);
        String transactionTime = today.format(time);
        System.out.print("Enter the description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter the amount: ");
        double amount = (scanner.nextDouble() * -1);
        scanner.nextLine();
        Transaction transaction = new Transaction(date, transactionTime, description, vendor, amount);
        transactions.add(transaction);
    }

    public static void getAllTransactions() {
        for (Transaction transaction : transactions) {
            printTransaction(transaction);
        }
    }

    public static void displayPayments() {
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                printTransaction(transaction);
            }
        }
    }

    public static void displayDeposits() {
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                printTransaction(transaction);
            }
        }
    }

    public static void ledgerMenu(Scanner scanner) {
        System.out.print("""
                A) Display All Transactions
                D) Display Deposits
                P) Display Payments
                R) Reports
                H) Home
                """);
        String userChoice = scanner.nextLine().toUpperCase();
        switch (userChoice) {
            case "A":
                getAllTransactions();
                break;
            case "D":
                displayDeposits();
                break;
            case "P":
                displayPayments();
                break;
            case "R":
                reportsMenu(scanner);
                break;
            case "H":
                break;
            default:
                System.out.println("Invalid choice");

        }
    }

    public static void printTransaction(Transaction transaction) {
        System.out.println(transaction.getDate() + " | " + transaction.getTime() +  " | " +
                transaction.getDescription() + " | " + transaction.getVendor() + " | " + transaction.getAmount());
    }
    public static void reportsMenu(Scanner scanner) {
        //
    }
}
