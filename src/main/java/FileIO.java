import java.io.*;

public class FileIO {

    public static void readCSV(String filename) {
        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String currentLine = bufReader.readLine();
            while ( (currentLine = bufReader.readLine()) !=null){
                String [] transactionInfo = currentLine.split("[|]");
                String date = transactionInfo[0];
                String time = transactionInfo[1];
                String description = transactionInfo[2];
                String vendor = transactionInfo[3];
                String amount = transactionInfo[4];
                // Transaction transaction = new Transaction(date, time, description, vendor, amount);
                // TransactionManager.addTransaction(transaction);
            }

        }
        catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static void writeToCSV(String filename) {
        // Write to CSV
        try {
            FileWriter fileWriter = new FileWriter("transactions.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
