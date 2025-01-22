package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit
                """);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println("Your choice: " + choice);

        switch (choice) {
            case 1:
                Cli.getByName();
                break;
            case 2:
                Evenness.checkForEvenness();
                break;
            case 0:
                System.out.println("You're out of brain games");
                break;
            default:
                System.out.println("Enter the game number from the suggested list");

        }

        scanner.close();
    }
}
