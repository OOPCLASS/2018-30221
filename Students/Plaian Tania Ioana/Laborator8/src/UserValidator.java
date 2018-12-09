public class UserValidator {

	private final int SSN_LENGTH = 13;
	private final String SSN_STD = "279146358279";

	public void validateUser(User user) throws UserValidationException {

		// SAALLZZJJNNNC

		String ssn = user.getSsn();
		if (verifyLength(ssn.length()) == false) {
			throw new UserValidationException("Lungime incorecta");
		}
		if (verifyGender(ssn.substring(0, 1)) == false) {
			throw new UserValidationException("Prima cifra este gresita!");
		}
		if (verifyYear(ssn.substring(1, 3)) == false) {
			throw new UserValidationException("Anul este gresit!");
		}
		if (verifyMonth(ssn.substring(3, 5)) == false) {
			throw new UserValidationException("Luna incorecta!");
		}
		if (verifyDay(ssn.substring(0, 1), ssn.substring(1, 3), ssn.substring(3, 5), ssn.substring(5, 7)) == false) {
			throw new UserValidationException("Zi incorecta!");
		}
		if (verifyCounty(ssn.substring(7, 9)) == false) {
			throw new UserValidationException("Judet inexistent");
		}
		if (verifyNumber(ssn.substring(9, 12)) == false) {
			throw new UserValidationException("Neinregistrat!");
		}
		if (verifyDigit(ssn.charAt(12), ssn) == false) {
			throw new UserValidationException("Cifra de control incorecta!");
		}

	}

	public boolean verifyLength(int length) {

		return length == SSN_LENGTH;

	}

	public boolean verifyGender(String gender) {

		int g = Integer.parseInt(gender);
		if (g < 1 | g > 8)
			return false;
		return true;

	}

	public boolean verifyYear(String year) {

		int y = Integer.parseInt(year);
		if (y < 0 || y > 99)
			return false;
		return true;
	}

	public boolean verifyMonth(String month) {

		int m = Integer.parseInt(month);
		if (m < 1 || m > 12)
			return false;
		return true;
	}

	public boolean verifyCounty(String county) {
		int c = Integer.parseInt(county);
		if (c < 1 || c > 52)
			return false;
		return true;
	}

	public boolean verifyNumber(String number) {
		int n = Integer.parseInt(number);
		if (n < 1 || n > 999)
			return false;
		return true;
	}

	public int getControlDigit(String ssn) {
		int sum = 0;
		for (int i = 0; i < ssn.length() - 1; i++) {
			sum += Integer.parseInt(ssn.substring(i, i + 1)) * Integer.parseInt(SSN_STD.substring(i, i + 1));

		}
		sum %= 11;
		if (sum == 10)
			return 1;
		return sum;
	}

	public boolean verifyDigit(char digit, String ssn) {
		int d = Character.getNumericValue(digit);
		if (d != getControlDigit(ssn))
			return false;
		return true;
	}

	public boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	public boolean verifyDay(String sex, String year, String month, String day) {

		int yearPrefix;

		if (sex == "1" || sex == "2" || sex == "7" || sex == "8")
			yearPrefix = 1900;
		else if (sex == "3" || sex == "4")
			yearPrefix = 1800;
		else
			yearPrefix = 2000;

		int yearSuffix = (Character.getNumericValue(year.charAt(0))) * 10 + (Character.getNumericValue(year.charAt(1)));
		int completeYear = yearPrefix + yearSuffix;

		int monthDays[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeapYear(completeYear) == true)
			monthDays[2] = 29;
		int completeMonth = (Character.getNumericValue(month.charAt(0))) * 10
				+ (Character.getNumericValue(month.charAt(1)));
		int completeDay = (Character.getNumericValue(day.charAt(0))) * 10 + (Character.getNumericValue(day.charAt(1)));

		return completeDay >= 0 && completeDay <= monthDays[completeMonth];
	}

}
