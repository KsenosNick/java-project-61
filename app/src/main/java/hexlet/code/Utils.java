package hexlet.code;

import java.util.Random;

public class Utils {
    private static Random numberGenerator = new Random();

    public static int generateNumber(int maxNumber) {
        return numberGenerator.nextInt(maxNumber);
    }

    public static int generateNumber(int minNumber, int maxNumber) {
        return numberGenerator.nextInt(maxNumber - minNumber + 1) + minNumber;
    }
}
