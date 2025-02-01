package hexlet.code.games;

import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.setGameDataRightAnswer;
import static hexlet.code.Engine.setGameDataQuestion;
import static hexlet.code.Engine.initialize;
import static hexlet.code.Utils.generateNumber;


public class Calculator {
    private static final int MAX_NUMBER = 100;
    private static final String GAME_START_MESSAGE = "What is the result of the expression?";

    public static void startGame() {
        generateGameData();
        initialize(GAME_START_MESSAGE);
    }

    public static void generateGameData() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        String[] operations = {"+", "-", "*"};

        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            int firstNumber = generateNumber(MAX_NUMBER);
            int secondNumber = generateNumber(MAX_NUMBER);
            int operationIndex = generateNumber(operations.length);
            String operation = operations[operationIndex];

            String questionData = String.format("%d %s %d", firstNumber, operation, secondNumber);
            String rightAnswerData = Integer.toString(calculate(firstNumber, operation, secondNumber));

            setGameDataQuestion(questionData, i);
            setGameDataRightAnswer(rightAnswerData, i);
        }
    }

    public static int calculate(int firstNumber, String operation, int secondNumber) {
        return switch (operation) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> 0;
        };
    }
}
