package org.example;

import org.json.JSONObject;

import java.awt.*;

import static java.lang.System.out;

public class TurnRight extends Command {
    private JSONObject response = new JSONObject();
    public TurnRight() {
        super("right");
    }

    @Override
    public boolean execute(Robot target) {
        target.turnRight(true);
        target.equals("Turned right.");

        JSONObject data = new JSONObject();
        JSONObject state = new JSONObject();

        data.put("message", "Done");
        data.put("turn","Right");

        state.put("position", "[" + target.getPosition().getX() + "," + target.getPosition().getY() + "]");
        state.put("direction", target.world.getCurrentDirection());
        state.put("status", "NORMAL");

        response.put("data", data);
        response.put("state", state);
        out.println("Response: "+response.toString());
        return true;
    }
}




