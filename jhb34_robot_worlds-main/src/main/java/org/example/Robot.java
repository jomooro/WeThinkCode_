package org.example;

import org.example.world.IWorld;
import org.json.JSONObject;


import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public class Robot {
    private List<Command> usedCommands = new ArrayList<>();
    private static String status;
    private static String name;
    public IWorld world;
    private String interfaceType;

    private Position position;

    private static Direction curDirection;
    private int shield = 10;
    private int shots = 10;
    private BufferedWriter out;
    private int maxShots = 10;

    private int shieldStrength;
    private int maxShieldStrength =10;
    private int reloadTime =1000;
    private boolean reloading;
    private String kind;
    private int worldVisibility;
    private int repairTime = 1000;


    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.curDirection = Direction.UP;
    }



    public static String fromJSON(String robotJSONString) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("status", status);

        return jsonObject.toString();
    }

    public void listOfCommands(Command command) {
        usedCommands.add(command);
    }


    public String getStatus() {
        return status;
    }

    public boolean handleCommand(Command command) {
        return command.execute(this);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return this.position = world.getPosition();
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "[" + world.getPosition().getX() + "," + world.getPosition().getY() + "] "
                + this.name + "> " + this.status;

    }

    //changing the direction to the left
    public void turnLeft(boolean left){
        //left = false;
        world.updateDirection(left);
    }

    public void turnRight(boolean right){
        world.updateDirection(right);
    }

    public void setWorld(IWorld world) {
        this.world = world;
    }
    public Direction getCurDirection() {
        return curDirection;
    }

    public IWorld getWorld(){
        return  this.world;
    }

    public int getShield() {
        return shield;
    }
    public int getShots() {
        return shots;
    }

    public BufferedWriter getOut() {
        return out;
    }

    public int getNumShots() {
        return shots;
    }
    public void setNumshots(int shots) {
        this.shots = shots;
    }
    public int getMaxShots() {
        return maxShots;
    }
    public void setMaxShots(int maxShots) {
        this.maxShots = maxShots;
    }
    public int getShieldStrength() {
        return shieldStrength;
    }
    public int getMaxShieldStrength() {
        return maxShieldStrength;
    }
    public void setMaxShieldStrength(int maxShieldStrength) {
        this.maxShieldStrength = maxShieldStrength;
    }
    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
    public int setReloadTime() {
        return reloadTime;
    }
    public boolean setReloading(boolean b) {
        return reloading;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getWorldVisibility() {
        return worldVisibility;
    }
    public int getReloadTime() {
        return reloadTime;
    }
    public int getRepairTime() {
        return repairTime;
    }

}
