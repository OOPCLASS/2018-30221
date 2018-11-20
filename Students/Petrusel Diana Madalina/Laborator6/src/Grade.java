import java.util.Random;

public class Grade implements Comparable{
	
	public int MAX = 100;
	
	public int value;
	
	private Random random = new Random();
	
	public Grade() {
		this.value = 1 + random.nextInt(MAX);
	}

	@Override
	public int compareTo(Comparable object) {
		
		Comparable other = object;
		
		if(getValue() < other.getValue() ) {
			return 1;
		}
		else if(getValue() > other.getValue()) {
			return -1;
		}
		else {
			return 0;
		}
	}

	@Override
	public int getValue() {	
		return value;
	}
	
	
}
