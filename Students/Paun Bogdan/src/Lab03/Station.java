package Lab03;

public class Station {
	
	private Bus[] busses;
	private int bussesCapacity;
	private String address;
	private String telephone;
	
	private String[] routes;
	
	
	public Station() {
		this.address = new String("Str. Observatorului, nr. 34");
		this.bussesCapacity = 10;
		this.busses = new Bus[10];
	}
	
	public Station(String address, int bussesCapacity, Bus[] busses) {
		this.bussesCapacity = bussesCapacity;
		this.address = address;
		this.busses = busses;
	}
	
	public Bus[] getBusses() {
		return busses;
	}

	public void setBusses(Bus[] busses) {
		this.busses = busses;
	}

	public int getBussesCapacity() {
		return bussesCapacity;
	}

	public void setBussesCapacity(int bussesCapacity) {
		this.bussesCapacity = bussesCapacity;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String[] getRoutes() {
		return routes;
	}

	public void setRoutes(String[] routes) {
		this.routes = routes;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void detailsToString() {
		System.out.println("Address: " + this.address);
		System.out.println("Telephone: " + this.telephone);
		System.out.println("Busses capacity: " + this.bussesCapacity);
		System.out.println("Routes: " + this.routes);

		boolean isEmpty = true;
		
		for(int i = 0; i < this.bussesCapacity; i++) {
			if(this.busses[i] != null) {
				System.out.println("Bus[" + i + "]: " + this.busses[i]);
				isEmpty = false;
			}
		}
		
		if(isEmpty) {
			System.out.println("No busses available at the moment!");
		}
	
	}
	
}