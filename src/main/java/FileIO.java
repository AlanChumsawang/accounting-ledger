import java.io.*;

public class FileIO {

    public static void readCSV(String filename) {
        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
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
