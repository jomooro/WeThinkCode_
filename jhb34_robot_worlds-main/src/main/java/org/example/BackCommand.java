package org.example;

import org.example.world.IWorld;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class BackCommand extends Command{
    private JSONObject response = new JSONObject();
    @Override
    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());

        if(target.getWorld().updatePosition(-nrSteps).equals(IWorld.UpdateResponse.SUCCESS)){
            target.setStatus("Moved back by "+nrSteps+" steps.");
        } else if (target.getWorld().updatePosition(-nrSteps).equals(IWorld.UpdateResponse.FAILED_OUTSIDE_WORLD)){
            target.setStatus("Sorry, I cannot go outside my safe zone.");
        }
        else{
            target.setStatus("Sorry, there is an obstacle in the way.");
        }
        JSONObject data = new JSONObject();
        JSONObject state = new JSONObject();

        data.put("message", "");
        data.put("movement","Back");
        data.put("steps",nrSteps);

        state.put("position", "[" + target.getPosition().getX() + "," + target.getPosition().getY() + "]");
        state.put("direction", target.world.getCurrentDirection());
        state.put("shields", target.getShield());
        state.put("shots",  target.getShots());
        state.put("status", "NORMAL");

        response.put("data", data);
        response.put("state", state);
        out.println("Response: "+response.toString());


        return true;
    }

    public BackCommand(String argument) {
        super("back", argument);
    }
}






