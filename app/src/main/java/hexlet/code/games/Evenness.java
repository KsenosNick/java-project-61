package hexlet.code.games;

import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.initialize;
import static hexlet.code.RandomUtils.generateNumber;

public class Evenness {
    private static final String GAME_START_MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String[][] GAME_DATA = new String[2][GAME_ROUNDS_COUNT];

    public static void startGame() {
        generateGameData();
        initialize(GAME_START_MESSAGE, GAME_DATA);
    }

    public static void generateGameData() {

        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            int number = generateNumber();

            String questionData = Integer.toString(number);
            String rightAnswerData = isEven(number) ? "yes" : "no";

            GAME_DATA[0][i] = questionData;
            GAME_DATA[1][i] = rightAnswerData;
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
