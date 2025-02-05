package hexlet.code.games;

import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.initialize;
import static hexlet.code.Utils.generateNumber;

public class Progression {

    private static final int MAX_NUMBER = 100;
    private static final int MIN_ADDED_NUMBER = 1;
    private static final int MAX_ADDED_NUMBER = 10;
    private static final String GAME_START_MESSAGE = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
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

    private static String generateProgression() {
        StringBuilder progression = new StringBuilder();
        int initialNumber = generateNumber(MAX_NUMBER);
        int addedNumber = generateNumber(MIN_ADDED_NUMBER, MAX_ADDED_NUMBER);

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            progression.append(initialNumber).append(" ");
            initialNumber += addedNumber;
        }

        return progression.toString().trim();
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
