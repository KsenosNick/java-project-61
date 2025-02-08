package hexlet.code.games;

import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.initialize;
import static hexlet.code.RandomUtils.generateNumber;


public class Calculator {
    private static final String GAME_START_MESSAGE = "What is the result of the expression?";
    private static final String[][] GAME_DATA = new String[2][GAME_ROUNDS_COUNT];

    public static void startGame() {
        generateGameData();
        initialize(GAME_START_MESSAGE, GAME_DATA);
    }

    public static void generateGameData() {
        String[] operations = {"+", "-", "*"};

        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            int firstNumber = generateNumber();
            int secondNumber = generateNumber();
            int operationIndex = generateNumber(operations.length);
            String operation = operations[operationIndex];

            String questionData = String.format("%d %s %d", firstNumber, operation, secondNumber);
            String rightAnswerData = Integer.toString(calculate(firstNumber, operation, secondNumber));

            GAME_DATA[0][i] = questionData;
            GAME_DATA[1][i] = rightAnswerData;
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
