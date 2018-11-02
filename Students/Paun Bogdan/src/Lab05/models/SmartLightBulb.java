package models;

public class SmartLightBulb extends SmartDevice{

	private String color;
	private Integer intensity;
	
	public SmartLightBulb(String name, String color, Integer intensity) {
		super(name);
		this.color = color;
		this.intensity = intensity;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Integer getIntensity() {
		return this.intensity;
	}
	
	public void setIntensity(Integer intensity) {
		this.intensity = intensity;
	}
	
	@Override
	public String getStatus() {
		StringBuilder stringBuilder = new StringBuilder(super.getStatus());
		return stringBuilder.append(", color=")
							.append(color)
							.append(", intensity=")
					 		.append(intensity)
					 		.toString();
	}
	
}
