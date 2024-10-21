package com.pluralsight.accountingledger;

public class Prompts {

    /*************************************************************
     The following variables contain the prompts for the Menus class,
     each method returns a String that can be printed in the Menus
     class using the appropriate getter.
     *************************************************************/
    private static final String mainMenu = """
             __  __                          \s
            |  \\/  |_   _                    \s
            | |\\/| | | | |                   \s
            | |  | | |_| |                   \s
            |_|  |_|\\__, |                   \s
             _      |___/  _                 \s
            | |    ___  __| | __ _  ___ _ __ \s
            | |   / _ \\/ _` |/ _` |/ _ | '__|\s
            | |__|  __| (_| | (_| |  __| |   \s
            |_____\\___|\\__,_|\\__, |\\___|_|   \s
                             |___/           \s
            
            D) Add Deposit
            P) Make Payment(Debit)
            L) Ledger
            X) Exit
            Choose an option: """;

    private static final String ledgerMenu = """
         
            A) Display All Transactions
            D) Display Deposits
            P) Display Payments
            R) Reports
            H) Home
            
            Choose an option: """;

    private static final String reportsMenu = """
         
            1) Month to Date
            2) Previous Month
            3) Year to Date
            4) Previous Year
            5) Search by Vendor
            6) Custom Search
            0) Back
            
            Choose an option: """;

// getters
    public static String getMainMenu() {
        return mainMenu;
    }

    public static String getLedgerMenu() {
        return ledgerMenu;
    }

    public static String getReportsMenu() {
        return reportsMenu;
    }
}

