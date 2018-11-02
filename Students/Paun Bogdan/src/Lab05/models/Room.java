package models;

import java.util.Objects;

public class Room {

	private String name;
	private SmartDevice[] smartDevices;
	private int noDevices;
	private final int NO_MAX_DEVICES_IN_A_ROOM = 5;

	public Room(String name) {
		this.name = name;
		smartDevices = new SmartDevice[NO_MAX_DEVICES_IN_A_ROOM];
		noDevices = 0;
	}
	
	public boolean addSmartDevice(SmartDevice smartDevice) {
		if(noDevices < smartDevices.length) {
			smartDevices[noDevices] = smartDevice;
			noDevices++;
			return true;
		}
		return false;		
	}
	
	public SmartDevice[] getSmartDevices() {
		return smartDevices;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNoDevices() {
		return this.noDevices;
	}
			
	public String getStatus() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\t<Room: Name=")
					 .append(name)
					 .append(", connectedDevices=")
					 .append(noDevices)
					 .append(">\n");
					 
		for(SmartDevice smartDeviceEntry : smartDevices) {
			if(smartDeviceEntry != null) {
				stringBuilder.append("\t")
							 .append(smartDeviceEntry.getStatus())
							 .append("\n");
			}
		}
		
		return stringBuilder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Room)) {
			return false;
		}
		
		if(this == obj) {
			return true;
		}
		
		if(this.getName().equals(((Room)obj).getName())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
}
