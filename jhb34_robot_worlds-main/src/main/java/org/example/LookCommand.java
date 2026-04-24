package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import org.example.world.Obstacle;
import java.util.List;

import static java.lang.System.out;


public class LookCommand extends Command {
    private JSONObject response = new JSONObject();
    public LookCommand() {
        super("look");
    }

    @Override
    public boolean execute(Robot target) {

        List<Obstacle> obj = target.getWorld().lookObstacles(target);

        System.out.println("There are some obstacles:");
        for (Obstacle obs : obj) {
            System.out.println("At position: "+obs.getBottomLeftX() + ", " + obs.getBottomLeftY());
        }

        JSONObject data = new JSONObject();
        JSONObject state = new JSONObject();

        data.put("position", "[" + target.getPosition().getX() + " to " + target.getPosition().getY() + "]");
        data.put("visibility", true);
        data.put("distance",5);
        data.put("shields", target.getShield());

        state.put("position", "[ " + target.getPosition().getX() + "," + target.getPosition().getY() + " ]");
        state.put("direction", target.world.getCurrentDirection());
        state.put("shields", target.getShield());
        state.put("shots", target.getShots());
        state.put("status", "NORMAL");

        response.put("data", data);
        response.put("state", state);

        out.println("Response: "+response.toString(4));
        return true;
    }

}
