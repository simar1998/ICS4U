/**

 * 
 */
package kalsi;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author 334915576
 *
 */
public class RealityShowApplication {

	/**
	 * 
	 */
	public RealityShowApplication() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, ClassNotFoundException, InstantiationException {
		// TODO Auto-generated method stub
		ContestantInformation contestant1 = new ContestantInformation();
		ArrayList<ContestantInformation> contestants = new ArrayList();
		ArrayList<ContestantInformation> sortedContestant = contestants;
		//Collections.sort(sortedContestant);
		int contestantNum = 0;
		Scanner scannerInput = new Scanner(System.in);
		for (int i = 0; i <= contestantNum; i++) {
			help();
			String inp = scannerInput.nextLine();
			if (inp.equals("1")) {
				contestants.add(contestant1);
				storeValues(contestants.get(i));
			}

			if (inp.equals("2")) {
				printContestant(contestants.get(i - 1));
			}

			if (inp.equals("3")) {
				printContestant(contestants);
			}

			if (inp.equals("4")) {
				help();
			}
			contestantNum = contestants.size();
		}
	}

	/**
	 * 
	 * @param ci
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws Secu`rityException
	 * @throws ClassNotFoundException
	 */
	public static void storeValues(ContestantInformation ci) throws IllegalAccessException, IllegalArgumentException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		String[] questions = { "What is your first name", "What is your last name", "What is your Street Name",
				"What is your Sreet Number", "What city do you live in", "What province are you in",
				"What is your postal code", "What is your phone no.", "What is your birth date yyyy/mm/dd" };
		String[] methods = { "setFirstName", "setLastName", "setStreetName", "setStreetNumber", "setCity",
				"setProvince", "setPostalCode", "setPhoneNum", "setBirthDate" };

		Class<?> classContestantInfo = Class.forName("kalsi.ContestantInformation");
		Class<String> stringParameter = String.class;
		Class<Integer> integerParameter = Integer.class;
		boolean flag = true;
		for (int i = 0; i < methods.length; i++) {
			flag = true;
			do {
				try {
					System.out.println(questions[i]);
					String scannerInput = scanner.nextLine();
					classContestantInfo.getDeclaredMethod(methods[i], stringParameter).invoke(ci, scannerInput);
					flag = false;
					if (scannerInput.equals("exit this")) {
						pl("Thank you for using reality show application form");
						return;
					}
				} catch (InvocationTargetException e) {
					if (e.getCause() instanceof InvalidInputExeption) {
						System.out.println(e.getCause().getMessage());
					}
				}
			} while (flag);
		}
	}

	/**
	 * 
	 * @param ci
	 */
	public static void printContestant(ContestantInformation ci) {
		LabelClass label = new LabelClass(ci);
		System.out.print(label.toString());
	}

	/**
	 * 
	 * @param c
	 */
	public static void printContestant(ArrayList<ContestantInformation> c) {
		pl("What contestant would you like to get the info of");
		Scanner scanner = new Scanner(System.in);
		int i = Integer.parseInt(scanner.nextLine());
		LabelClass label = new LabelClass(c.get(i));
		System.out.print(label.toString());
	}

	public static void help() {
		pl("REALITY SHOW APPLICATION HELP");
		pl("Type ( 1 ) to add new contestant");
		pl("Type ( 2 ) to get the last stored contestant's information");
		pl("Type ( 3 ) hit enter then either type the contestant number or the contestant firstname and lastname");
		pl("Example after hitting 4 you put the first name followed by a space then last name");
		pl("type ( 4 ) to exit");
	}

	public static void pl(String s) {
		System.out.println(s);
	}

	public static void search(ArrayList<ContestantInformation> ci,  String firstName , String lastName) {
		Scanner scanner = new Scanner(System.in);
		pl("What is your first name");
		firstName = scanner.nextLine();
		pl("What is your last name");
		lastName = scanner.nextLine();
		if(search.linearSearch(ci, firstName, lastName)== 0){
			
		}
	}

}
