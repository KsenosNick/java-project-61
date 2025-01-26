package hexlet.code;

import static hexlet.code.App.scanner;

public class Engine {
    private static String userName;
    public static final int ITERATIONS_COUNT = 3;

    public static void getByName() {
        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");
        scanner.nextLine();
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public static void askQuestion(int question) {
        System.out.println("Question: " + question);
    }

    public static void askQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static String getUserAnswer() {
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    public static boolean checkAnswer(String userAnswer, String rightAnswer, int iteration) {
        return userAnswer.equalsIgnoreCase(rightAnswer);
    }

    public static void sayRightAnswerMessage() {
        System.out.println("Correct!");
    }

    public static void sayCongratsMessage() {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void sayWrongAnswerMessage(String userAnswer, String rightAnswer) {
        System.out.printf("""
                    '%s' is wrong answer ;(. Correct answer was '%s'.
                    Let's try again, %s!
                    """, userAnswer, rightAnswer, userName);
    }
}
