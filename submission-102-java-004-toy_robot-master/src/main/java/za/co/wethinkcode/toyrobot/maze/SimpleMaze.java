package za.co.wethinkcode.toyrobot.maze;

import java.util.ArrayList;
import java.util.List;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

public class SimpleMaze implements Maze{

    @Override
    public List<Obstacle> getObstacles() {
        
        List<Obstacle> newList = new ArrayList<>();
        newList.add(new SquareObstacle(1,1));
            return newList;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'blocksPath'");
    }

    @Override
    public boolean isPositionAtEdge(Position a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPositionAtEdge'");
    }
    
}
