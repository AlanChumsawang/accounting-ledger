package com.pluralsight.accountingledger;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionManager {
    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private static final LocalDateTime today = LocalDateTime.now();
    private static final DateTimeFormatter monthDayYear = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm");
    private static final String date = today.format(monthDayYear);
    private static int month = Integer.parseInt(date.split("-")[1]);
    private static int year = Integer.parseInt(date.split("-")[0]);



    public static int getMonth() {
        return month;
    }

    public static int getYear() {
        return year;
    }

    public static String getDate() {
        return date;
    }

    public static void addDeposit(Scanner scanner) {
        String transactionTime = today.format(time);
        System.out.print("Enter the description: ");
        String description = scanner.nextLine().trim();
        System.out.print("Enter the vendor: ");
        String vendor = scanner.nextLine().trim();
        System.out.print("Enter the amount: ");
        try {
            double amount = (scanner.nextDouble());
            scanner.nextLine();
            Transaction transaction = new Transaction(date, transactionTime, description, vendor, amount);
            transactions.add(0, transaction);
            FileIO.writeToCSV(transaction);
        }
        catch (Exception e) {
            System.out.println("Invalid input please enter a valid number (X.XX)");
        }
    }


    public static void addTransaction(Transaction transaction) {
        transactions.add(0, transaction);
    }

    public static void makePayment(Scanner scanner) {
        String date = today.format(monthDayYear);
        String transactionTime = today.format(time);
        System.out.print("Enter the description: ");
        String description = scanner.nextLine().trim();
        System.out.print("Enter the vendor: ");
        String vendor = scanner.nextLine().trim();
        System.out.print("Enter the amount: ");
        try {
            double amount = (scanner.nextDouble() * -1);
            scanner.nextLine();
            Transaction transaction = new Transaction(date, transactionTime, description, vendor, amount);
            FileIO.writeToCSV(transaction);
            transactions.add(0, transaction);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input please enter a valid number (X.XX)");
        }
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

    public static void printTransaction(Transaction transaction) {
        System.out.println(transaction.getDate() + " | " + transaction.getTime() +  " | " +
                transaction.getDescription() + " | " + transaction.getVendor() + " | " + transaction.getAmount());
    }

    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
