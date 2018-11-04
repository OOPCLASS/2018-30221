package Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Devices.SmartDevice;

class RoomTest {

	@Test
	public void testRoom() {

		Scanner input = new Scanner(System.in);
		List<SmartDevice> smartDevices = new ArrayList<SmartDevice>();
		Room room = new Room("Living room", smartDevices);
		Assertions.assertEquals(0, smartDevices.size());
		boolean result = false;
		for (int i = 0; i <= 4; i++) {
			System.out.println("Enter the device name: ");
			String tempName = input.next();
			System.out.println("Is the device tunred on?");
			Boolean tempTurnedOn = input.nextBoolean();
			SmartDevice smartDevice = new SmartDevice(tempName, tempTurnedOn);
			result = room.addSmartDevice(smartDevice);
		}
		
		Assertions.assertTrue(result);
		SmartDevice s = new SmartDevice();
		result = room.addSmartDevice(s);
		Assertions.assertFalse(result);
		System.out.println(room.getStatus());

	}

}
