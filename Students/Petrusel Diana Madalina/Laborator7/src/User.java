import java.util.Scanner;

public class User {
	
	public String ssn;
	
	Scanner in = new Scanner(System.in);
	
	public User() {
		this.ssn = in.nextLine();
	}

	public String getSsn() {
		return ssn;
	}

}
