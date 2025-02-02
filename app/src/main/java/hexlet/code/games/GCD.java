package hexlet.code.games;

import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.setGameDataRightAnswer;
import static hexlet.code.Engine.setGameDataQuestion;
import static hexlet.code.Engine.initialize;
import static hexlet.code.Utils.generateNumber;

public class GCD {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 1000;
    private static final String GAME_START_MESSAGE = "What is the result of the expression?";

    public static void startGame() {
        generateGameData();
        initialize(GAME_START_MESSAGE);
    }

    public static void generateGameData() {
        System.out.println("Find the greatest common divisor of given numbers.");

        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            int firstNumber = generateNumber(MIN_NUMBER, MAX_NUMBER);
            int secondNumber = generateNumber(MIN_NUMBER, MAX_NUMBER);

            if (getGcd(firstNumber, secondNumber) == 1) {
                i--;
                continue;
            }

            String questionData = String.format("%d %d", firstNumber, secondNumber);
            String rightAnswerData = Integer.toString(getGcd(firstNumber, secondNumber));

            setGameDataQuestion(questionData, i);
            setGameDataRightAnswer(rightAnswerData, i);
        }
    }

    private static int getGcd(int firstNumber, int secondNumber) {
        int max = Math.max(firstNumber, secondNumber);
        int min = Math.min(firstNumber, secondNumber);
        int gcd = secondNumber;
        int divRemainder = max % min;

        while (divRemainder != 0) {
            max = min;
            min = divRemainder;
            gcd = min;
            divRemainder = max % min;
        }

        return gcd;
    }
}
