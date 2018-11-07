
public class Room {
	
	private String name;
	
	SmartDevice[] smartDevices = new SmartDevice[5];
	private int i = 0;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addSmartDevice(SmartDevice d) {
		
		if( i < smartDevices.length) {
			smartDevices[i] = d;
			smartDevices[i].setId(i+1);
			i++;
		}	
	}

}
