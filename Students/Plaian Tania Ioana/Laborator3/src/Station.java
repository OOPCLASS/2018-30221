import java.util.*;

public class Station {
	
	private String name;
	private String location;	
	private List<Bus> buses = new ArrayList<Bus>();
	
	Scanner input = new Scanner(System.in);
	
	public Station(String name, String location, List<Bus> buses) {
		this.name = name;
		this.location = location;
		this.buses = buses;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public void AddBus(String tempBrand, String tempColor, int tempNumberOfSeats) {
		Bus b = new Bus(tempBrand, tempColor, tempNumberOfSeats);
		this.buses.add(b);	
	}
	
	public void FillArray() {
		
		System.out.println("Enter number of buses: ");
		int numberOfBuses = input.nextInt();		
		for(int i = 0 ; i < numberOfBuses; i ++) {
			System.out.println("Enter the bus brand: ");
			String tempBrand = input.next();
			System.out.println("Enter the bus color: ");
			String tempColor = input.next();
			System.out.println("Enter the number of seats: ");
			int tempNumberOfSeats = input.nextInt();
			AddBus(tempBrand, tempColor, tempNumberOfSeats);
		}
	}
	
	public void PrintBuses() {
		for(int i = 0 ; i <= buses.size(); i ++)
			System.out.println("Bus" + buses.get(i).toString());
	}
	
	public void RemoveBus(int numberOfSeats) {
		
		buses.removeIf((Bus b) -> b.getNumberOfSeats() >= numberOfSeats);
	}
		
}
