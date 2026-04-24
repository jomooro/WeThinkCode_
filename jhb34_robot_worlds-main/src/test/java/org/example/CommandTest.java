package org.example;


import org.junit.jupiter.api.Test;
//import za.co.wethinkcode.toyrobot.world.IWorld;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void getQuitName() {
        Command test = new QuitCommand();
        assertEquals("quit", test.getName());
    }

    @Test
    void executeShutdown() throws IOException {
        Robot robot = new Robot("CrashTestDummy");
        Command shutdown = Command.create("quit");
        assertFalse(shutdown.execute(robot));
        assertEquals("Shutting down...", robot.getStatus());
    }

    @Test
    void getForwardName() {
        ForwardCommand test = new ForwardCommand("100");
        assertEquals("forward", test.getName());
        assertEquals("100", test.getArgument());
    }

//    @Test
//    void executeForward() {
//        Robot robot = new Robot("CrashTestDummy", new String[]{"RandomMaze"});
//        Command forward100 = Command.create("forward 10");
//        assertTrue(forward100.execute(robot));
//        Position expectedPosition = new Position(IWorld.CENTRE.getX(), IWorld.CENTRE.getY() + 10);
//        assertEquals(expectedPosition, robot.getPosition());
//        assertEquals("Moved forward by 10 steps.", robot.getStatus());
//    }


    @Test
    void createCommand() throws IOException {
        Command forward = Command.create("forward 10");                                                 //<1>
        assertEquals("forward", forward.getName());
        assertEquals("10", forward.getArgument());

        Command shutdown = Command.create("quit");                                                  //<2>
        assertEquals("quit", shutdown.getName());

    }

    @Test
    void createInvalidCommand() {
        try {
            Command forward = Command.create("say hello");                                              //<4>
            fail("Should have thrown an exception");                                                    //<5>
        } catch (IllegalArgumentException | IOException e) {
            assertEquals("Unsupported command: say hello", e.getMessage());                             //<6>
        }
    }
}
