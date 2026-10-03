public class Strength{
	private boolean hasUpper;
	private boolean hasLower;
	private boolean hasSpecial;
	private boolean hasDigits;
	private String password;
	private int length;
	private StrengthCategory finalStrength;
	private Alphabet alphabet;

	public Strength(String password){
		this.password = password;
		this.hasUpper = false;
		this.hasLower = false;
		this.hasSpecial = false;
		this.hasDigits = false;
		this.alphabet = new Alphabet();
	}

	public String evalStrength(){
		int count = 0;
		while (count < this.password.length()){
			if (this.hasLower && this.hasUpper && this.hasSpecial && this.hasDigits){
				break;
			}

			if (!this.hasLower && this.alphabet.LOWERCASE.contains(Character.toString(this.password.charAt(count)))){
				this.hasLower = true;
			} else if (!this.hasUpper && this.alphabet.UPPERCASE.contains(Character.toString(this.password.charAt(count)))){
				this.hasUpper = true;
			} else if (!this.hasSpecial && this.alphabet.SPECIAL.contains(Character.toString(this.password.charAt(count)))){
				this.hasSpecial = true;
			} else if (!this.hasDigits && this.alphabet.DIGITS.contains(Character.toString(this.password.charAt(count)))){
				this.hasDigits = true;
			}

			count++;
		}

		return this.getStrength().toString();
	}

	private StrengthCategory getStrength(){
		if (this.hasUpper && this.hasLower && this.hasDigits && this.hasSpecial && this.length > 8){
			return StrengthCategory.UNBREAKABLE;
		} else if ((this.hasUpper && this.hasLower && this.hasSpecial) || (this.hasLower && this.hasUpper && this.hasDigits) && this.length > 8){
			return StrengthCategory.STRONG;
		} else if ((this.hasSpecial || this.hasDigits) && (this.hasUpper || this.hasLower) && this.length > 8){
			return StrengthCategory.INTERMEDIATE;
		} else {
			return StrengthCategory.WEAK;
		}
	}

}

enum StrengthCategory{
	WEAK,
	INTERMEDIATE,
	STRONG,
	UNBREAKABLE
}