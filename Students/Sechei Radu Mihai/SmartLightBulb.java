package com.company;

public class SmartLightBulb extends SmartDevice{
    private String color;
    private int intensity;

    public SmartLightBulb(int id, String name, boolean turnedOn, String color, int intensity) {
        super(id, name, turnedOn);
        this.color = color;
        this.intensity = intensity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    @Override
    public String getStatus() {
        return super.getStatus() + "; color = " + color + "; intensity = " + intensity;
    }

}
