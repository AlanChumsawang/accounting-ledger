package com.pluralsight.accountingledger;

import java.util.ArrayList;
import java.util.Scanner;

public class Reports {
    static ArrayList<Transaction> transactions = TransactionManager.getTransactions();
    /*************************************************************
    The following methods run queries on the ArrayList transactions
    The conditionals are calling the getters from the Transaction class
     and comparing to the desired search
     **************************************************************/

    public static void monthToDate() {
        for (Transaction transaction : transactions) {
            if (transaction.getDate().split("-")[1].equals(TransactionManager.getDate().split("-")[1]) && transaction.getDate().split("-")[0].equals(TransactionManager.getDate().split("-")[0])) {
                TransactionManager.printTransaction(transaction);
            }
        }
    }

    public static void previousMonth() {
        for (Transaction transaction : transactions) {
            if ((TransactionManager.getMonth() - 1) == Integer.parseInt(transaction.getDate().split("-")[1]) && transaction.getDate().split("-")[0].equals(TransactionManager.getDate().split("-")[0])) {
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
/*************************************************************
 This method allows users to filter transactions based on start date, end date,
 description, vendor, and amount. The method searches through each transaction
 and checks if it matches all the provided criteria only if the transactions meets all conditions.
 *************************************************************/
    public static void customSearch(String startDate, String endDate, String description, String vendor, double amount) {
        for (Transaction transaction : transactions) {
            boolean match = true;
            //.compareTo returns a 0 if is equal to, a number > 0 if greater than and a number < 0 if less than.
            if (!startDate.isEmpty() && transaction.getDate().compareTo(startDate) < 0) {
                match = false;
            }
            if (!endDate.isEmpty() && transaction.getDate().compareTo(endDate) > 0) {
                match = false;
            }
            if (!description.isEmpty() && !transaction.getDescription().equalsIgnoreCase(description)) {
                match = false;
            }
            if (!vendor.isEmpty() && !transaction.getVendor().equalsIgnoreCase(vendor)) {
                match = false;
            }
            if (amount != 0.0 && amount != transaction.getAmount()) {
                match = false;
            }
            // if any of the disqualifying conditional statements are true then match is false
            // If not then we will print the matching transaction
            if (match) {
                TransactionManager.printTransaction(transaction);
            }
        }
    }
}
