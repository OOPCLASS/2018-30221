
public class SmartThermometer extends SmartDevice {
	
	protected double temperature;
	
	public SmartThermometer() {
		
		super();
		
		setTemperature(temperature);
		
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public String toString() {
		return Integer.toString(id) + "\t" + name + " " + turned + " " + temperature;
	}
}
