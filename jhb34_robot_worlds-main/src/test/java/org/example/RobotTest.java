package org.example;


import org.example.world.IWorld;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void initialPosition() {
        Robot robot = new Robot("CrashTestDummy");
//        assertEquals(IWorld.CENTRE, robot.getPosition());
//        assertEquals(Direction.UP, robot.getCurrentDirection());
    }

//    @Test
//    void dump() {
//        Robot robot = new Robot("CrashTestDummy");
//        assertEquals("[0,0] CrashTestDummy> Ready", robot.toString());
//    }

    @Test
    void quit() {
        Robot robot = new Robot("CrashTestDummy");
        QuitCommand command = new QuitCommand();
        assertFalse(robot.handleCommand(command));
    }

//    @Test
//    void forward() {
//        Robot robot = new Robot("CrashTestDummy");
//        ForwardCommand command = new ForwardCommand("10");
////        assertTrue(robot.handleCommand(command));
//        Position expectedPosition = new Position(IWorld.CENTRE.getX(), IWorld.CENTRE.getY() + 10);
//        assertEquals(expectedPosition, robot.getPosition());
//        assertEquals("Moved forward by 10 steps.", robot.getStatus());
//    }

//    @Test
//    void forwardforward() {
//        Robot robot = new Robot("CrashTestDummy");
////        assertTrue(robot.handleCommand(new ForwardCommand("10")));
//        assertTrue(robot.handleCommand(new ForwardCommand("5")));
//        assertEquals("Moved forward by 5 steps.", robot.getStatus());
//    }

//    @Test
//    void tooFarForward() {
//        Robot robot = new Robot("CrashTestDummy");
////        assertTrue(robot.handleCommand(new ForwardCommand("1000")));
//        assertEquals(IWorld.CENTRE, robot.getPosition());
//        assertEquals("Sorry, I cannot go outside my safe zone.", robot.getStatus());
//    }


}