import java.util.Arrays;

import org.junit.Test;

public class SortTest {
	
	@Test
	public void testBubbleSortAscending() {
		
		Grade[] grades = new Grade[10];
		
		for(int i = 0; i < 10 ; i++) {
			grades[i] = new Grade();
		}
		
		Arrays.stream(grades).map(Grade::getValue).forEach(System.out::println);
		
		System.out.println("\nAfter sorting: ");
		
		Sort.bubbleSortAscending(grades,10);
		
		Arrays.stream(grades).map(Grade::getValue).forEach(System.out::println);
		
	}

}
