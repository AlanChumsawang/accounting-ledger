import java.util.Scanner;

public class MainMenu {
    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Prompts.getLogo());
        System.out.print(Prompts.getMainMenu());
        String userChoice = scanner.next().toUpperCase();
        boolean done = false;
        while (!done) {
            switch (userChoice) {
                case "D":
                    //addDeposit();
                    break;
                case "P":
                    //makePayment();
                    break;
                case "L":
                    //ledger();
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
