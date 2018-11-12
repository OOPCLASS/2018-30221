package lab4;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void testSmartDevice() {
		SmartDevice philips = new SmartLightBulb(idGenerator.getNextId(), "Philips-Hue", true, "Blue", 50);
		SmartDevice thermometer = new SmartThermometer(idGenerator.getNextId(), "Thermometer-1", false, 18);
		
		System.out.println("THERMOMETER:\n\tID\tNAME\t\tTEMPERATURE\tON/OFF");
		System.out.println("\t"+thermometer.getId()+"\t"+thermometer.getName()+"\t"+((SmartThermometer) thermometer).getTemperature()+"\t\t"+((SmartThermometer)thermometer).isTurnedOn());
		System.out.println("SMART LIGHT:\n\tID\tNAME\t\tCOLOR\tINTENSITY\tON/OFF");
		System.out.println("\t"+philips.getId()+"\t"+philips.getName()+"\t"+((SmartLightBulb) philips).getColor()+"\t"+((SmartLightBulb)philips).getIntensity()+"\t\t"+((SmartLightBulb)philips).isTurnedOn());
	}
}
