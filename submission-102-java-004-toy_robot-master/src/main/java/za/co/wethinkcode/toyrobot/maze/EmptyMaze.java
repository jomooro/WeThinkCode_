package za.co.wethinkcode.toyrobot.maze;

import java.util.ArrayList;
import java.util.List;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;

public class EmptyMaze implements Maze {

    @Override
    public List<Obstacle> getObstacles() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'blocksPath'");
    }

    @Override
    public boolean isPositionAtEdge(Position a) {
        // TODO Auto-generated method stub
       if(a.getX()==-200 || a.getX()==200 || a.getY()==-200 || a.getY()==200){
        return true;
       }
       return false;
    }
    
}
