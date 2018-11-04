package Devices;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SmartDeviceTest {

	@SuppressWarnings("unused")
	
	@Test
	public void testSmartDevice() {
		SmartDevice smartDevice = new SmartDevice("TV", true);
		boolean result = smartDevice.isTurnedOn();
		Assertions.assertTrue(result);
		smartDevice.turnOff();
		result = smartDevice.isTurnedOn();
		Assertions.assertFalse(result);
		smartDevice.turnOn();
		result = smartDevice.isTurnedOn();
		Assertions.assertTrue(result);
		System.out.println(smartDevice.getStatus());

	}

	@Test
	public void testSmartBulb() {
		SmartLightBulb smartLightBulb = new SmartLightBulb("Colored bulb", "red", 50);
		Assertions.assertTrue(smartLightBulb instanceof SmartDevice);
		System.out.println(smartLightBulb.getStatus());
	}

	@Test
	public void testSmartThermometer() {
		SmartThermometer smartThermometer = new SmartThermometer("Mercury thermometer", 24);
		Assertions.assertTrue(smartThermometer instanceof SmartDevice);
		System.out.println(smartThermometer.getStatus());
	}

}
