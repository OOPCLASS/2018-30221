import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import org.junit.Test;


public class UserValidator {
	
	private final int SSN_LENGTH = 13;
	private final String SSN_CONTROL = "279146358279";
	
	 public void validate (User user) throws UserValidationFailedException{
		 
		 //SSN - 13 caractere
		 //S - 1 sexul
		 //AA - 2 anul nasterii
		 //LL - 2 luna nasterii
		 //ZZ - 2 ziua nasteii
		 //JJ - 2 judetul nasterii
		 //NNN - 3 cod judet alocare unica persona
		 //C - 1 cifra control ==> rest = [sum(CNP(digit) * 279146358279(digit)), digit=1:13 ] % 11 == 10 ? 1 : rest 
		 
		 String ssn = user.getSsn();
		 
		 int S = Integer.parseInt(ssn.substring(0, 1));
		 String AA = ssn.substring(1, 3);
		 String LL = ssn.substring(3,5);
		 String ZZ = ssn.substring(5,7);
		 String JJ = ssn.substring(7,9);
		 String NNN = ssn.substring(9,12);
		 int C = Integer.parseInt(ssn.substring(12, 13));
		 
		 if(verifyLength(user.getSsn().length()) == false) {
			 throw new UserValidationFailedException("The length of SSN is incorrect!");
		 }
		 else {
			 System.out.println("S: " + S + " AA: " + AA + " LL: " + LL + " ZZ: " + ZZ + " JJ: " + JJ + " NNN: " + NNN + " C: " + C);
		 }
		 
		 if(verifyGender(S) == false) {
			 throw new UserValidationFailedException("The gender is incorrect!");
		 }
		 
		 if(verifyYear(AA) == false) {
			 throw new UserValidationFailedException("The year is incorrect!");
		 }
		 
		 if(verifyMonth(LL) == false) {
			 throw new UserValidationFailedException("The month is incorrect!");
		 }
		 
		 if(verifyDay(S, AA, LL, ZZ) == false) {
			 throw new UserValidationFailedException("The day is incorrect!");
		 }
		 
		 if(verifyCounty(JJ) == false) {
			 throw new UserValidationFailedException("The county is incorrect!");
		 }
		 
		 if(verifyCodeCounty(NNN) == false) {
			 throw new UserValidationFailedException("The county code is incorrect!");
		 }
		 
		 if(verifyControlDigit(C,user.getSsn()) == false) {
			 throw new UserValidationFailedException("The control digit is incorrect!");
		 }
		
	 }
	 
	 public boolean verifyLength(int length) {
		 if(length != SSN_LENGTH) {
			 return false;
		 }
		 return true;
	 }
	 
	 public boolean verifyGender(int gender) {
		if(gender >= 1 && gender <= 8) {
			return true;
		}
		else return false;
	 }
	 
	 public boolean verifyYear(String year) {
		 int y = Integer.parseInt(year);
		 
		 if( y >= 0 && y <= 99) {
			 return true;
		 }
		 return false;
	 }
	 
	 public boolean verifyMonth(String month) {
		 int m = Integer.parseInt(month);
		 
		 if(m >= 1 && m <= 12) {
			 return true;
		 }
		 return false;
	 }
	 
	 public boolean isLeapYear(int year) {
		 return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	 }
	 
	 public boolean verifyDay(int gender, String year, String month, String day) {
		 int totalYear;
		 
		 if(gender == 1 || gender == 2 || gender == 7 || gender == 8)
			 totalYear = 1900;
		 else if(gender == 3 || gender == 4) {
			 totalYear = 1800;
		 }
		 else {
			 totalYear = 2000;
		 }
		
		 int lastTwoDigits = (Character.getNumericValue(year.charAt(0)))*10 + (Character.getNumericValue(year.charAt(1)));
		 int completeYear = totalYear + lastTwoDigits;
		 
		 int monthDays[] = {0 ,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
		 
		 if(isLeapYear(completeYear) == true) {
			 monthDays[2] = 29;
		 }
		 
		 int completeMonth = Integer.parseInt(month);
		 int completeDay = Integer.parseInt(day);
		 
		 return completeDay >= 0 && completeDay <= monthDays[completeMonth];
		 
	 }
	 
	 public boolean verifyCounty(String county) {
		 int c = Integer.parseInt(county);
		 
		 if( c >= 1 && c <= 52) {
			 return true;
		 }
		 return false;
	 }
	 
	 public boolean verifyCodeCounty(String code) {
		 int c = Integer.parseInt(code);
		 
		 if(c >= 1 && c <= 999) {
			 return true;
		 }
		 return false;
	 }
	 
	 public int getControlDigit(String ssn) {
		 int suma = 0;
		 
		 for(int i = 0 ; i < ssn.length() - 1; i++) {
			 suma += Integer.parseInt(ssn.substring(i,i+1)) * Integer.parseInt(SSN_CONTROL.substring(i,i+1));
		 }
		 
		 suma = suma % 11;
		 if(suma == 10) {
			 return 1;
		 }
		 return suma;
	 }
	 
	 public boolean verifyControlDigit(int digit, String ssn) {
		 
		 if(digit != getControlDigit(ssn)) {
			 return false;
		 }
		 return true;
	 }
	 

}
