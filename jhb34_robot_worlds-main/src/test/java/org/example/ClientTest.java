package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ClientTest {
    private InputStream inputStream;

    @Test
    void ClientInput() {
        String input = "Test Input";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }


}
