package parking;

import vehicle.Vehicle;

public class ParkingSlot {

	// UML
	// public    -> +
	// protected -> #
	// private   -> -

	private int number;
	private double price;
	private boolean available = true;

	public int publicAttribute;
	protected int protectedAttribute;

	private Vehicle parkedVehicle;
	private Vehicle[] vehicles;

	public int getNumber() {
		return number;
	}

	private void privateMethod() {

	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}

	public boolean park(Vehicle vehicle) {
		if (isAvailable()) {
			this.parkedVehicle = vehicle;
			setAvailable(false);
			return true;
		}
		return false;
	}
}
