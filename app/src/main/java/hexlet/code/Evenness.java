package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Evenness {
    public static void checkForEvenness() {
        System.out.println("Welcome to the Brain Games!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");

        Random numberGenerator = new Random();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < 3; i++) {

            int number = numberGenerator.nextInt(1000);

            System.out.println("Question: " + number);

            String rightAnswer = number % 2 == 0 ? "yes" : "no";

            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(rightAnswer)) {
                System.out.println("Correct!");
                if (i == 2) {
                    System.out.println("Congratulations, " + userName + "!");
                }
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, rightAnswer);
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }

        scanner.close();
    }
}
