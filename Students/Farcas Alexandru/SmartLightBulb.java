package lab4;

public class SmartLightBulb extends SmartDevice{

	private String color;
	private Integer intensity;

	public SmartLightBulb(int id, String name, boolean turnedOn, String color, Integer intensity) {
		super(id, name, turnedOn);
		this.color = color;
		this.intensity = intensity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getIntensity() {
		return intensity;
	}

	public void setIntensity(Integer intensity) {
		this.intensity = intensity;
	}
}
