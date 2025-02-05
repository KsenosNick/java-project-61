package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random NUMBER_GENERATOR = new Random();

    public static int generateNumber(int maxNumber) {
        return NUMBER_GENERATOR.nextInt(maxNumber);
    }

    public static int generateNumber(int minNumber, int maxNumber) {
        return NUMBER_GENERATOR.nextInt(maxNumber - minNumber + 1) + minNumber;
    }
}
