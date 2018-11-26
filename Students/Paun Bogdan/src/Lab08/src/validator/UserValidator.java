package validator;
import java.util.*;

import exceptions.UserValidationFailedException;

public class UserValidator {

	private final int CNP_LENGTH = 13;
	private final String CONTROL_SEQ = "279146358279";

	private boolean isLeapYear(String AA) {
		int an = Integer.parseInt(AA);

		if ((an % 4 == 0 && an % 100 != 0) || an % 400 == 0) {
			return true;
		}
		return false;
	}

	private int getControlDigit(String CNP) {

		int sum = 0;

		for (int i = 0; i < CNP_LENGTH - 1; i++) {
			sum += Integer.parseInt(CNP.substring(i, i + 1)) * Integer.parseInt(CONTROL_SEQ.substring(i, i + 1));
		}

		sum %= 11;

		if (sum == 10) {
			return 1;
		}

		return sum;
	}

	public void validate(User user) throws UserValidationFailedException {
		// CNP - 13 caractere
		// S - sexul
		// AA - anul nasterii
		// LL - luna nasterii
		// ZZ - ziua nasterii
		// JJ - judetul nasterii
		// NNN - numarul de ordine
		// C - cifra control

		String cnp = user.getCNP();

		int S = Integer.parseInt(cnp.substring(0, 1));
		int AA = Integer.parseInt(cnp.substring(1, 3));
		int LL = Integer.parseInt(cnp.substring(3, 5));
		int ZZ = Integer.parseInt(cnp.substring(5, 7));
		int JJ = Integer.parseInt(cnp.substring(7, 9));
		int NNN = Integer.parseInt(cnp.substring(9, 12));
		int C = Integer.parseInt(cnp.substring(12, 13));

		if (LL < 1 || LL > 12) {
			throw new UserValidationFailedException("Error: Luna nasterii este incorecta!");
		}

		if (AA < 0 || AA > 99) {
			throw new UserValidationFailedException("Error: Anul nasterii este incorect!");
		}

		if (JJ < 1 || JJ > 52) {
			throw new UserValidationFailedException("Error: Judet inexistent!");
		}

		if (S < 1 || S > 8) {
			throw new UserValidationFailedException("Error: Prima cifra este incorecta!");
		}

		if (NNN < 1 || NNN > 999) {
			throw new UserValidationFailedException("Error: Numar de ordine inexistent!");
		}

		if ((S == 5 || S == 6) && AA > Calendar.getInstance().get(Calendar.YEAR) - 2000) {
			throw new UserValidationFailedException("Anul nasterii este invalid!");
		}

		if ((S == 3 || S == 4 || S == 7 || S == 8) && LL == 2) {
			if (isLeapYear(Integer.toString(AA + 1800))) {
				if (ZZ > 29) {
					throw new UserValidationFailedException("Error: Data nasterii este incorecta!");
				}
			} else {
				if (ZZ > 28) {
					throw new UserValidationFailedException("Error: Data nasterii este incorecta!");
				}
			}
		} else {
			if ((S == 1 || S == 2) && LL == 2) {
				if (isLeapYear(Integer.toString(AA + 1900))) {
					if (ZZ > 29) {
						throw new UserValidationFailedException("Error: Data nasterii este incorecta!");
					}
				} else {
					if (ZZ > 28) {
						throw new UserValidationFailedException("Error: Data nasterii este incorecta!");
					}
				}
			} else {
				if ((S == 5 || S == 6 || S == 7 || S == 8) && LL == 2) {
					if (isLeapYear(Integer.toString(AA + 2000))) {
						if (ZZ > 29) {
							throw new UserValidationFailedException("Error: Data nasterii este incorecta!");
						}
					} else {
						if (ZZ > 28) {
							throw new UserValidationFailedException("Error: Data nasterii este incorecta!");
						}
					}
				}
			}
		}

		if (C != getControlDigit(cnp)) {
			throw new UserValidationFailedException("Error: Cifra de control este incorecta!");
		}
		
//		System.out.println("CNP = \t" + S + " " + AA + " " + LL + " " + ZZ + " " + JJ + " " + NNN + " " + C);
	}

	public void getCnpDetails(User user) {
		String cnp = user.getCNP();

		int S = Integer.parseInt(cnp.substring(0, 1));
		int AA = Integer.parseInt(cnp.substring(1, 3));
		int LL = Integer.parseInt(cnp.substring(3, 5));
		String ZZ = cnp.substring(5, 7);
		int JJ = Integer.parseInt(cnp.substring(7, 9));
		String NNN = cnp.substring(9, 12);
		
		if(S == 1 || S == 2) {
			AA += 1900;
		}else {
			if(S == 5 || S == 6) {
				AA += 2000;
			}else {
				AA += 1800;
			}
		}	
		
		List<String> judete = new ArrayList<>(
			Arrays.asList(null, "Alba", "Arad", "Arges", "Bacau", "Bihor", "Bistrita-Nasaud", "Botosani", "Brasov", "Braila",
					"Buzau", "Caras-Severing", "Cluj", "Constanta", "Covasna", "Dambovita", "Dolj", "Galati", "Gorj",
					"Harghita", "Hunedoara", "Ialomita", "Iasi", "Ilfov", "Maramures", "Mehedinti", "Mures", "Neamt", "Olt",
					"Prahova", "Satu Mare", "Salaj", "Sibiu", "Suceava", "Teleorman", "Timis", "Tulcea", "Vaslui", "Valcea",
					"Vrancea", "Bucuresti", "Bucuresti - Sector 1", "Bucuresti - Sector 2", "Bucuresti - Sector 3",
					"Bucuresti - Sector 4", "Bucuresti - Sector 5", "Bucuresti - Sector 6", "Calarasi", "Giurgiu")
		);
		
		List<String> luni = new ArrayList<>(
				Arrays.asList(null, "ianuarie", "februarie", "martie", "aprilie", "mai", "iunie", "iulie", "august", "septembrie",
						"octombrie", "noiembrie", "decembrie")
		);
		
		System.out.println("Informatii despre CNP");
		System.out.println("======================");
		System.out.println("Data nasterii: " + ZZ + " " + luni.get(LL) + " " + AA);
		System.out.println("Sex: " + (S % 2 == 0 ? "Feminin" : "Masculin"));
		System.out.println("Varsta: " + (Calendar.getInstance().get(Calendar.YEAR) - AA) + " ani");
		System.out.println("Judet: " + judete.get(JJ));
		System.out.println("Numar registru: " + NNN);

	}

}
