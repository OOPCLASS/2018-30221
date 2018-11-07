import org.junit.Test;

public class RoomTest {
	
	@Test
	
	public void testRoom() {
		
		Room room = new Room();
		
		room.setName("kitchen");
		
		SmartDevice lightBulb1 = new SmartLightBulb();
		SmartDevice lightBulb2 = new SmartLightBulb();
		SmartDevice thermometer = new SmartThermometer();
		
		//lightBulb1.getId();
		lightBulb1.setName("LED bulb");
		lightBulb1.turnOn();
		lightBulb1.isTurned();
		((SmartLightBulb) lightBulb1).setColor("white");
		((SmartLightBulb) lightBulb1).setIntensity(70);
		
		//lightBulb2.getId();
		lightBulb2.setName("Halogen bulb");
		lightBulb2.turnOff();
		lightBulb2.isTurned();
		((SmartLightBulb) lightBulb2).setColor("yellow");
		((SmartLightBulb) lightBulb2).setIntensity(150);
		
		//thermometer.getId();
		thermometer.setName("Digital thermometer");
		thermometer.turnOn();
		thermometer.isTurned();
		((SmartThermometer) thermometer).setTemperature(25);
		
		room.addSmartDevice(lightBulb1);
		room.addSmartDevice(lightBulb2);
		room.addSmartDevice(thermometer);
		
		System.out.println("We are in the " + room.getName() + "!");	
		System.out.println("\nWe have two light bulbs:\n\n" + lightBulb1 + "\n" + lightBulb2 + "\n");
		System.out.println("\nWe also have a thermometer:\n\n" + thermometer);
	}
	
	
}
