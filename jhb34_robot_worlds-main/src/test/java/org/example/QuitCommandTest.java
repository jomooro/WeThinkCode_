package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class QuitCommandTest {
    @Test
    void Quit() {
        Robot robot = new Robot("Test");
        QuitCommand quitCommand = new QuitCommand();
        boolean result = quitCommand.execute(robot);
        assertFalse(result);
        assertEquals("Shutting down...", robot.getStatus());
    }
}