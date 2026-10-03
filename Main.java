public class Main{
	private static PasswordGenerator gen;
	private static Strength str;
	public static void main(String[] args) {
		try {
			gen = new PasswordGenerator(2,1,0,1,0);
		} catch (Exception e){
			e.printStackTrace();
		}

		String password = gen.generatePassword();
		System.out.println(password);
		Strength str = new Strength(password);
		String strength = str.evalStrength();
		System.out.println(strength);
	}
}