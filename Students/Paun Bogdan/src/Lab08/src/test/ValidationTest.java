package test;
import org.junit.Test;

import exceptions.UserValidationFailedException;
import validator.User;
import validator.UserValidator;

public class ValidationTest {

//	Cu @Before putem face setup-ul : setup(). Aceasta metoda se va executa inaintea oricarei alteia.
//	finally {} e un bloc care se executa indiferent daca se ruleaza cu succes sau nu blocul try-catch
//	Chiar daca in try sau in catch gasim un return sau un break, finally {} ne garanteaza ca se vor rula
//	instructiunile din acest bloc
	
//	@Test(expected = ...excepton.class) -- verificam daca se arunca o exceptie de tipul precizat
//	public ... ____ throws ...exception() ... 
	
	
//	public class AbcException extends RuntimeException	// sau throwable sau orice altceva
//	{
//	}
		
	@Test
	public void testUser() {
		User user = new User("4011121174711");
		
		UserValidator uvd = new UserValidator();
		
		try {
			uvd.validate(user);
			uvd.getCnpDetails(user);
		}
		catch(UserValidationFailedException e){
			System.out.println(e.getMessage());
		}
		
	}
	
}
