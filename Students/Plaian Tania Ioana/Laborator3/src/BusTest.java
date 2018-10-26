import org.junit.Test;

public class BusTest {

		@Test
		public void testDrive() {
		
			Bus firstBus = new Bus("M", "RED", 10);
			System.out.println(firstBus.getBrand());
			
			Bus blueBus = new Bus("T", "BLUE", 15);
			System.out.println(blueBus.getBrand());
			
			firstBus.setColor("Pink");
			blueBus.openDoors();
			
		}
		
}
