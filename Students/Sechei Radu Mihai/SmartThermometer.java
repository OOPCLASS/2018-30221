package com.company;

public class SmartThermometer extends SmartDevice{
    private double temperature;

    public SmartThermometer(int id, String name, boolean turnedOn, double temperature) {
        super(id, name, turnedOn);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String getStatus() {
        return super.getStatus() + "; temperature = " + temperature;
    }
}
