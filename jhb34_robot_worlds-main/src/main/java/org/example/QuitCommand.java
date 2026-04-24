package org.example;

public class QuitCommand extends Command {
    public QuitCommand() {
        super("quit");
    }

    @Override
    public boolean execute(Robot target) {
        target.setStatus("Shutting down...");
        return false;
    }
}
