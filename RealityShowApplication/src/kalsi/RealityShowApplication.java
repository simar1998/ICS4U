/**
 * 
 */
package kalsi;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
		int contestantNum = 0;
		Scanner scannerInput = new Scanner(System.in);
		for (int i = 0; i <= contestantNum; i++) {
			help();
			pl(i+"");
			String inp = scannerInput.nextLine();
			contestantNum = contestants.size() -1;
		
			if(inp.equals("add new")){
				contestants.add(contestant1);
				storeValues(contestants.get(i));
			}

			if(inp.equals("get last")){
				printContestant(contestants.get(i));
			}

			if(inp.equals("get contestant")){
				printContestant(contestants);
			}

			if(inp.equals("help")){
				help();
			}
			}
		
	}

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

	public static void printContestant(ContestantInformation ci) {
		LabelClass label = new LabelClass(ci);
		System.out.print(label.toString());
	}

	public static void printContestant(ArrayList<ContestantInformation> c) {
		pl("What contestant would you like to get the info of");
		Scanner scanner = new Scanner(System.in);
		int i = Integer.parseInt(scanner.nextLine());
		LabelClass label = new LabelClass(c.get(i));
		System.out.print(label.toString());
	}

	public static void help() {
		pl("REALITY SHOW APPLICATION HELP");
		pl("Type (add new) to add new contestant");
		pl("Type (get last) to get the last stored contestant's information");
		pl("type (get contestant) hit enter then type the number id of the contestant to retrive the contestant info");
		pl("type (exit this) to exit");

	}

	public static void pl(String s) {
		System.out.println(s);
	}

}
