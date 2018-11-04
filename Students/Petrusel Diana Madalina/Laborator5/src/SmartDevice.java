
public class SmartDevice {

	protected int id;
	protected String name;
	private boolean turnedOn;
	protected String turned;
	
	public int length;
	
	public SmartDevice() {
		id = 0;
		setName(name);
		turnedOn = false;
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
		if( this.turnedOn == true ) return true;
		return false;
	}
	
	public void turnOn() {
		if(isTurnedOn() == false)
			this.turnedOn = true;
	}
	
	public void turnOff() {
		if( isTurnedOn() == true )
			this.turnedOn = false;
	}	
	
	public void isTurned() {
		if(isTurnedOn() == true)
			this.turned = "open";
		else
			this.turned = "close";
	}
	
	public String toString() {
		return Integer.toString(id) + "\t" + name + "\t" + turned + "\t";
	}
}
