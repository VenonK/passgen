import java.util.Random;

public class PasswordGenerator{
	private final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private final int LOWER_RANGE = LOWERCASE.length();
	private final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final int UPPER_RANGE = LOWER_RANGE + UPPERCASE.length();
	private final String SPECIAL = "!@'#~`¬$%^&*_+="; // can add more if necessary
	private final int SPECIAL_RANGE = UPPER_RANGE + SPECIAL.length();
	private final String DIGITS = "0123456789";
	private final int DIGITS_RANGE = SPECIAL_RANGE + DIGITS.length();
	private Random generator = new Random();

	private final int NUMOFLOWER;
	private final int NUMOFUPPER;
	private final int NUMOFSPECIAL;
	private final int NUMOFDIGITS;
	private final int NUMOFCHARS;

	public PasswordGenerator(int chars, int lower, int upper, int special, int digits) throws PasswordException{ // these numbers are supposed to be the required number for the generation
		if (lower < -1 || upper < -1 || special < -1 || digits < -1){
			throw new PasswordException("All fields must be positive or 0"); // change with a relevant exception
		}

		if (chars != (lower+upper+special+digits)){
			throw new PasswordException("The length of password has to be the same as its constituent parts");
		}

		this.NUMOFLOWER = lower;
		this.NUMOFUPPER = upper;
		this.NUMOFDIGITS = digits;
		this.NUMOFSPECIAL = special;
		this.NUMOFCHARS = chars;
	}

	public String generatePassword(){
		String returnString = "";
		int digitsTracker = 0;
		int upperTracker = 0;
		int lowerTracker = 0;
		int specialTracker = 0;
		while (returnString.length() < this.NUMOFCHARS){
			int selectedChar = this.generator.nextInt(this.DIGITS_RANGE+1); // +1 since exclusive
			if (lowerTracker < this.NUMOFLOWER && selectedChar < this.LOWER_RANGE){
				returnString += this.LOWERCASE.charAt(selectedChar);
				lowerTracker++;
			} else if (upperTracker < this.NUMOFUPPER && selectedChar < this.UPPER_RANGE && selectedChar > this.LOWER_RANGE){
				returnString += this.UPPERCASE.charAt(this.UPPER_RANGE - selectedChar);
				upperTracker++;
			} else if (specialTracker < this.NUMOFSPECIAL && selectedChar < this.SPECIAL_RANGE && selectedChar > this.UPPER_RANGE) {
				returnString += this.SPECIAL.charAt(this.SPECIAL_RANGE - selectedChar);
				specialTracker++;
			} else if (digitsTracker < this.NUMOFDIGITS && selectedChar < this.DIGITS_RANGE && selectedChar > this.SPECIAL_RANGE){
				returnString += this.DIGITS.charAt(this.DIGITS_RANGE - selectedChar);
				digitsTracker++;
			}

		}

		return returnString;
	}
}

class PasswordException extends Exception{
	public PasswordException(String message){
		super(message);
	}
}