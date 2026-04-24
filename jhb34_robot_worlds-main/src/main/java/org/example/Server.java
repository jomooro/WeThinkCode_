package org.example;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import org.example.world.RobotWorld;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;



public class Server implements Runnable {

    public static final int PORT = 8080;
    private BufferedReader in;
    private PrintStream out;
    private String clientMachine;
    private RobotWorld world;
    Robot robot1;



    public Server(Socket socket, RobotWorld world) throws IOException {
        clientMachine = socket.getInetAddress().getHostName();
        System.out.println("Connection from " + clientMachine);

        out = new PrintStream(socket.getOutputStream());
        out.println("Welcome to Robot World!!!");
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.world = world;
    }


    public void Server(BufferedReader in, PrintStream out, String clientMachine) {
        this.in = in;
        this.out = out;
        this.clientMachine = clientMachine;
    }

    public void run() {
        try {
            String messageFromClient;
            while ((messageFromClient = in.readLine()) != null) {
                try {
                    JSONObject request = new JSONObject(messageFromClient);
                    JSONObject response = new JSONObject();
                    String robotJSONString = request.getString("robot");
                    String command = request.getString("command");
                    JSONArray arguments = request.getJSONArray("arguments");


                    String robot = Robot.fromJSON(robotJSONString);

                    String result = executeCommand(robot, command, arguments);
                    JSONObject data = new JSONObject();
                    JSONObject state = new JSONObject();

                    data.put("key1", "value1");
                    data.put("key2", "value2");

                    JSONArray position = new JSONArray();
                    position.put(0, 10);
                    position.put(1, 20);
                    state.put("position", arguments);
                    state.put("direction", "north");
                    state.put("shields", 3);
                    state.put("shots", 10);
                    state.put("status", "operational");

                    response.put("result", result);
                    response.put("data", data);
                    response.put("state", state);
                    response.put("command", command);


                    out.println(response.toString());
                } catch (JSONException e) {
                    JSONObject errorResponse = new JSONObject();
                    errorResponse.put("result", "ERROR");
                    JSONObject data = new JSONObject();

                    if (e.getMessage().equals("JSONObject[\"arguments\"] not found.")) {
                        data.put("message", "Could not parse arguments");
                    } else if (e.getMessage().equals("JSONObject[\"command\"] not found.")) {
                        data.put("message", "Unsupported command");
                    } else {
                        data.put("message", "Invalid JSON format");
                    }

                    errorResponse.put("data", data);
                    out.println(errorResponse.toString());
                }
            }
        } catch (IOException ex) {
            System.out.println("Shutting down single client server");
        } finally {
            closeQuietly();
        }
    }

    private void closeQuietly() {
        try {
            in.close();
            out.close();
        } catch(IOException ex) {}
    }

    private String executeCommand(String robot, String command, JSONArray arguments) {
        return "Command executed successfully.";
    }
}
