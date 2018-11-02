package models;

public class SmartThermometer extends SmartDevice{

	private double temperature;
	
	public SmartThermometer(String name, double temperature) {
		super(name);
		this.temperature = temperature;
	}
	
	public double getTemperature() {
		return this.temperature;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String getStatus() {
		StringBuilder stringBuilder = new StringBuilder(super.getStatus());
		return stringBuilder.append(", temperature=")
							.append(temperature)
							.toString();
	}
}
