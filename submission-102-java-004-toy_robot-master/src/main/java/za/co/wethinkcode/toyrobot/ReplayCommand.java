package za.co.wethinkcode.toyrobot;
import java.util.Collections;
import java.util.List;

public class ReplayCommand extends Command {

    public ReplayCommand(String instruction) {
        super("replay",instruction);
    }

    @Override
    public boolean execute(Robot target) {

        if(getArgument().replace("reversed","").equals("")){
        List<Command> commandHistory = target.myHistory();
            if(getArgument().contains("reversed")){
                Collections.reverse(commandHistory);
            }
        for (Command command : commandHistory) {
            command.execute(target);
            System.out.println(target);
        }
        target.setStatus("replayed " + commandHistory.size() + " commands.");
    }

    else if(getArgument().contains("-")) {
        String[] range_args = getArgument().replace("reversed","").trim().split("-");
        int n =Integer.parseInt(range_args[0]);
        int m =Integer.parseInt(range_args[1]);
        List<Command> commandHistory = target.myHistory();
        commandHistory = commandHistory.subList(commandHistory.size()-n,commandHistory.size()-n+m);

        if(getArgument().contains("reversed")){
            Collections.reverse(commandHistory);
        }
        for (Command command : commandHistory) {
            command.execute(target);
            System.out.println(target);
        }

        target.setStatus("replayed " + m + " commands.");
    }

    else{
        int m =Integer.parseInt(getArgument().replace("reversed", "").trim());
        List<Command> commandHistory = target.myHistory();
        commandHistory = commandHistory.subList(commandHistory.size()-m,commandHistory.size());

        if(getArgument().contains("reversed")){
            Collections.reverse(commandHistory);
        }
        for (Command command : commandHistory) {
            command.execute(target);
            System.out.println(target);
        }

        target.setStatus("replayed " + m + " commands.");
    }

    
        return true;
    }
}

 