package hexlet.code;

import static hexlet.code.Utils.userInput;

public class Engine {
    public static final int GAME_ROUNDS_COUNT = 3;
    private static String userName;
    private static final String[][] GAME_DATA = new String[2][GAME_ROUNDS_COUNT];

    public static void initialize(String gameStartMessage) {
        getByName();
        System.out.println(gameStartMessage);
        processGameData();
    }

    public static void getByName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        userName = userInput();

        System.out.println("Hello, " + userName + "!");
    }

    public static void processGameData() {
        for (int i = 0; i < GAME_ROUNDS_COUNT; i++) {
            System.out.println("Question: " + GAME_DATA[0][i]);
            System.out.print("Your answer: ");
            String userAnswer = userInput();
            String rightAnswer = GAME_DATA[1][i];

            if (isRight(userAnswer, rightAnswer)) {
                System.out.println("Correct!");
                if (i == GAME_ROUNDS_COUNT - 1) {
                    System.out.println("Congratulations, " + userName + "!");
                }
            } else {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """, userAnswer, rightAnswer, userName);
                return;
            }
        }
    }

    private static boolean isRight(String userAnswer, String rightAnswer) {
        return userAnswer.equalsIgnoreCase(rightAnswer);
    }

    public static void setGameDataQuestion(String questionData, int round) {
        GAME_DATA[0][round] = questionData;
    }

    public static void setGameDataRightAnswer(String answerData, int round) {
        GAME_DATA[1][round] = answerData;
    }
}
