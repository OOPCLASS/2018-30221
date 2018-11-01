package Lab03;

import org.junit.Test;

public class BusTest {

	@Test
	public void testStation() {
		
		Bus[] busses = new Bus[10];
		
		Bus firstBus = new Bus("A", "RED", "B-01-UNU");
		Bus secondBus = new Bus("B", "GREEN", "C-02-DOI");
		Bus thirdBus = new Bus("C", "BLUE", "D-03-TREI");

		busses = new Bus[]{firstBus, secondBus, thirdBus};
	
		Station firstStation = new Station("Str. Baritiu", busses);
		
		System.out.println("First Station details:");
		firstStation.detailsToString();
		
		System.out.println();
		
		Station secondStation = new Station();
		
		System.out.println("Second Station details:");
		secondStation.detailsToString();
						
	}
	
	@Test
	public void testBus() {
		Bus firstBus = new Bus("M","RED", "B-01-UNU");
		System.out.println(firstBus.getBrand());
		System.out.println(firstBus);
		
		Bus blueBus = new Bus("T", "BLUE", "C-02-DOI");
		System.out.println(blueBus);
		blueBus.setLicensePlate("CJ-01-ABC");
		System.out.println(blueBus);
	}

	@Test
	public void testAddRemoveBus() {
		Bus firstBus = new Bus("M","RED", "CJ-01-UNU");
		Bus secondBus = new Bus("T","BLUE", "CJ-02-DOI");
		Bus thirdBus = new Bus("N","YELLOW", "CJ-03-TREI");
		Bus fourthBus = new Bus("P","GREEN", "CJ-04-PATRU");
		
		System.out.println(firstBus);
		System.out.println(secondBus);
		System.out.println(thirdBus);
		System.out.println(fourthBus);
		
		Station station = new Station();
		
		station.addBus(firstBus);
		station.addBus(secondBus);
		station.addBus(thirdBus);
		station.addBus(fourthBus);
		
		station.detailsToString();	
		
		station.removeBus(firstBus);
		
		station.detailsToString();	
		
	}
	
}
