package za.co.wethinkcode.mastermind;

public class Mastermind {
    private final String code;
    private final Player player;
    

    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }

    public Mastermind(){
        this(new CodeGenerator(), new Player());
    }

    public void runGame(){
        //TODO: implement the main run loop logic

        System.out.println("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.");

        while (player.getTurns() > 0) {
          String guess = player.getGuess();
          player.loseTurns();
          int[] correctDigitsAndPosition = evaluateGuess(guess);
          countmessage(correctDigitsAndPosition);
          if (winGame(correctDigitsAndPosition[0])) {
            break;
          }
          
      }
        System.out.println("The code was: " + code);
    }
  
    private int[] evaluateGuess(String guess) {
        int numCorrectPlace = 0;
        int numCorrectNotPlace = 0;
        for (int i = 0; i < 4; i++) {
          if (guess.charAt(i) == code.charAt(i)) {
            numCorrectPlace++;
          } else if (code.indexOf(guess.charAt(i)) != -1) {
            numCorrectNotPlace++;
          }
        }
        return new int[]{numCorrectPlace, numCorrectNotPlace};
    }

    public static void countmessage(int[] correctDigitsAndPosition){

      System.out.println("Number of correct digits in correct place: " + correctDigitsAndPosition[0]);
      System.out.println("Number of correct digits not in correct place: " + correctDigitsAndPosition[1]);
    }
     
    public boolean winGame(int correctDigitsAndPosition) {

        if (correctDigitsAndPosition == 4) {
            System.out.println("Congratulations! You are a codebreaker!");
            return true;
        } else if(this.player.hasTurns()) {
            System.out.println("Turns left: " + (this.player.getTurns()));
            return false;
        }
        else{
          System.out.println("No more turns left.");
          return false;
        }
    }


    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();
    }
}

