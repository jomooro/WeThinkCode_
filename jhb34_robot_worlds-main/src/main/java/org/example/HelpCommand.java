package org.example;

public class HelpCommand extends Command {

    /**
     * Initializes a HelpCommand object with the command name "help".
     */
    public HelpCommand() {
        super("help");
    }

    /**
     * Executes the HelpCommand on the specified Robot object.
     * Sets the Robot's status to a message describing the available commands, and returns true.
     *
     * @param target the Robot object to execute the command on
     * @return true, indicating that the command was executed successfully
     */
    @Override
    public boolean execute(Robot target) {
        target.setStatus("I can understand these commands:\n" +
                "QUIT - Shut down the robot\n" +
                "HELP - Provide information about commands\n" +
                "FORWARD [steps] - Move the robot forward by the specified number of steps, e.g., 'FORWARD 10'\n" +
                "BACKWARD [steps] - Move the robot backward by the specified number of steps, e.g., 'BACKWARD 5'\n" +
                "RIGHT  - Turn the robot right, e.g., 'RIGHT'\n" +
                "LEFT  - Turn the robot left , e.g., 'LEFT'\n" +
                "STATE - Get the current state of the robot\n" +
                "LOOK - Perform a visual scan and provide information about the surrounding environment\n" +
                "LAUNCH - Launch a projectile or perform a specific action\n" +
                "RELOAD - Reload ammunition or perform a specific action\n" +
                "REPAIR - Repair the robot or perform a specific action\n" +
                "FIRE - Fire a weapon or perform a specific action\n");
        return true;
    }
}

