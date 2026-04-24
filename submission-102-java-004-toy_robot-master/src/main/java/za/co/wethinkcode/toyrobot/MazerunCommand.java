package za.co.wethinkcode.toyrobot;


public class MazerunCommand extends Command {


    public MazerunCommand(String argument) {
        super("mazerun", argument);
    }

    @Override
    public boolean execute(Robot target) {
        String arg = getArgument().trim();
        if (arg.equals("")) {
            arg = "top";
        }
        if (arg.equals("top")){
           new ForwardCommand("100").execute(target);
           new ForwardCommand("100").execute(target);
        }

        target.setStatus(String.format("I am at the %s edge. (Cost: %d steps)", arg.toLowerCase(), 2));
        return true;

    }
    
}



