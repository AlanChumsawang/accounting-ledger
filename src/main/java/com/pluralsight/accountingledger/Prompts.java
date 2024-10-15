package com.pluralsight.accountingledger;

public class Prompts {
    static String Logo = """
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
            
            
            """;
    static String mainMenu = """
            D) Add Deposit
            P) Make Payment(Debit)
            L) Ledger
            X) Exit
            Choose an option: 
            """;

    public static String getLogo() {
        return Logo;
    }

    public static String getMainMenu() {
        return mainMenu;
    }
}

