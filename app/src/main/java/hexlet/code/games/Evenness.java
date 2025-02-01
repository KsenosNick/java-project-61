package hexlet.code.games;

import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.setGameDataRightAnswer;
import static hexlet.code.Engine.setGameDataQuestion;
import static hexlet.code.Engine.initialize;
import static hexlet.code.Utils.generateNumber;

public class Evenness {
    private static final int MAX_NUMBER = 1000;
    private static final String GAME_START_MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startGame() {
        generateGameData();
        initialize(GAME_START_MESSAGE);
    }

    public static void generateGameData() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            int number = generateNumber(MAX_NUMBER);

            String questionData = Integer.toString(number);
            String rightAnswerData = isEven(number) ? "yes" : "no";

            setGameDataQuestion(questionData, i);
            setGameDataRightAnswer(rightAnswerData, i);
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
