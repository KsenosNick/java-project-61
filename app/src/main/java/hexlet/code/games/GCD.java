package hexlet.code.games;

import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.initialize;
import static hexlet.code.RandomUtils.generateNumber;

public class GCD {
    private static final String GAME_START_MESSAGE = "What is the result of the expression?";
    private static final String[][] GAME_DATA = new String[2][GAME_ROUNDS_COUNT];

    public static void startGame() {
        generateGameData();
        initialize(GAME_START_MESSAGE, GAME_DATA);
    }

    public static void generateGameData() {
        System.out.println("Find the greatest common divisor of given numbers.");

        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            int firstNumber = generateNumber();
            int secondNumber = generateNumber();

            if (getGcd(firstNumber, secondNumber) == 1) {
                i--;
                continue;
            }

            String questionData = String.format("%d %d", firstNumber, secondNumber);
            String rightAnswerData = Integer.toString(getGcd(firstNumber, secondNumber));

            GAME_DATA[0][i] = questionData;
            GAME_DATA[1][i] = rightAnswerData;
        }
    }

    private static int getGcd(int firstNumber, int secondNumber) {
        int max = Math.max(firstNumber, secondNumber);
        int min = Math.min(firstNumber, secondNumber);
        int divRemainder = max % min;

        if (divRemainder == 0) {
            return min;
        }
        return getGcd(min, divRemainder);
    }
}
