package sort;

public class Sort {
	
	public static Comparable[] bubbleSortAscending(Comparable[] gradesArray){
		
		int arrayDimension = gradesArray.length;
		
		for(int i = 0; i < arrayDimension - 1; i++) {
			for(int j = i + 1; j < arrayDimension; j++) {
				if(gradesArray[i].compareTo(gradesArray[j]) > 0) {
					Comparable tmp = gradesArray[i];
					gradesArray[i] = gradesArray[j];
					gradesArray[j] = tmp;
				}
			}
		}
		return gradesArray;
	}
}
