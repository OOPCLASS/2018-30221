package Devices;

public class SmartThermometer extends SmartDevice {

	private double temperature;

	public SmartThermometer(String name, double temperature) {
		super(name, false);
		this.temperature = temperature;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return super.toString() + " temperature " + this.temperature;
	}

	@Override
	public String getStatus() {

		StringBuilder stringBuilder = new StringBuilder(super.getStatus());
		return stringBuilder.append(", temperature = ").append(temperature).toString();
	}

}
