package org.example.world;


import org.example.Robot;
import org.example.world.SquareObstacle;
import org.example.Position;


import java.util.ArrayList;
import java.util.List;


public class RobotWorld extends World {

    public RobotWorld() {

    }

    List<SquareObstacle> myObs = getObstacles();
    @Override
    public UpdateResponse updatePosition(int nrSteps) {

        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.UP.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }
        if (Direction.DOWN.equals(this.currentDirection)) {
            newY = newY - nrSteps;
        }
        if (Direction.RIGHT.equals(this.currentDirection)) {
            newX = newX + nrSteps;
        }
        if (Direction.LEFT.equals(this.currentDirection)) {
            newX = newX - nrSteps;
        }

        Position newPosition = new Position(newX, newY);

        if (newPosition.isIn(TOP_LEFT, BOTTOM_RIGHT)) {
            for (int i =0; i <myObs.size(); i++){
                SquareObstacle obs = new SquareObstacle(myObs.get(i).getBottomLeftX(),myObs.get(i).getBottomLeftY());
                if (obs.blocksPath(newPosition,this.position)){
                    return UpdateResponse.FAILED_OBSTRUCTED;
                }
            }

            this.position = newPosition;
            return UpdateResponse.SUCCESS;
        }
        return UpdateResponse.FAILED_OUTSIDE_WORLD;

    }
    @Override
    public void updateDirection(boolean turnRight) {
        if(turnRight){

            switch (currentDirection){
                case UP:
                    //turn to that direction
                    currentDirection = Direction.RIGHT;
                    break;
                case RIGHT:
                    currentDirection = Direction.DOWN;
                    break;
                case  DOWN:
                    currentDirection = Direction.LEFT;
                    break;
                case LEFT:
                    currentDirection = Direction.UP;
            }
        } else {
            //we know our robot starts at UP
            switch (currentDirection){
                case UP:
                    currentDirection = Direction.LEFT;
                    break;
                case LEFT:
                    currentDirection = Direction.DOWN;
                    break;
                case DOWN:
                    currentDirection = Direction.RIGHT;
                    break;
                case  RIGHT:
                    currentDirection = Direction.UP;
            }
        }
    }

    @Override
    public boolean isAtEdge() {
        if ((this.position.getX() == 100) || (this.position.getY() == 200) || (this.position.getX() == -100) || (this.position.getY() == -200)) {
            return true;
        }
        return false;
    }

    @Override
    public void reset() {
        this.currentDirection = Direction.UP;
        this.position = new Position(0, 0);
    }


    @Override
    public void showObstacles() {


        if (myObs.size() > 0) {
            System.out.println("There are some obstacles: ");

            for (int i = 0; i < myObs.size(); i++) {
                int x = myObs.get(i).getBottomLeftX() + 4;
                int y = myObs.get(i).getBottomLeftY() + 4;

                System.out.println("- At position " + myObs.get(i).getBottomLeftX() + "," + myObs.get(i).getBottomLeftY() + " (to " + x + "," + y + ")");
            }

        }

    }
}

