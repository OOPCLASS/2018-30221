package parking;

import org.junit.Assert;
import org.junit.Test;

import vehicle.Bus;
import vehicle.Car;
import vehicle.Vehicle;

public class ParkingTest {

	@Test
	public void testParking() {
		ParkingSlot busParkingSlot = new BusParkingSlot();
		CarParkingSlot carParkingSlot = new CarParkingSlot();

		Vehicle car = new Car();

		boolean result = carParkingSlot.park(car);
		carParkingSlot.setAvailable(false);

		Assert.assertTrue(result);

		result = carParkingSlot.park(car);

		Assert.assertFalse(result);

		Assert.assertTrue(carParkingSlot instanceof CarParkingSlot);
		Assert.assertTrue(carParkingSlot instanceof ParkingSlot);
		Assert.assertTrue(carParkingSlot instanceof Object);

		Assert.assertTrue(busParkingSlot instanceof ParkingSlot);
		Assert.assertTrue(busParkingSlot instanceof BusParkingSlot);
		Assert.assertFalse(busParkingSlot instanceof CarParkingSlot);
	}

	@Test
	public void testVehicles() {
		Vehicle[] vehicles = new Vehicle[20];

		for (int i = 0; i < 10; i++) {
			vehicles[i] = new Car();
			vehicles[10 + i] = new Bus();
		}

		for (int i = 0; i < 20; i++) {
			Vehicle currentVehicle = vehicles[i];
			if (currentVehicle instanceof Bus) {
				((Bus) currentVehicle).turnTVOn();
			}

			System.out.println(currentVehicle.getNumberOfWheels());
		}
	}
}
