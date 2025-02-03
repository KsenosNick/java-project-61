package hexlet.code.games;

import static hexlet.code.Engine.GAME_ROUNDS_COUNT;
import static hexlet.code.Engine.setGameDataRightAnswer;
import static hexlet.code.Engine.setGameDataQuestion;
import static hexlet.code.Engine.initialize;
import static hexlet.code.Utils.generateNumber;

public class Prime {
    private static final int MAX_NUMBER = 1000;
    private static final String GAME_START_MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_CHECK_NUMBER = 3;

    public static void startGame() {
        generateGameData();
        initialize(GAME_START_MESSAGE);
    }

    public static void generateGameData() {

        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            int number = generateNumber(MAX_NUMBER);

            String questionData = Integer.toString(number);
            String rightAnswerData = isPrime(number) ? "yes" : "no";

            setGameDataQuestion(questionData, i);
            setGameDataRightAnswer(rightAnswerData, i);
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
