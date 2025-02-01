package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Evenness;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                0 - Exit
                """);

        int choice = scanner.nextInt();
        System.out.println("Your choice: " + choice);

        switch (choice) {
            case 1:
                Engine.getByName();
                break;
            case 2:
                Evenness.startGame();
                break;
            case 3:
                Calculator.startGame();
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
