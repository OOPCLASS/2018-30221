package models;

public class MainController {

	private Room[] rooms;
	private final int NO_MAX_ROOMS = 10;
	private final int NO_MAX_DEVICES_IN_A_ROOM = 5;
	
	public MainController(){
		rooms = new Room[NO_MAX_ROOMS];
	}
	
	public MainController(Room[] rooms) {
		this.rooms = rooms;
	}
	
	public SmartDevice[] getAllSmartDevices() {
		SmartDevice[] outputDevicesArray = new SmartDevice[NO_MAX_ROOMS * NO_MAX_DEVICES_IN_A_ROOM];
		int totalDevices = 0;
		
		for(Room roomEntry : rooms) {
			if(roomEntry != null) {
				SmartDevice[] smartDeviceArray = roomEntry.getSmartDevices();
				for(SmartDevice smartDeviceEntry : smartDeviceArray) {
					if(smartDeviceEntry != null) {
						outputDevicesArray[totalDevices] = smartDeviceEntry;
						totalDevices++;
					}
				}
			}
		}
		
		return outputDevicesArray;
	}
	
	public int turnOffAllSmartDevices() {
		int turnedOffDevices = 0;
		
		SmartDevice[] smartDevicesArray = getAllSmartDevices();
		for(SmartDevice smartDeviceEntry : smartDevicesArray) {
			if(smartDeviceEntry != null) {
				smartDeviceEntry.turnOff();
				turnedOffDevices++;
			}
		}
		
		return turnedOffDevices;
	}
	
	public int turnOnAllSmartDevices() {
		int turnedOnDevices = 0;
		
		SmartDevice[] smartDevicesArray = getAllSmartDevices();
		for(SmartDevice smartDeviceEntry : smartDevicesArray) {
			if(smartDeviceEntry != null) {
				smartDeviceEntry.turnOn();
				turnedOnDevices++;
			}
		}
		
		return turnedOnDevices;
	}
	
	public String getStatus() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<System specifications>\n");
					 
		for(Room roomEntry : rooms) {
			if(roomEntry != null) {
				stringBuilder.append(roomEntry.getStatus())
							 .append("\n");
			}
		}
		
		return stringBuilder.toString();
	}
	
}
