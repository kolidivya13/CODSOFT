import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 7; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRoundsWon = 0;
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game! ");
        System.out.printf("I am thinking of a number between %d and %d.%n", MIN_RANGE, MAX_RANGE);

        while (playAgain) {
            int targetNumber = random.nextInt((MAX_RANGE - MIN_RANGE) + 1) + MIN_RANGE;
            int attemptsTaken = 0;
            boolean roundWon = false;

            System.out.printf("%n--- New Round Started! You have %d attempts. ---%n", MAX_ATTEMPTS);

            
            while (attemptsTaken < MAX_ATTEMPTS) {
                // 2. Prompt the user to enter their guess
                System.out.printf("Attempt %d/%d. Enter your guess: ", (attemptsTaken + 1), MAX_ATTEMPTS);
                
                // Validate user input type
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    scanner.next(); // Clear buffer
                    continue;
                }
                
                int userGuess = scanner.nextInt();
                attemptsTaken++;

          
                if (userGuess == targetNumber) {
                    System.out.printf("Correct! You guessed the number in %d attempts.%n", attemptsTaken);
                    roundWon = true;
                    totalRoundsWon++;
                  
                    int roundScore = (MAX_ATTEMPTS - attemptsTaken + 1) * 10;
                    totalScore += roundScore;
                    System.out.printf("Round Score: +%d points!%n", roundScore);
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    System.out.println("Too low! Try a higher number.");
                }
            }

            if (!roundWon) {
                System.out.printf("%nOut of attempts! The correct number was: %d%n", targetNumber);
            }

            // 6. Add the option for multiple rounds
            System.out.print("%nWould you like to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.startsWith("y");
        }

        // 7. Display the user's final score summary
        System.out.println("%n======= FINAL GAME OVER STATS =======");
        System.out.printf("Total Rounds Won : %d%n", totalRoundsWon);
        System.out.printf("Final Total Score: %d points%n", totalScore);
        System.out.println("=====================================");
        System.out.println("Thank you for playing! Goodbye.");
        
        scanner.close();
    }
}
