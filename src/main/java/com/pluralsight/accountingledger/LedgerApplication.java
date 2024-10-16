package com.pluralsight.accountingledger;

import java.util.Scanner;

public class LedgerApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        FileIO.readCSV();
        while (!done) {
            done = Menus.mainMenu(scanner);
        }
    }
}
