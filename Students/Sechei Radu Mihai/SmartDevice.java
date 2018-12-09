package com.company;

public class SmartDevice {
    private int id;
    private String name;
    private boolean turnedOn;
 public SmartDevice(){

 }
    public SmartDevice(int id, String name, boolean turnedOn) {
        this.id = id;
        this.name = name;
        this.turnedOn = turnedOn;
    }

    public void turnOn(){
        System.out.println("The Smart Device is turning on ...");
        turnedOn = true;
    }
    public void turnOff(){
        System.out.println("The Smart Device is turning off");
        turnedOn = false;
    }
    public boolean isTurnedOn(){
        return turnedOn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getStatus(){
        return "id = " + id + "; name =  " + getName() + "; turned on = " + isTurnedOn();
    }
}
