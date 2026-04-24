package org.example.world;

import org.example.Position;
import org.example.Robot;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class World implements IWorld {

    final Position TOP_LEFT = new Position(-100,200);
    final Position BOTTOM_RIGHT = new Position(100,-200);
    public static final Position CENTRE = new Position(0,0);
    public Position position;
    public Direction currentDirection;
    private List<Robot> players = new ArrayList<>();


    public World(){
        this.position = CENTRE;
        this.currentDirection = Direction.UP;
    }

    public abstract UpdateResponse updatePosition(int nrSteps);
    public abstract void updateDirection(boolean turnRight) ;
    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    @Override
    public boolean isNewPositionAllowed(Position position) {

        if(position.getX() >= 0 && position.getX() < 101 && position.getY() >= 0 && position.getY() < 201){
            return true;
        }
        return false;
    }
    @Override
    public List<SquareObstacle> getObstacles() {
        Random random = new Random();
        int bound = random.nextInt(4);

        List<SquareObstacle> myObs = new ArrayList<>();
        for(int i = 0; i <bound; i++){
            int min_x = -200;
            int max_x = 200;
            int min_y = -200;
            int max_y = 200;
            SquareObstacle nums=new SquareObstacle((random.nextInt(max_x+200)+min_x),random.nextInt(max_y+200)+min_y);
            myObs.add(nums);

        }

        return myObs;
    }

    public List<Obstacle> lookObstacles(Robot robot){
        Random random = new Random();
        int bound = random.nextInt(4);

        List<Obstacle> myObs = new ArrayList<>();
        for(int i = 0; i <bound; i++){
            int min_x = -200;
            int max_x = 200;
            int min_y = -200;
            int max_y = 200;
            SquareObstacle nums=new SquareObstacle((random.nextInt(max_x+200)+min_x),random.nextInt(max_y+200)+min_y);
            myObs.add(nums);

        }

        return myObs;
    }

    public List<Robot> lookRobots(Robot robot){
        Position neWPosition;
        List<Robot> lRobots = new ArrayList<>();

        for (Robot robot2 : getPlayers()) {
            for (int i = 0; i < 5; i++) {
                neWPosition = new Position(robot.getPosition().getX(), robot.getPosition().getY()+(i+1));
                if(robot2.getPosition().equals(neWPosition)){
                    lRobots.add(robot2);
                }
            }
        }


        return lRobots;
    }
    public List<Robot> getPlayers() {
        return players;
    }
    public void join(Robot player){

        if (playerExists(player.getName())){

        }

        players.add(player);
    }
    public boolean playerExists(String name){
        for (Robot in : players) {
            if (in.getName().contains(name)){
                return true;
            }
        }
        return false;
    }

}

