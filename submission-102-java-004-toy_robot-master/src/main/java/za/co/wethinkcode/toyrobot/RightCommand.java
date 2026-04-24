package za.co.wethinkcode.toyrobot;

public class RightCommand extends Command {
    @Override
    public boolean execute(Robot target) {
        switch (target.getCurrentDirection()) {
            case NORTH:
                target.direction(Direction.EAST);
                break;
            case EAST:
            target.direction(Direction.SOUTH);
                break;
            case SOUTH:
            target.direction(Direction.WEST);
                break;
            case WEST:
            target.direction(Direction.NORTH);
                break;
        }
        target.setStatus("Turned right.");
        return true;
    }

    public RightCommand() {
        super("right");
    }
}