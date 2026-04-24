package org.example;

import org.json.JSONObject;

import static java.lang.System.out;

public class FireCommand extends Command {
    private static final int RELOAD_TIME = 5; // Reload time in seconds
    //private boolean hit; // Variable to store whether the shot hit or missed
    //private String robotName; // Variable to store the name of the robot

    public FireCommand() {
        super("Fire");
        //this.hit = hit;
        //this.robotName = robotName;
    }

    @Override
    public boolean execute(Robot target) {
        int shots = target.getNumShots();

        // Check if the robot has any active attacks available
        if (shots == 0) {
            System.out.println("No Active Attacks available!");
            return false;
        }

        int targetDistance = calculateDistance(target);
        int maxDistance = calculateMaxShots(targetDistance);
        int distance = Math.min(maxDistance, targetDistance);

        // Calculate the coordinates of the target

        // Decrease the number of shots the robot has left
        target.setNumshots(shots - 1);
        if (shots > 0) {
            System.out.println("Firing!");
            shots--;
            if (shots == 0) {
                target.setReloadTime();
                System.out.println("Out of ammo. Reloading...");
                target.setReloading(true);
            }
        } else {
            System.out.println("Out of ammo. Cannot fire!");
            return false;
        }

        // Prepare the response
        boolean hit =  true;
        JSONObject data = new JSONObject();
        data.put("message", hit ? "Hit" : "Missed");
        data.put("distance", distance);
        data.put("robot", target.getName());

        JSONObject state = new JSONObject();
        state.put("shots", target.getNumShots());

        JSONObject response = new JSONObject();
        response.put("result", "OK");
        response.put("data", data);
        response.put("state", state);


        out.println("Response: "+response.toString(4));

        return true;
    }

    private int calculateMaxShots(int distance) {
        if (distance >= 5) {
            return 1;
        } else if (distance >= 4) {
            return 2;
        } else if (distance >= 3) {
            return 3;
        } else if (distance >= 2) {
            return 4;
        } else if (distance >= 1) {
            return 5;
        } else {
            return 0;
        }
    }

    private int calculateDistance(Robot target) {
        Position robotPos = target.getPosition();


        int distance = Math.abs(30 - robotPos.getX()) + Math.abs(25 - robotPos.getY());
        return distance;
    }
}