package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robot {
    private final Position TOP_LEFT = new Position(-200,200);
    private final Position BOTTOM_RIGHT = new Position(200,-200);

    public static final Position CENTRE = new Position(0,0);

    private List<Command> commandHistory;
    private Position position;
    private Direction currentDirection;
    private String status;
    private String name;


    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = Direction.NORTH;
        this.commandHistory = new ArrayList<Command>();     

    }

    public List<Command> myHistory() {
        return this.commandHistory;
    }
    public String getStatus() {
        return this.status;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public Direction direction(Direction myDirection){
        return currentDirection = myDirection;

    }

    public boolean handleCommand(Command command) {
        if(!command.getName().contains("replay")){
            this.commandHistory.add(command);
        }
        return command.execute(this);
    }

    public boolean updatePosition(int nrSteps){
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.NORTH.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }
        if (Direction.EAST.equals(this.currentDirection)) {
            newX = newX + nrSteps;
        }
        if (Direction.WEST.equals(this.currentDirection)) {
            newX = newX - nrSteps;
        }
        if (Direction.SOUTH.equals(this.currentDirection)) {
            newY = newY - nrSteps;
        }


        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
       return "[" + this.position.getX() + "," + this.position.getY() + "] "
               + this.name + "> " + this.status;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }
    
}