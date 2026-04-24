package org.example;

import javax.imageio.IIOException;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Robots {
    public static ArrayList<Robots> robots = new ArrayList<>();

    private String robot;

    public Robots() throws IOException {

        robots.add(this);
        System.out.println("Server: " + robot + "has entered Robot World!!!");
    }


}





