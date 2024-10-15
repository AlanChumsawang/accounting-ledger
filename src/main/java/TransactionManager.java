import java.util.ArrayList;
import java.util.Scanner;

public class TransactionManager {
    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();


    public static void addDeposit(Scanner scanner) {
        System.out.print("Enter the date: ");
        String date = scanner.nextLine();
        System.out.print("Enter the time: ");
        String time = scanner.nextLine();
        System.out.print("Enter the description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter the amount: ");
        double amount = (scanner.nextDouble());
        Transaction transaction = new Transaction(date, time, description, vendor, amount);
        transactions.add(transaction);
    }

    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public static void makePayment(Scanner scanner) {
        System.out.print("Enter the date: ");
        String date = scanner.nextLine();
        System.out.print("Enter the time: ");
        String time = scanner.nextLine();
        System.out.print("Enter the description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        Transaction transaction = new Transaction(date, time, description, vendor, amount);
        transactions.add(transaction);
    }

    public static void getAllTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDate() + " " + transaction.getTime() + " " + transaction.getDescription() + " " + transaction.getVendor() + " " + transaction.getAmount());
        }
    }
}
