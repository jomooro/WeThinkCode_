package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;

public class SquareObstacle implements Obstacle{
    private final int bottomLeftX;
    private final int bottomLeftY;
    
     public SquareObstacle(int bottomLeftX, int bottomLeftY) {
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
    }

    @Override
    public int getBottomLeftX() {
        return bottomLeftX;
    }

    @Override
    public int getBottomLeftY() {
       return bottomLeftY;
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public boolean blocksPosition(Position position) {
        return position.getX() >= bottomLeftX && position.getX() < bottomLeftX + 5
                && position.getY() >= bottomLeftY && position.getY() < bottomLeftY + 5;
        
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        if (a.getX() == b.getX()) {
            if (a.getY() < bottomLeftY && b.getY() < bottomLeftY) {
                return false;
            } else if (a.getY() >= bottomLeftY + 5 && b.getY() >= bottomLeftY + 5) {
                return false;
            } else {
                return a.getX() >= bottomLeftX && a.getX() < bottomLeftX + 5;
            }
        } else if (a.getY() == b.getY()) {
            if (a.getX() < bottomLeftX && b.getX() < bottomLeftX) {
                return false;
            } else if (a.getX() >= bottomLeftX + 5 && b.getX() >= bottomLeftX + 5) {
                return false;
            } else {
                return a.getY() >= bottomLeftY && a.getY() < bottomLeftY + 5;
            }
        } else {
            return true;
        }
    }
}
