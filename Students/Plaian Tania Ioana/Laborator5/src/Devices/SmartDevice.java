package Devices;

public class SmartDevice {

	private int id;
	private String name;
	boolean turnedOn;

	public SmartDevice() {

	}

	public SmartDevice(String name, boolean turnedOn) {
		this.name = name;
		this.turnedOn = turnedOn;
		this.id = IdGenerator.getNextId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isTurnedOn() {

		if (this.turnedOn == true)
			return true;
		else
			return false;
	}

	public void turnOn() {
		if (isTurnedOn() == false)
			this.turnedOn = true;
	}

	public void turnOff() {
		if (isTurnedOn())
			this.turnedOn = false;
	}

	public String getStatus() {

		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append("Device: Id = ").append(id).append(", name = ").append(name).append(", turnedOn = ")
				.append(turnedOn).toString();
	}
}
