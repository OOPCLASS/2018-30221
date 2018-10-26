package Lab03;

public class Bus {

	private String brand;
	private String color;
	private int numberOfSeats;
	private String licensePlate;
	
	public Bus() {
		brand = "M";
		color = "RED";
	}
	
	public Bus(String brand, String color) {
		this.brand = brand;
		this.color = color;
	}
	
	public void OpenDoors() {
		System.out.println("Opening doors!");
	}
	
	public void CloseDoors() {
		System.out.println("Closing doors!");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	@Override
	public String toString() {
		return "Details: brand = " + this.brand + ", color = " + this.color
				+ ", plates = " + this.licensePlate;
	}
	
}
