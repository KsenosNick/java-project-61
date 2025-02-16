package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Evenness;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import static hexlet.code.Engine.closeScanner;
import static hexlet.code.Engine.userInput;

public class App {

    public static void main(String[] args) {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                """);

        String choice = userInput();
        System.out.println("Your choice: " + choice);

        switch (choice) {
            case "1":
                Engine.getByName();
                break;
            case "2":
                Evenness.startGame();
                break;
            case "3":
                Calculator.startGame();
                break;
            case "4":
                GCD.startGame();
                break;
            case "5":
                Progression.startGame();
                break;
            case "6":
                Prime.startGame();
                break;
            case "0":
                System.out.println("You're out of brain games");
                break;
            default:
                System.out.println("Enter the game number from the suggested list");
        }

        closeScanner();
    }
}
