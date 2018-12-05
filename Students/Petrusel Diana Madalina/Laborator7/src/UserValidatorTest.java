import org.junit.Test;

public class UserValidatorTest {
	
	@Test
	
	public void testUser() {
		System.out.println("Enter a Social Security Nmber: ");
		User user = new User();
		
		UserValidator uvd = new UserValidator();
		
		try {
			uvd.validate(user);
		}
		catch(UserValidationFailedException e){
			System.out.println(e.getMessage());
			System.out.println("Please try again!");
			user = new User();
		}
	}

}
