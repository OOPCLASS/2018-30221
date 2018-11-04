
public class SmartLightBulb extends SmartDevice {
	
	private String color;
	private int intensity;
	
	public SmartLightBulb() {
		
		super();
		
		setColor(color);
		setIntensity(intensity);
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getIntensity() {
		return intensity;
	}
	
	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}
	
	public String toString() {
		return Integer.toString(id) + "\t" + name + " " + turned + " " + color + " " + Integer.toString(intensity) + "W";
	}
	
}
