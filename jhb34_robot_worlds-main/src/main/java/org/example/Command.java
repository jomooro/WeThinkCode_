package org.example;

import org.example.Robot;
import org.json.JSONObject;

import java.io.IOException;

public abstract class Command {
    private final String name;
    private final String argument;

    public Command(String name) {
        this(name, "");
    }
    JSONObject request;
    public Command(String name, String argument) {
        this.name = name.trim().toLowerCase();
        this.argument = argument.trim();
    }

    public String getName() {
        return name;
    }

    public String getArgument() {
        return argument;
    }

    public abstract boolean execute(Robot target);

    public JSONObject getRequest() {
        return request;
    }
    public static Command create(String instruction) throws IOException {
        String[] args = instruction.toLowerCase().trim().split(" ");
        switch (args[0]) {
            case "quit":
                return new QuitCommand();
            case "help":
                return new HelpCommand();
            case "forward":
                return new ForwardCommand(args[1]);
            case "back":
                return new BackCommand(args[1]);
            case "right":
                return new TurnRight();
            case "left":
                return new TurnLeft();
            case "state":
                return new stateCommand();
            case "look":
                return new LookCommand();
            case "launch":
                return new LaunchCommand(args[1]);
            case "reload":
                return new ReloadCommand();
            case "repair":
                return new RepairCommand();
            case "fire":
                return new FireCommand();
            default:
                throw new IllegalArgumentException("Unsupported command: " + instruction);
        }
    }
}
