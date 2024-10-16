package com.pluralsight.accountingledger;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class FileIO {

    public static void readCSV() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String currentLine;
            while ( (currentLine = bufReader.readLine()) !=null){
                String [] transactionInfo = currentLine.split("[|]");
                String date = transactionInfo[0];
                String time = transactionInfo[1];
                String description = transactionInfo[2];
                String vendor = transactionInfo[3];
                double amount = Double.parseDouble(transactionInfo[4]);
                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                TransactionManager.addTransaction(transaction);
            }

        }
        catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static void writeToCSV(Transaction transaction) {
        // Write to CSV
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            bufWriter.write(
                    transaction.getDate() + "|" + transaction.getTime() + "|" +
                            transaction.getDescription() + "|" + transaction.getVendor() + "|" +
                            transaction.getAmount() + "\n");
            bufWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
