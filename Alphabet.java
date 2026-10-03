public class Alphabet{
	final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	final int LOWER_RANGE = LOWERCASE.length();
	final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final int UPPER_RANGE = LOWER_RANGE + UPPERCASE.length();
	final String SPECIAL = "!@'#~`¬$%^&*_+="; // can add more if necessary
	final int SPECIAL_RANGE = UPPER_RANGE + SPECIAL.length();
	final String DIGITS = "0123456789";
	final int DIGITS_RANGE = SPECIAL_RANGE + DIGITS.length();
}