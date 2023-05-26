import java.util.Random;
import java.util.Scanner;

public class SimpleStartupGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int numberOfGuesses = 0;

        // Setup Startup
        int randomPosition = rand.nextInt(4);
        int[] startupLocation = {randomPosition, randomPosition + 1, randomPosition + 2};

        SimpleStartup startup = new SimpleStartup();
        startup.setLocationsCells(startupLocation);

        // Running
        boolean gameOver = false;

        while (gameOver == false) {
            System.out.print("enter a number: ");
            int guess = scan.nextInt();    
            String result = startup.checkYouself(guess);

            numberOfGuesses++;

            System.out.println(result);

            if (result == "kill") {
                gameOver = true;
            }
        }

        //print result
        System.out.println("You took " + numberOfGuesses + " guesses");

        scan.close();
    }
}