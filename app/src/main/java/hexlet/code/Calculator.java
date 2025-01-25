package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Calculator {
    public static void calculate() {
        System.out.println("Welcome to the Brain Games!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");

        Random numberGenerator = new Random();

        String[] operations = {"+", "-", "*"};

        System.out.println("What is the result of the expression?");

        for (int i = 0; i < 3; i++) {

            int operationIndex = numberGenerator.nextInt(operations.length);
            int firstNumber = numberGenerator.nextInt(100);
            int secondNumber = numberGenerator.nextInt(100);
            String operation = operations[operationIndex];

            System.out.println(String.format("Question: %d %s %d", firstNumber, operation, secondNumber));

            int rightAnswer = switch (operation) {
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                case "*" -> firstNumber * secondNumber;
                default -> 0;
            };

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == rightAnswer) {
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
