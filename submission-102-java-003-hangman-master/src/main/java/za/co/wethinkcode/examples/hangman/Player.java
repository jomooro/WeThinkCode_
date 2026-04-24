package za.co.wethinkcode.examples.hangman;

import java.util.Scanner;
import java.io.InputStream;


public class Player {
    private final Scanner scanner;  //reads input from the user.
    private boolean quit = false;   //determines if the user wants to quit the game.
    private int numberGuesses = 5;  //keeps track of the number of guesses left.


    //uses the InputStream as an argument and creates a new scanner object with it.
    public Player(InputStream in) { 
        this.scanner = new Scanner(in); 
    }

    //creates a new player object.
    public Player() {
        this(System.in); 
    }

    //returns the number of guesses left.
    public int getChances() {
        return numberGuesses ;  
    }

    //decreases the number of guesses the user has left.
    public void lostChance() {
        if (numberGuesses  > 0) 
            numberGuesses --;
    }
    
    //returns true if the user has no more guesses left and if not it returns false.
    public boolean hasNoChances() {
        return numberGuesses  == 0; 
    }
    
    //uses short_words.txt as a default value.
    public String getWordsFile() {
        String filename = scanner.nextLine();
        return filename.isBlank() ? "short_words.txt" : filename;
    }
    
    //allows the user to either quit or exit the game.
    public String getGuess() {
        String text =  scanner.nextLine();
        quit = text.equalsIgnoreCase("quit") || text.equalsIgnoreCase("exit");
        return text;
    }
    
    //returns true if the user decides to quit and if not it returns false.
    public boolean wantsToQuit() {
        return quit;
    }
}