package Lab03;

public class Station {
	
	private Bus[] busses;
	private int bussesCapacity;
	private String address;
	private String telephone;
	private int noBusses;
	
	private String[] routes;
	
	
	public Station() {
		this.address = new String("Str. Observatorului, nr. 34");
		this.bussesCapacity = 10;
		this.busses = new Bus[10];
		this.noBusses = 0;
	}
	
	public Station(String address, Bus[] busses) {
		this.bussesCapacity = busses.length;
		this.address = address;
		this.busses = busses;
		this.noBusses = busses.length;
	}
	
	public int getNoBusses() {
		return noBusses;
	}
	public void setNoBusses(int noBusses) {
		this.noBusses = noBusses;
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
		
		if(noBusses == 0) {
			System.out.println("No busses available at the moment!");
			return;
		}
		
		for(int i = 0; i < this.noBusses; i++) {
			System.out.println("Bus[" + (i+1) + "]: " + this.busses[i]);
		}
		
	}
	
	public boolean addBus(Bus bus) {
		if(noBusses < bussesCapacity) {
			busses[noBusses] = bus;
			noBusses++;
			System.out.println("Bus <" + bus.getLicensePlate() + "> loaded.\n");
			return true;
		}
		System.out.println("No empty spots! Try again later!\n");
		return false;
	}
	
	public boolean removeBus(Bus bus) {
		
		boolean busFound = false;
		int i = 0;
		
		for(i = 0; i < noBusses; i++) {
			if(busses[i].equals(bus)) {
				busFound = true;
				break;
			}
		}
		
		int j;
		
		if(busFound) {
			for(j = i; j < noBusses; j++) {
				busses[j] = busses[j+1];
			}
			
			noBusses--;
			System.out.println("Bus <" + bus.getLicensePlate() + "> removed.\n");
			return true;
		}
		
		System.out.println("Bus not found!\n");
		return false;
	}
	
}