package com.pluralsight.accountingledger;

import java.util.ArrayList;
import java.util.Scanner;

public class Reports {
    static ArrayList<Transaction> transactions = TransactionManager.getTransactions();

    public static void monthToDate() {
        for (Transaction transaction : transactions) {
            if (transaction.getDate().split("-")[1].equals(TransactionManager.getDate().split("-")[1])) {
                TransactionManager.printTransaction(transaction);
            }
        }
    }

    public static void previousMonth() {
        for (Transaction transaction : transactions) {
            if ((TransactionManager.getMonth() - 1) == Integer.parseInt(transaction.getDate().split("-")[1])) {
                TransactionManager.printTransaction(transaction);
            }
        }
    }

    public static void yearToDate() {
        for (Transaction transaction : transactions) {
            if (transaction.getDate().split("-")[0].equals(TransactionManager.getDate().split("-")[0])) {
                TransactionManager.printTransaction(transaction);
            }
        }
    }

    public static void previousYear() {
        for (Transaction transaction : transactions) {
            if ((TransactionManager.getYear() - 1) == Integer.parseInt(transaction.getDate().split("-")[0])) {
                TransactionManager.printTransaction(transaction);
            }
        }
    }

    public static void searchByVendor(String vendor) {
        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendor)) {
                TransactionManager.printTransaction(transaction);
            }
        }
    }

    public static void customSearch(String startDate, String endDate, String description, String vendor, double amount) {
        for (Transaction transaction : transactions) {
            boolean match = true;
            if (!startDate.isEmpty() && transaction.getDate().compareTo(startDate) < 0) {
                match = false;
            }
            if (!endDate.isEmpty() && transaction.getDate().compareTo(endDate) > 0) {
                match = false;
            }
            if (!description.isEmpty() && !transaction.getDescription().contains(description)) {
                match = false;
            }
            if (amount != 0.0 && amount != transaction.getAmount()) {
                match = false;
            }

            if (match) {
                TransactionManager.printTransaction(transaction);
            }
        }
    }
}
