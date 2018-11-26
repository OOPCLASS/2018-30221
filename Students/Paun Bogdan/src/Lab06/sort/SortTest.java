package sort;

import org.junit.Test;

public class SortTest {

	@Test
	public void testBubbleSortAscending() {
		
		Grade[] roll = new Grade[10];
		
		for(int i = 0; i < roll.length; i++) {
			roll[i] = new Grade();
			System.out.println("roll[" + i + "] = " + roll[i].getValue());
		}
		
		Sort.bubbleSortAscending(roll);
		
		System.out.println("SORTED");
		for(int i = 0; i < roll.length; i++) {
			System.out.println("roll[" + i + "] = " + roll[i].getValue());
		}
		
	}
	
}
