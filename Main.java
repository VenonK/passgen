import java.util.Scanner;


public class Main{
	private static PasswordGenerator gen;
	public static void main(String[] args) {
		//Scanner input = new Scanner(System.in);
		//String length = Scanner.nextLine("What is the length of the word you wish to generate");
		try {
			gen = new PasswordGenerator(40,35,3,1,1);
		} catch (Exception e){
			e.printStackTrace();
		}

		System.out.println(gen.generatePassword());
	}
}