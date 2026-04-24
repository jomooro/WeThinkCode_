package za.co.wethinkcode.examples.hangman;
import java.util.Random;

public class Answer {
    private String value;

    //takes a String parameter and sets the value.
    public Answer(String value) {
        setValue(value);
    }

    //returns the value.
    public String getValue() {
        return value;
    }

    //uses the String parameter and converts it in lowercase.
    public void setValue(String value) {
        this.value = value.toLowerCase();
    }

    //returns the value.
    public String toString() {
        return getValue();
    }

    //checks if the object is equals to the Answer class.
    public boolean equals(Object obj) {                                                                 
        Answer otherAnswer = (Answer) obj;                                                              
        return this.value.equalsIgnoreCase(otherAnswer.toString());
    }

    // checks a StringBuilder object and loops through each character in the answer.
    // checks if the last letter matches the current character.
    public Answer getHint(Answer lastAnswer, char guessedLetter) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.value.length(); i++) {
            if (guessedLetter == value.charAt(i)) {
                result.append(guessedLetter);
            } else {
                result.append(lastAnswer.getValue().charAt(i));
            }
        }
        return new Answer(result.toString());
    }

    //checks if the given character is in the string or not.
    public boolean hasLetter(char letter) {
        return this.getValue().indexOf(letter) >= 0;
    }
    
    //generates a random index between 0 and the length of the value.
    //replaces the rest of the letters with underscores.
    //gets the character of that index through the charAt().
    //returns a new Answer that was chosen randomly in the letters.
    public Answer generateRandomHint() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.value.length());

        String noLetters = "_".repeat(value.length());
        return getHint(new Answer(noLetters), value.charAt(randomIndex));
    }

    //checks if the letter is a good guess.
    public boolean isGoodGuess(Answer wordToGuess, char letter) {
        return wordToGuess.hasLetter(letter) && !hasLetter(letter);
    }
}
