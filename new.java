import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Random random = new Random();

        int lower=1;
        int upper=100;
        int maxAttempts=10;
        int roundsWon=0;
        int totalRounds=0;

        System.out.println("HELLO, and WELCOME to the NUmber Guessing Game.");
        System.out.println("Here are some instructions related to the game");
        System.out.println("You have to guess the number between " +lower+ " and " +upper+".");
        System.out.println("You have "+maxAttempts+" attempts.");

        boolean playAgain = true;

        while(playAgain){
            int numberToGuess = random.nextInt(upper-lower+1) + lower;
            int attempts = 0;
            boolean correctAnswer = false;
            totalRounds++;

            while(attempts < maxAttempts){
                System.out.println("Attempts left "+(maxAttempts - attempts)+"/"+maxAttempts);

                int guess;

                try{
                    guess = Integer.parseInt(s.nextLine());
                    attempts++;
                }
                catch(NumberFormatException e){
                    System.out.println("CAUTION!! Invalid number, please enter a valid number.");
                    continue;
                }



                if(guess == numberToGuess){
                    System.out.println("CONGRATULATIONS!! You guessed it Correct.");
                    correctAnswer=true;
                    roundsWon++;
                    break;
                }
                else if(guess < numberToGuess){
                    System.out.println("Too low!");
                }
                else{
                    System.out.println("Too high!");
                }
            }


            if(!correctAnswer){
                System.out.println("SORRY!! Out of attempts. The number was:" + numberToGuess);
            }

            System.out.println("\n Do you want to play again?(Yes/No)");
            String response = s.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n GAME OVER!!");
        System.out.println("Rounds played: "+ totalRounds);
        System.out.println("Rounds won: "+ roundsWon);
        System.out.println("Thanks for playing!");

        s.close();;
    }
}