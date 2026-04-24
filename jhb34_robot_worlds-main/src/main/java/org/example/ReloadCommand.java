package org.example;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class ReloadCommand extends Command {
    private JSONObject response = new JSONObject();

    public ReloadCommand() {
        super("reload");
    }

    @Override
    public boolean execute(Robot target) {
        if (target.getNumShots() == target.getMaxShots()) {
            System.out.println("Your shield is already at its maximum strength!");
            return true;
        }

        int loadTime = 3; // world configuration for shield repair time in seconds
        System.out.println("Reloading gun for " + loadTime + " seconds...");
        try {
            Thread.sleep(loadTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        target.setNumshots(target.getMaxShots());
        System.out.println("Gun has been reloaded with maximum shots " + target.getMaxShots() + ".");
        JSONObject data = new JSONObject();
        JSONObject state = new JSONObject();

        data.put("position", "[" + target.getPosition().getX() + "," + target.getPosition().getY() + "]");
        data.put("visibility", true);
        data.put("reload", target.setReloadTime());
        data.put("repair", target.getRepairTime());
        data.put("shields", target.getShield());

        state.put("position", "[ " + target.getPosition().getX() + "," + target.getPosition().getY() + " ]");
        state.put("direction", target.world.getCurrentDirection());
        state.put("shields", target.getShield());
        state.put("shots", target.getNumShots());
        state.put("status", "RELOAD");

        response.put("data", data);
        response.put("state", state);

        out.println("Response: "+response.toString(4));

        return true;
    }
}


