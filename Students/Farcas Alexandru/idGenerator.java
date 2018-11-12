package lab4;

public class idGenerator {

	public static int counter = 0;
	
	private idGenerator(){
		
	}
	public static int getNextId(){
		return counter++;
	}
}
