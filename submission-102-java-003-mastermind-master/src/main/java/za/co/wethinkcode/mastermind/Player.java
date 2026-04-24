package za.co.wethinkcode.mastermind;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner inputScanner;
    private int turns = 12;


    public Player(){
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream){
        this.inputScanner = new Scanner(inputStream);
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is entered, or until the user enters `exit` or `quit`.
     *
     * @return the value entered by the user
     */


    public String getGuess() {
        String guess;
        boolean validGuess = false;
        do {
            System.out.println("Input 4 digit code:");
            guess = inputScanner.nextLine();
            if (guess.length() != 4) {
                System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
            } else if (!guess.matches("[1-8]+")) {
                System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
            } else {
                validGuess = true;
            }
        } while (!validGuess);
        return guess;
    }

    public void loseTurns(){
        if (hasTurns())
            this.turns--;
    }

    public int getTurns(){
        return this.turns;
    }

    public boolean hasTurns() {
        return getTurns() > 0;
    }
}
