package hexlet.code.games;

import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.initialize;
import static hexlet.code.Utils.generateNumber;

public class Prime {
    private static final int MAX_NUMBER = 1000;
    private static final String GAME_START_MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_CHECK_NUMBER = 3;
    private static final String[][] GAME_DATA = new String[2][GAME_ROUNDS_COUNT];

    public static void startGame() {
        generateGameData();
        initialize(GAME_START_MESSAGE, GAME_DATA);
    }

    public static void generateGameData() {

        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            int number = generateNumber(MAX_NUMBER);

            String questionData = Integer.toString(number);
            String rightAnswerData = isPrime(number) ? "yes" : "no";

            GAME_DATA[0][i] = questionData;
            GAME_DATA[1][i] = rightAnswerData;
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        for (int i = MIN_CHECK_NUMBER; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
