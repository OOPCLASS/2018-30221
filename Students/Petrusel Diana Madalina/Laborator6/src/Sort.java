
public class Sort {

	public static void bubbleSortAscending(Comparable[] grades, int numberOfGrades) {
		
		int i = 0, j;
		Comparable aux;
		
		boolean swapped = true;
		
		while(!swapped) {
			i = i + 1;
			swapped = false;
			
			for(j = 0; j < numberOfGrades - i; j++) {
				Comparable left = grades[j];
				Comparable right = grades[j+1];
				
				if(left.compareTo(right) < 0) {
					aux = grades[j];
					grades[j] = grades[j+1];
					grades[j+1] = aux;
					swapped = true;
				}
				
			}
			
		}
			
	}
}


