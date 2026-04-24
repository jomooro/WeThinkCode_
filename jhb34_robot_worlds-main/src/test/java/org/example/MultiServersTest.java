package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiServersTest {

    @Test
    public void MultiServer() {
        int expectedPort = Server.PORT;
        boolean isServerRunning = false;

        try {
            ServerSocket serverSocket = new ServerSocket(expectedPort);
            serverSocket.close();
            isServerRunning = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        //assertTrue(isServerRunning, "Server should be running");
    }
}
