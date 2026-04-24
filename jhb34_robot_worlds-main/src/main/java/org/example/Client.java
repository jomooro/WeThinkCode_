package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import org.example.world.IWorld;
import org.example.world.RobotWorld;

import org.json.JSONArray;
import org.json.JSONObject;


public class Client {
    private static Scanner scanner;
    private static Socket socket;
    static PrintWriter writer;
    static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        socket = new Socket("localhost", 8080);
        OutputStream output = socket.getOutputStream();
        InputStream input = socket.getInputStream();
        writer = new PrintWriter(output, true);
        reader = new BufferedReader(new InputStreamReader(input));
        Robot robot;

        String name = getInput("What do you want to name your robot?");
        robot = new Robot(name);
        IWorld world = new RobotWorld();
        robot.setWorld(world);
        String greetingFromServer =reader.readLine();
        System.out.println(greetingFromServer);


        Command command = null;
        boolean shouldContinue = true;
        List<String> supportedCommands = Arrays.asList("right", "left", "back", "forward");

        do {
            String instruction = getInput(robot.getName() + "> What must I do next?").strip().toLowerCase();
            try {

                command = Command.create(instruction);
                shouldContinue = robot.handleCommand(command);
                robot.listOfCommands(command);
                JSONObject serverResponse =sendRequestToServer(robot, command, args);


            } catch (IllegalArgumentException | IOException e) {
                robot.setStatus("Sorry, I did not understand '" + instruction + "'.");

            }

            if (supportedCommands.contains(instruction)) {
                robot.listOfCommands(command);
            }

            System.out.println(robot);
        } while (shouldContinue);

//        socket.close();
    }

    static String getInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();

        while (input.isBlank()) {
            System.out.println(prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    private static JSONObject sendRequestToServer(Robot robot, Command command, String[] args) throws IOException {

            JSONObject request = new JSONObject();
            request.put("robot", robot.toString());
            request.put("command", command.getName());
            request.put("arguments", new JSONArray(args));

            writer.println(request.toString());
            String messageFromServer = reader.readLine();
            //System.out.println("Response from server: " + messageFromServer);
            return new JSONObject(messageFromServer);
    }




}
