package vehicle;

public class Vehicle {
	private int numberOfWheels;

	public Vehicle() {
		System.out.println("Creating a vehicle..");
	}

	public Vehicle(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}
}
