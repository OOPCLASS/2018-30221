package lab4;

public class Room{

	private SmartDevice smartDevice[];
	private String name;
	
	public Room(String name) {
		super();
		this.name = name;
		this.smartDevice = new SmartDevice[5];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SmartDevice[] getSmartDevice() {
		return smartDevice;
	}

	public boolean addSmartDevice(SmartDevice smartDevice[]) {
		this.smartDevice = smartDevice;
		return false;
	}
}
