package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void testValues() {
        Direction[] directions = Direction.values();
        assertEquals(4, directions.length);
        assertEquals(Direction.UP, directions[0]);
        assertEquals(Direction.RIGHT, directions[1]);
        assertEquals(Direction.DOWN, directions[2]);
        assertEquals(Direction.LEFT, directions[3]);
    }

    @Test
    public void testValueOf() {
        assertEquals(Direction.UP, Direction.valueOf("UP"));
        assertEquals(Direction.RIGHT, Direction.valueOf("RIGHT"));
        assertEquals(Direction.DOWN, Direction.valueOf("DOWN"));
        assertEquals(Direction.LEFT, Direction.valueOf("LEFT"));
    }

}


