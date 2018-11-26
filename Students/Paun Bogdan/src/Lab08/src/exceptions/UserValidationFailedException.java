package exceptions;
import javax.management.RuntimeErrorException;

public class UserValidationFailedException extends RuntimeException {

	public UserValidationFailedException(String message) {
		super(message);
	}
	
}
