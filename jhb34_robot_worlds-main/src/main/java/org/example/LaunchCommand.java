package org.example;
import org.json.JSONObject;

import static java.lang.System.out;

public class LaunchCommand extends Command {
    private String kind;
    private int maxShieldStrength;
    private int maxShots;

    public LaunchCommand(String kind) {
        super("launch");
        this.kind = kind;
    }

    @Override
    public boolean execute(Robot target) {
        target.setKind(kind);
        target.setMaxShieldStrength(maxShieldStrength);
        target.setMaxShots(maxShots);

        // Prepare the response
        JSONObject data = new JSONObject();
        data.put("position", "[" + target.getPosition().getX() + "," + target.getPosition().getY() + "]");
        data.put("visibility", target.getWorldVisibility());
        data.put("reload", target.getReloadTime());
        data.put("repair", target.getRepairTime());
        data.put("shields", target.getMaxShieldStrength());

        JSONObject state = new JSONObject();
        state.put("position", "[" + target.getPosition().getX() + "," + target.getPosition().getY() + "]");
        state.put("direction",target.world.getCurrentDirection());
        state.put("shields", target.getShield());
        state.put("shots", target.getNumShots());
        state.put("status", "NORMAL");

        JSONObject response = new JSONObject();
        response.put("result", "OK");
        response.put("data", data);
        response.put("state", state);

        out.println("Response: "+response.toString(4));

        return true;
    }
}
