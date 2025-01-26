package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void getByName() {
        System.out.println("Welcome to the Brain Games!");
        Scanner sc = new Scanner(System.in);
        System.out.println("May I have your name? ");
        String userName = sc.nextLine();
        System.out.println("Hello, " + userName + "!");
        sc.close();
    }
}
