package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.App.numberGenerator;

public class Evenness {
    private static final int MAX_NUMBER = 1000;

    public static void checkForEvenness() {
        Engine.getByName();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < Engine.ITERATIONS_COUNT; i++) {
            int number = numberGenerator.nextInt(MAX_NUMBER);

            Engine.askQuestion(number);

            String rightAnswer = number % 2 == 0 ? "yes" : "no";
            String userAnswer = Engine.getUserAnswer();
            boolean isRight = Engine.checkAnswer(userAnswer, rightAnswer, i);

            if (isRight) {
                Engine.sayRightAnswerMessage();
                if (i == 2) {
                    Engine.sayCongratsMessage();
                }
            } else {
                Engine.sayWrongAnswerMessage(userAnswer, rightAnswer);
                break;
            }
        }
    }
}
