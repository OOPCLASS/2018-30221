package models;

import service.IdGenerator;

public class SmartDevice {

	private int id;
	private String name;
	private boolean turnedOn;
	
	public SmartDevice(String name) {
		this.turnedOn = false;
		this.name = name;
		this.id = IdGenerator.getNextId();
	}
	
	public void turnOn() {
		turnedOn = true;
	}
	
	public void turnOff() {
		turnedOn = false;
	}
	
	public boolean isTurnedOn() {
		return turnedOn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getStatus() {
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append("\tDevice: <Id=")
							.append(id)
							.append(", name=")
					 		.append(name)
					 		.append(", turnedOn=")
					 		.append(turnedOn)
					 		.toString();
	}
	
}
