
public class Bus {
	
	private String brand ;
	private String color;
	private int numberOfSeats;
	
	public Bus() {
			brand = "M";
			color = "RED";
	}
	public Bus( String brand, String color, int numberOfSeats) {
		this.brand = brand;
		this.color = color;
		this.numberOfSeats = numberOfSeats;
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

	
	public void openDoors() {
		System.out.println("Opening doors.");
	}
	@Override
	public String toString() {
		return "Specs: brand = " + this.brand + ", color " + this.color + ", number of seats " + this.numberOfSeats;
	}
	

	
}
