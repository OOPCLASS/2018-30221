package lab4;

public class SmartDevice {

	private int id;
	private String name;
	private boolean turnedOn;

	public SmartDevice(int id,String name,boolean turnedOn){
		this.id=id;
		this.name = name;
		this.turnedOn = turnedOn;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isTurnedOn() {
		return turnedOn;
	}

	public void turnOn(boolean turnedOn) {
		if(this.turnedOn = false)
			this.turnedOn = true;
	}

	public void turnOff(boolean turnedOn) {
		if(this.turnedOn = turnedOn)
			this.turnedOn = false;
	}
}
