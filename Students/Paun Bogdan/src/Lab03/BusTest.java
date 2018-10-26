package Lab03;

import org.junit.Test;

public class BusTest {

	@Test
	public void testStation() {
		
		Bus[] busses = new Bus[10];
		
		Bus firstBus = new Bus("A", "RED");
		Bus secondBus = new Bus("B", "GREEN");
		Bus thirdBus = new Bus("C", "BLUE");

		busses = new Bus[]{firstBus, secondBus, thirdBus};
	
		Station firstStation = new Station("Str. Baritiu", busses.length, busses);
		
		System.out.println("First Station details:");
		firstStation.detailsToString();
		
		System.out.println();
		
		Station secondStation = new Station();
		
		System.out.println("Second Station details:");
		secondStation.detailsToString();
						
	}
	
	@Test
	public void testBus() {
		Bus firstBus = new Bus("M","RED");
		System.out.println(firstBus.getBrand());
		System.out.println(firstBus);
		
		Bus blueBus = new Bus("T", "BLUE");
		blueBus.setLicensePlate("CJ 01 ABC");
		System.out.println(blueBus);
	}
	
}
