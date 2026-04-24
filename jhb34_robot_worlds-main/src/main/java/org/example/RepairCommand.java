package org.example;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import org.example.Position;

import static java.lang.System.out;

public class RepairCommand extends Command {
    private JSONObject response = new JSONObject();
    private  Position position;
    public RepairCommand() {
        super("repair");
    }

    @Override
    public boolean execute(Robot target) {

        int shieldStrength = target.getShieldStrength();
        int maxShieldStrength = target.getMaxShieldStrength();

        if (shieldStrength == maxShieldStrength) {
            out.println("Your shield is already at its maximum strength!");
            return true;
        }

        int repairTime = 3; // world configuration for shield repair time in seconds
        out.println("Repairing shield for " + repairTime + " seconds...");
        try {
            Thread.sleep(repairTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        target.setShieldStrength(maxShieldStrength);
        out.println("Shield has been repaired to its maximum strength of " + maxShieldStrength + ".");

        JSONObject data = new JSONObject();
        JSONObject state = new JSONObject();

        data.put("position", "[" +target.world.getPosition().getX() +","+ target.world.getPosition().getY()+ "]");
        data.put("visibility", true);
        data.put("reload", target.setReloadTime());
        data.put("repair", target.getRepairTime());
        data.put("shields", target.getShieldStrength());
        data.put("message", "done");


        state.put("position","[ " + target.getPosition().getX() + "," + target.getPosition().getY() + " ]");
        state.put("direction", target.world.getCurrentDirection());
        state.put("shields", target.getShieldStrength());
        state.put("shots", target.getNumShots());
        state.put("status", "REPAIR");

        response.put("data", data);
        response.put("state", state);

        out.println("Response: "+response.toString(4));
        return true;

    }

}
