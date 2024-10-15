import java.util.Scanner;

public class LedgerApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Prompts.getLogo());
        System.out.print(Prompts.getMainMenu());
        String userChoice = scanner.next().toUpperCase();
        boolean done = false;
        while (!done) {
            switch (userChoice) {
                case "D":
                    TransactionManager.addDeposit(scanner);
                    break;
                case "P":
                    TransactionManager.makePayment(scanner);
                    break;
                case "L":
                    TransactionManager.getAllTransactions();
                    break;
                case "X":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
