package hexlet.code.games;

import static hexlet.code.AppConfig.PROGRESSION_LENGTH;
import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.initialize;
import static hexlet.code.RandomUtils.generateProgression;
import static hexlet.code.RandomUtils.generateNumber;

public class Progression {
    private static final String GAME_START_MESSAGE = "What number is missing in the progression?";
    private static final String[][] GAME_DATA = new String[2][GAME_ROUNDS_COUNT];

    public static void startGame() {
        generateGameData();
        initialize(GAME_START_MESSAGE, GAME_DATA);
    }

    public static void generateGameData() {
        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            String progression = generateProgression();
            int index = generateNumber(PROGRESSION_LENGTH);

            String questionData = hideElement(progression, index);
            String rightAnswerData = getHidedElement(progression, index);

            GAME_DATA[0][i] = questionData;
            GAME_DATA[1][i] = rightAnswerData;
        }
    }

    private static String hideElement(String progression, int index) {
        String[] progressionArray = progression.split(" ");
        progressionArray[index] = "..";

        return String.join(" ", progressionArray);
    }

    private static String getHidedElement(String progression, int index) {
        String[] progressionArray = progression.split(" ");
        return progressionArray[index];
    }
}
