package Survival.main;

import Survival.SurvivalGame;
import java.util.Scanner;

/**
 * The main class is the entry point of the Survival game.
 * @author Behrouz Gavari
 * @version 1.0
 */
public class main
{
    public static void main(final String[] args)
    {
        Scanner             scanner;
        scanner           = new Scanner(System.in);
        SurvivalGame game = new SurvivalGame();

        System.out.println("Welcome to Survival!");
        System.out.println("Answer the questions correctly to survive.");

        while (game.isRunning())
        {
            game.displayNextQuestion();
            String   answer;
            answer = scanner.nextLine();
            game.checkAnswer(answer);
        }

        System.out.println("Game Over!");
        System.out.println("Final Score: " + game.getScore());
    }
}
