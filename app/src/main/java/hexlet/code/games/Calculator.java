package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.App.numberGenerator;

public class Calculator {
    private static final int MAX_NUMBER = 100;

    public static void calculate() {
        String[] operations = {"+", "-", "*"};

        Engine.getByName();

        System.out.println("What is the result of the expression?");

        for (int i = 0; i < Engine.ITERATIONS_COUNT; i++) {

            int operationIndex = numberGenerator.nextInt(operations.length);
            int firstNumber = numberGenerator.nextInt(MAX_NUMBER);
            int secondNumber = numberGenerator.nextInt(MAX_NUMBER);
            String operation = operations[operationIndex];
            String question = String.format("Question: %d %s %d", firstNumber, operation, secondNumber);

            Engine.askQuestion(question);

            String rightAnswer = switch (operation) {
                case "+" -> Integer.toString(firstNumber + secondNumber);
                case "-" -> Integer.toString(firstNumber - secondNumber);
                case "*" -> Integer.toString(firstNumber * secondNumber);
                default -> "";
            };

            String userAnswer = Engine.getUserAnswer();
            boolean isRight = Engine.checkAnswer(userAnswer, rightAnswer, i);

            if (isRight) {
                Engine.sayRightAnswerMessage();
                if (i == 2) {
                    Engine.sayCongratsMessage();
                }
            } else {
                Engine.sayWrongAnswerMessage(userAnswer, rightAnswer);
                break;
            }
        }
    }
}
