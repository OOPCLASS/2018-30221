package test;

import org.junit.Test;
import junit.framework.Assert;
import models.MainController;
import models.Room;
import models.SmartDevice;
import models.SmartLightBulb;
import models.SmartThermometer;
@SuppressWarnings("deprecation")

public class testClass {

	@Test
	public void testDevices() {
		
		SmartDevice firstDevice = new SmartDevice("MOUSE");
		SmartDevice secondDevice = new SmartDevice("TV");
		SmartDevice thirdDevice = new SmartLightBulb("BULB_A", "WHITE", 60);
		SmartDevice fourthDevice = new SmartThermometer("TEMP_A", 23);
		
		firstDevice.turnOn();

		System.out.println("Testing devices creation and turning on first device...");
		System.out.println(firstDevice.getStatus());
		System.out.println(secondDevice.getStatus());
		System.out.println(thirdDevice.getStatus());
		System.out.println(fourthDevice.getStatus());
		
		System.out.println();
		
	}
	
	@Test
	public void testRooms() {
		
		SmartDevice firstDevice = new SmartLightBulb("BULB_A", "WHITE", 60);
		SmartDevice secondDevice = new SmartThermometer("TEMP_A", 23);
		
		Room[] rooms = new Room[2];
		
		rooms[0] = new Room("A");
		rooms[0].addSmartDevice(firstDevice);
		
		rooms[1] = new Room("B");
		rooms[1].addSmartDevice(secondDevice);
		

		System.out.println("Testing rooms creation...");
		System.out.println(rooms[0].getStatus());
		System.out.println(rooms[1].getStatus());
		
		System.out.println();
			
	}
	
	@Test
	public void testTurnOnAllDevices() {
		
		SmartDevice firstDevice = new SmartLightBulb("BULB_A", "WHITE", 60);
		SmartDevice secondDevice = new SmartThermometer("TEMP_A", 23);
		
		Room[] rooms = new Room[2];
		
		rooms[0] = new Room("A");
		rooms[0].addSmartDevice(firstDevice);
		
		rooms[1] = new Room("B");
		rooms[1].addSmartDevice(secondDevice);
		
		MainController controller = new MainController(rooms);
		
		System.out.println("Testing 'TurnOnAllDevices'...");
		Assert.assertEquals(2, controller.turnOnAllSmartDevices());
		
		System.out.println(rooms[0].getStatus());
		System.out.println(rooms[1].getStatus());
				
		System.out.println();
	}
	
	@Test
	public void testSystem() {
		
		SmartDevice firstDevice = new SmartLightBulb("BULB_A", "WHITE", 60);
		SmartDevice secondDevice = new SmartThermometer("TEMP_A", 23);
		
		Room[] rooms = new Room[2];
		
		rooms[0] = new Room("A");
		rooms[0].addSmartDevice(firstDevice);
		
		rooms[1] = new Room("B");
		rooms[1].addSmartDevice(secondDevice);
		
		MainController controller = new MainController(rooms);
		
		System.out.println("Testing System configuration...");
		
		System.out.println(controller.getStatus());
				
		System.out.println();
		
	}
	
}
