package org.example.world;

import org.example.Position;


public class SquareObstacle implements Obstacle {
    private int x;
    private int y;

    public SquareObstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getBottomLeftX() {
        return this.x;
    }

    @Override
    public int getBottomLeftY() {
        return this.y;
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public boolean blocksPosition(Position position) {
        return position.getX() >= x && position.getX() < x + 5 &&
                position.getY() >= y && position.getY() < y + 5;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {

        if (a.getX()== b.getX()) {
            for (int i = a.getY(); i < b.getY(); i++) {
                if (blocksPosition(new Position(a.getX(), i))) {
                    return true;
                }
            }
        }else if (a.getY() == b.getY()){
            for (int i = a.getX(); i < b.getX(); i++){
                if (blocksPosition(new Position(i,a.getY()))){
                    return true;
                }
            }
        }
        return false;
    }

}



