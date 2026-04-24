package za.co.wethinkcode.toyrobot.world;

import java.util.ArrayList;
import java.util.List;

import za.co.wethinkcode.toyrobot.maze.Maze;
import za.co.wethinkcode.toyrobot.Position;

public class AbstractWorld implements IWorld {
    private Maze maze;
    private Position position;
    private Direction currentDirection;
    private List<Obstacle> obstacles;
    private final Position TOP_LEFT = new Position(-200, 200);
    private final Position BOTTOM_RIGHT = new Position(200, -200);
    public static final Position CENTRE = new Position(0, 0);

    public AbstractWorld(Maze maze) {
        this.maze = maze;
        reset();
    }

    @Override
    public UpdateResponse updatePosition(int nrSteps) {
        Position newPosition = getNextPosition(nrSteps);
        if (isNewPositionAllowed(newPosition)) {
            position = newPosition;
            return UpdateResponse.SUCCESS;
        } else {
            return UpdateResponse.FAILED_OUTSIDE_WORLD;
        }
    }

    private Position getNextPosition(int nrSteps) {
        int x = position.getX();
        int y = position.getY();
        switch (currentDirection) {
            case UP:
                y += nrSteps;
                break;
            case RIGHT:
                x += nrSteps;
                break;
            case DOWN:
                y -= nrSteps;
                break;
            case LEFT:
                x -= nrSteps;
                break;
        }
        return new Position(x, y);
    }


    @Override
    public void updateDirection(boolean turnRight) {
        switch (this.currentDirection) {
            case UP:
                this.currentDirection = turnRight ? Direction.RIGHT : Direction.LEFT;
                break;
            case RIGHT:
                this.currentDirection = turnRight ? Direction.DOWN : Direction.UP;
                break;
            case DOWN:
                this.currentDirection = turnRight ? Direction.LEFT : Direction.RIGHT;
                break;
            case LEFT:
                this.currentDirection = turnRight ? Direction.UP : Direction.DOWN;
                break;
            default:
                break;
        }
    }
    

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    @Override
    public boolean isNewPositionAllowed(Position newPosition) {
        return (newPosition.isIn(TOP_LEFT, BOTTOM_RIGHT));
    }

    @Override
    public boolean isAtEdge() {
        return maze.isPositionAtEdge(position);
    }

    @Override
    public void reset() {
        position = CENTRE;
        currentDirection = Direction.UP;
        obstacles = new ArrayList<>();
    }

    @Override
    public List<Obstacle> getObstacles() {
        return obstacles;
    }


    @Override
    public void showObstacles() {
        for (Obstacle obstacle : obstacles) {
            System.out.println("Obstacle at (" + obstacle.getBottomLeftX() + ", " + obstacle.getBottomLeftY() + ") with size " + obstacle.getSize());
        }
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }
}
