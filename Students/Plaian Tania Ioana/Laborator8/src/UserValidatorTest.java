import org.junit.jupiter.api.Test;

public class UserValidatorTest {
	
	@Test
	public void validateUserTest() {
		//SAALLZZJJNNNC
		User user = new User();
		user.setSsn("2981110060019");
		UserValidator validator = new UserValidator();
		try {
			validator.validateUser(user);
			System.out.println("Valid ssn");
		}
		catch(UserValidationException e) {
			System.out.println(e.getMessage());
		}
	}

}
