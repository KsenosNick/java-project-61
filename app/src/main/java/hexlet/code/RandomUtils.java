package hexlet.code;

import java.util.Random;

import static hexlet.code.AppConfig.MIN_NUMBER;
import static hexlet.code.AppConfig.MAX_NUMBER;
import static hexlet.code.AppConfig.MIN_ADDED_NUMBER;
import static hexlet.code.AppConfig.MAX_ADDED_NUMBER;
import static hexlet.code.AppConfig.PROGRESSION_LENGTH;

public final class RandomUtils {
    private static final Random NUMBER_GENERATOR = new Random();

    public static int generateNumber() {
        return NUMBER_GENERATOR.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    public static int generateNumber(int number) {
        return NUMBER_GENERATOR.nextInt(number);
    }

    public static int generateNumber(int minNumber, int maxNumber) {
        return NUMBER_GENERATOR.nextInt(maxNumber - minNumber + 1) + minNumber;
    }

    public static String generateProgression() {
        StringBuilder progression = new StringBuilder();
        int initialNumber = generateNumber();
        int addedNumber = generateNumber(MIN_ADDED_NUMBER, MAX_ADDED_NUMBER);

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            progression.append(initialNumber).append(" ");
            initialNumber += addedNumber;
        }

        return progression.toString().trim();
    }
}
