package za.co.wethinkcode.toyrobot;

public class LeftCommand extends Command {
    @Override
    public boolean execute(Robot target) {
        switch (target.getCurrentDirection()) {
            case NORTH:
                target.direction(Direction.WEST);
                break;
            case SOUTH:
            target.direction(Direction.EAST);
                break;
            case EAST:
            target.direction(Direction.NORTH);
                break;
            case WEST:
            target.direction(Direction.SOUTH);
                break;
        }
        target.setStatus("Turned left.");
        return true;
    }

    public LeftCommand() {
        super("left");
    }
}

