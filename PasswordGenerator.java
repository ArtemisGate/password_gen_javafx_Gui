package passGenerator;



/**
 * Program generate password after prompting user for length. Password contains
 * one special character, one uppercase, one lowercase, and one digit. After
 * checking password validality, save password to text file
 *
 */
public class PasswordGenerator {
	
	public static int PASS_LENGTH = 0;
	private static boolean hasUpperChar = false;
	private static boolean hasLowerChar = false;
	private static boolean hasDigit = false;
	private static String SPECIAL_CHAR = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
	private static int SPECIAL_CHAR_LENGTH = SPECIAL_CHAR.length();

	public static String main(String pass_length) {

		
		
		

		try {
			PASS_LENGTH = Integer.parseInt(pass_length);
		} catch (Exception e) {
			return "Error, enter a length";
		}
		
		if (PASS_LENGTH < 7) {
			return "Error password too short";

		}
		
		
		

		String password = "", alph = "";

		int isDigit = 0, toLower = 0, randomIndex = RandomGen.getRandomNumberInRange(0, PASS_LENGTH),
				randomSpcharIndex = RandomGen.getRandomNumberInRange(0, SPECIAL_CHAR_LENGTH - 1);
		char charValue = '0', spec_Char = '.';

		// Get Random Special Character
		spec_Char = SPECIAL_CHAR.charAt(randomSpcharIndex);

		do {

			// Check if password length is valid

			// Generate Password
			for (int i = 0; i < PASS_LENGTH; i++) {

				// Check index for location for special Character
				if (i == randomIndex) {
					password += spec_Char;
					continue;
				}

				// Randomly generate a digit or a character
				isDigit = RandomGen.getRandomNumberInRange(0, 1);

				// Check if Digit flag is true
				if (isDigit == 1) {
					// Generate digit and add to string
					password += Integer.toString(generateNums());

				} else {
					// Flag to decide if character should be lowercase
					toLower = RandomGen.getRandomNumberInRange(0, 1);

					// Generate Character
					charValue = (char) generateAlph();

					// Add character to alph string
					alph += charValue;

					// Convert Uppercase to Lowercase if flag is true
					if (toLower == 1) {
						alph = alph.toLowerCase();
					}

					// Add alph string to password
					password += alph;

					// reset alph string to empty
					alph = "";

				}

			} // End of for loop

			// Check if password has one digit, one uppercase, one lowercase
			checkPassword(password);

		} while (!(hasUpperChar && hasLowerChar && hasDigit)); // Continue generating password til password is valid

		return password;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	// Generate a character from the range of A to Z
	private static int generateAlph() {
		int Alphmin = 'A', Alphmax = 'Z';

		return RandomGen.getRandomNumberInRange(Alphmin, Alphmax);

	} // End of GenerateAlph

	// Generate a number from 0 to 9
	private static int generateNums() {
		int min = 0, max = 9;

		return RandomGen.getRandomNumberInRange(min, max);

	} // End of generateNums

	// Check password is valid or not
	private static void checkPassword(String password) {
		// Check each character in password for a digit and alphabetic
		for (int i = 0; i < PASS_LENGTH; i++) {

			if (Character.isDigit(password.charAt(i))) {
				hasDigit = true;
			}
			if (Character.isUpperCase(password.charAt(i))) {
				hasUpperChar = true;
			}
			if (Character.isLowerCase(password.charAt(i))) {
				hasLowerChar = true;
			}

		} // End of checkpassword

	}

} // End of Password Generator Class
