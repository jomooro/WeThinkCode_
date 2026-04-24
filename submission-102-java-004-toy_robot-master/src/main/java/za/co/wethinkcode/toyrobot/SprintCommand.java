package za.co.wethinkcode.toyrobot;

public class SprintCommand extends Command {
    
    public SprintCommand(String argument) {
        super("sprint", argument);
    }

    @Override
    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());
        for (int i = nrSteps; i>0; i--) {
            if (target.updatePosition(i)) {
                target.setStatus("Moved forward by "+i+" steps.");
                if (i > 1) {
                    System.out.println(target);
                }
            }
        }
    return true;
    }
}



    
