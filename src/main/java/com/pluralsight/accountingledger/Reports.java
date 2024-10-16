package com.pluralsight.accountingledger;

import java.util.ArrayList;
import java.util.Scanner;

public class Reports {
    static ArrayList<Transaction> transactions = TransactionManager.getTransactions();

    public static void monthToDate() {
        for (Transaction transaction : transactions) {
            if (transaction.getDate().split("-")[0].equals(TransactionManager.getDate().split("-")[0])) {
                TransactionManager.printTransaction(transaction);
            }
        }
    }

    public static void previousMonth() {
        for (Transaction transaction : transactions) {
            if ((TransactionManager.getMonth() - 1) == Integer.parseInt(transaction.getDate().split("-")[0])) {
                TransactionManager.printTransaction(transaction);
            }
        }
    }

    public static void yearToDate() {
        for (Transaction transaction : transactions) {
            if (transaction.getDate().split("-")[2].equals(TransactionManager.getDate().split("-")[2])) {
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

    public static void customSearch(String startDate, String endDate, String Description, String vendor, Double Amount) {






    }
}
