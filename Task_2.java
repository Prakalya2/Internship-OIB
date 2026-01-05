
import java.util.Random;
import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int numberToGuess = random.nextInt(max - min + 1) + min;

        int attempts = 0;
        int maxAttempts = 7;
        boolean isGuessed = false;

        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have " + maxAttempts + " attempts ");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                isGuessed = true;
                break;
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
        }

        if (!isGuessed) {
            System.out.println(" Game Over!");
            System.out.println("The correct number was: " + numberToGuess);
        }

        sc.close();
    }
}

