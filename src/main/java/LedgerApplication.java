import java.util.Scanner;

public class LedgerApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            System.out.print(Prompts.getLogo());
            System.out.print(Prompts.getMainMenu());
            String userChoice = scanner.nextLine().toUpperCase();
            switch (userChoice) {
                case "D":
                    TransactionManager.addDeposit(scanner);
                    break;
                case "P":
                    TransactionManager.makePayment(scanner);
                    break;
                case "L":
                    TransactionManager.ledgerMenu(scanner);
                    break;
                case "X":
                    done = true;
                    break;
                default:
                    System.out.println("\nInvalid choice\n");
            }
        }
    }
}
