package vehicle;

public class Bus extends Vehicle {
	public Bus() {
		super(16);
		System.out.println("Creating a bus..");
	}

	public void turnTVOn() {
		System.out.println("Turning TV on!");
	}
}
