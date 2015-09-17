package kalsi;
import java.util.Scanner;
public class Greetings2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your first name");
		String firstName = scan.nextLine();
		System.out.println("Enter your last name");
		String lastName = scan.nextLine();
		System.out.println("Hello "+ firstName+" "+lastName);
		System.out.println("Welcome to java");
		scan.close();
		
	}

}
