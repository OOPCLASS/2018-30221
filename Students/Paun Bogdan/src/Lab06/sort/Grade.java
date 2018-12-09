package sort;

import java.util.Random;

public class Grade implements Comparable {

	private int value;
	private Random random = new Random();
	
	public Grade() {
		this.value = random.nextInt(9) + 1;
	}

	@Override
	public int getValue() {
		return value;
	}
	
	@Override
	public int compareTo(Comparable o) {
		if(this.value == o.getValue()) {
			return 0;
		}
		
		if(this.value < o.getValue()) {
			return -1;
		}
		
		return 1;
	}
	
}
