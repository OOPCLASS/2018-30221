import java.util.ArrayList;
import java.util.List;
import Devices.SmartDevice;
import Room.Room;

public class MainController {
	
	private List<Room> rooms = new ArrayList<Room>();
	private int maxCapacity = 10;
	
	public MainController() {
		
	}
	
	public MainController(List<Room> rooms) {
		this.rooms = rooms;		
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public String getStatus() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Main controller: ").append('\n');
				
		Room r;
		for(int i  = 0 ; i < rooms.size(); i ++) {
				r = rooms.get(i);
				stringBuilder.append(r.getStatus())
							 .append("\n");
		}
		
		return stringBuilder.toString();
	}
	
	public List<SmartDevice> getAllSmartDevices(){
		
		List<SmartDevice> smartDevices = new ArrayList<SmartDevice>();
		Room currentRoom;
		for(int i  = 0 ; i < rooms.size(); i++) {
			currentRoom = rooms.get(i);
			List<SmartDevice> result = new ArrayList<SmartDevice>();
			result = currentRoom.getSmartDevices();
			smartDevices.addAll(result);
		}
		return (smartDevices);
	}
	
	
	int turnOnAllSmartDevices() {
		
		int count = 0;
		for(int i = 0 ; i < rooms.size(); i ++ ) {
			Room currentRoom = rooms.get(i);
			for( int j = 0 ; j < currentRoom.getSmartDevices().size(); j++) {
				SmartDevice currentSmartDevice = currentRoom.getSmartDevices().get(j);
				if( currentSmartDevice.isTurnedOn() == false) {
					count++;
					currentSmartDevice.turnOn();
				}
			}
		}
		return count;
	}
	
	int turnOffAllSmartDevices() {
		
		int count = 0;
		for(int i = 0 ; i < rooms.size(); i++) {
			Room currentRoom = rooms.get(i);
			for( int j = 0 ; j < currentRoom.getSmartDevices().size(); j++) {
				SmartDevice currentSmartDevice = currentRoom.getSmartDevices().get(j);
				if( currentSmartDevice.isTurnedOn() == true) {
					count++;
					currentSmartDevice.turnOff();
				}
			}
		}
		return count;
	}
	
	public void addRoom(Room room) {
		Room r = new Room(room.getName(), room.getSmartDevices());
		if( rooms.size() < maxCapacity) {
			this.rooms.add(r);
		}
	}
	
}
