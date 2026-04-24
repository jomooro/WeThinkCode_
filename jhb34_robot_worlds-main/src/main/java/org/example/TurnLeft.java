package org.example;

import org.example.world.IWorld;
import org.json.JSONObject;

import java.awt.*;

import static java.lang.System.out;

public class TurnLeft extends Command {
    private JSONObject response = new JSONObject();
    public TurnLeft() {
        super("left");
    }


    @Override
    public boolean execute(Robot target) {

        target.turnLeft(false);
        target.setStatus("Turned left.");

        JSONObject data = new JSONObject();
        JSONObject state = new JSONObject();

        data.put("message", "Done");
        data.put("turn","Left");

        state.put("position", "[" + target.getPosition().getX() + "," + target.getPosition().getY() + "]");
        state.put("direction", target.world.getCurrentDirection());
        state.put("status", "NORMAL");

        response.put("data", data);
        response.put("state", state);
        out.println("Response: "+response.toString());

        return true;
    }
}
