package org.example;

import org.example.world.IWorld;
import org.example.world.World;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class stateCommand extends Command{
    private JSONObject response = new JSONObject();
    public stateCommand() {
        super("state");
    }

    @Override
    public boolean execute(Robot target) {

        JSONObject data = new JSONObject();
        JSONObject state = new JSONObject();

        data.put("position", "[" + target.getPosition().getX() + "," + target.getPosition().getY() + "]");
        data.put("visibility", true);
        data.put("distance",5+" steps");
        data.put("shields", target.getShield());

        state.put("position", "[ "+target.getPosition().getX()+","+target.getPosition().getY()+" ]");
        state.put("direction", target.world.getCurrentDirection());
        state.put("shields", target.getShield());
        state.put("shots",  target.getShots());
        state.put("status", "ALIVE");

        response.put("data", data);
        response.put("state", state);

        out.println("Response: "+response.toString(4));

        return true;
    }
}
