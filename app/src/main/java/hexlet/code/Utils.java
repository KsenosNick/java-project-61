package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final Random NUMBER_GENERATOR = new Random();

    public static int generateNumber(int maxNumber) {
        return NUMBER_GENERATOR.nextInt(maxNumber);
    }

    public static int generateNumber(int minNumber, int maxNumber) {
        return NUMBER_GENERATOR.nextInt(maxNumber - minNumber + 1) + minNumber;
    }

    public static String userInput() {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }
}
