package Room;

import java.util.ArrayList;
import java.util.List;

import Devices.SmartDevice;

public class Room {

	private String name;
	private List<SmartDevice> smartDevices = new ArrayList<SmartDevice>();
	private int maxCapacity = 5;

	public Room() {

	}

	public Room(String name, List<SmartDevice> smartDevices) {
		this.smartDevices = smartDevices;
		this.name = name;
	}

	public List<SmartDevice> getSmartDevices() {
		return smartDevices;
	}

	public void setSmartDevice(List<SmartDevice> smartDevices) {
		this.smartDevices = smartDevices;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean addSmartDevice(SmartDevice smartDevice) {

		SmartDevice s = new SmartDevice(smartDevice.getName(), smartDevice.isTurnedOn());
		if (smartDevices.size() < this.maxCapacity) {
			this.smartDevices.add(s);
			return true;
		}
		else{
			System.out.println("Too many devices in this room!");
			return false;
		}
	}

	public String getStatus() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Room: Name = ").append(name).append(", Devices : ").append("\n");
		SmartDevice s;
		for (int i = 0 ; i < smartDevices.size(); i++) {
			s = smartDevices.get(i);
			stringBuilder.append(s.getStatus()).append("\n");

		}
		return stringBuilder.toString();
	}
}
