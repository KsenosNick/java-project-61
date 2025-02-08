package hexlet.code.games;

import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.initialize;
import static hexlet.code.RandomUtils.generateNumber;

public class Prime {
    private static final String GAME_START_MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final String[][] GAME_DATA = new String[2][GAME_ROUNDS_COUNT];

    public static void startGame() {
        generateGameData();
        initialize(GAME_START_MESSAGE, GAME_DATA);
    }

    public static void generateGameData() {

        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            int number = generateNumber();

            String questionData = Integer.toString(number);
            String rightAnswerData = isPrime(number) ? "yes" : "no";
            GAME_DATA[0][i] = questionData;
            GAME_DATA[1][i] = rightAnswerData;
        }
    }

    private static boolean isPrime(int number) {
        final int minCheckNumber = 3;
        if (number <= 1 || number % 2 == 0) {
            return number == 2;
        }

        for (int i = minCheckNumber; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
