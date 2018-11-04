import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Devices.SmartDevice;
import Devices.SmartLightBulb;
import Devices.SmartThermometer;
import Room.Room;

class MainControllerTest {

	@Test
	void testMainController() {

		List<Room> rooms = new ArrayList<Room>();
		Room firstRoom = new Room();
		Room secondRoom = new Room();
		firstRoom.setName("Bedroom");
		secondRoom.setName("Living room");

		SmartLightBulb firstSmartLightBulb = new SmartLightBulb("Pink bulb","pink", 50);
		SmartThermometer firstSmartThermometer = new SmartThermometer("Thermometer",25);
		SmartLightBulb secondSmartLightBulb = new SmartLightBulb("Incandescent bulb","blue", 80);
		SmartThermometer secondSmartThermometer = new SmartThermometer("thermometer",25);
		SmartDevice smartDevice = new SmartDevice("Laptop",true);

		List<SmartDevice> smartDevices = new ArrayList<SmartDevice>();
		smartDevices.add(firstSmartLightBulb);
		smartDevices.add(firstSmartThermometer);
		smartDevices.add(smartDevice);
		firstRoom.setSmartDevice(smartDevices);
	

		List<SmartDevice> secondSmartDevices = new ArrayList<SmartDevice>();
		secondSmartDevices.add(secondSmartLightBulb);
		secondSmartDevices.add(secondSmartThermometer);
		secondRoom.setSmartDevice(secondSmartDevices);

		MainController mainController = new MainController(rooms);

		mainController.addRoom(firstRoom);
		mainController.addRoom(secondRoom);

		Assertions.assertEquals(2, mainController.getRooms().size());
		Assertions.assertEquals(5, mainController.getAllSmartDevices().size());

		int result = mainController.turnOnAllSmartDevices();
		Assertions.assertEquals(4, result);

		result = mainController.turnOffAllSmartDevices();
		Assertions.assertEquals(5, result);

		System.out.println(mainController.getStatus());
	}
}