/**

 * 
 */
package kalsi;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class is used to sexecut the console application
 *
 */
public class RealityShowApplication {

	/**
	 * 
	 */
	static ArrayList<ContestantInformation> contestants = new ArrayList<ContestantInformation>();

	public RealityShowApplication() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException,
			InstantiationException, FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		int contestantNum = 0;
		@SuppressWarnings("resource")
		Scanner scannerInput = new Scanner(System.in);
		for (int i = 0; i <= contestantNum; i++) {
			help();
			String inp = scannerInput.nextLine();
			contestantNum = contestantNum + 1;
			if (inp.equals("1")) {
				storeValues(new ContestantInformation());

			}

			if (inp.equals("2")) {
				printContestant(contestants.get(contestants.size() - 1));
			}

			if (inp.equals("3")) {
				search(contestants);
			}

			if (inp.equals("4")) {
				Collections.sort(contestants);
				pl("Sorted succesfully");
				printAll(contestants);
			}
			if (inp.equals("5")) {
				deleteContestant(contestants);
			}
			if (inp.equals("6")) {
				saveFile(contestants);
			}
			if (inp.equals("7")) {
				loadFile(contestants);
			}
			if (inp.equals("8")) {
				printAll(contestants);
			}
			if (inp.equals("9")) {
				return;
			}

		}
	}

	/**
	 * Method adds new contestant to the arraylist
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
		boolean flag = false;
		@SuppressWarnings("resource")
		Scanner Scanner = new Scanner(System.in);

		do {
			try {
				flag = false;
				System.out.println("What is your first name");
				String firstName = Scanner.nextLine();

				ci.setFirstName(firstName);

			} catch (InvalidInputExeption e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		} while (flag);

		do {
			try {
				flag = false;
				System.out.println("What is your last name.");
				String lastName = Scanner.nextLine();

				ci.setLastName(lastName);

			} catch (InvalidInputExeption e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		} while (flag);
		do {
			try {
				flag = false;
				System.out.println("What is your your street name.");
				String streetAddress = Scanner.nextLine();

				ci.setStreetName(streetAddress);

			} catch (InvalidInputExeption e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		} while (flag);
		do {
			try {
				flag = false;
				System.out.println("What is your your street number.");
				String streetNumber = Scanner.nextLine();

				ci.setStreetNumber(streetNumber);

			} catch (InvalidInputExeption e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		} while (flag);

		do {
			try {
				flag = false;

				System.out.println("What city do you live in");
				String city = Scanner.nextLine();

				ci.setCity(city);

			} catch (InvalidInputExeption e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		} while (flag);

		do {
			try {
				flag = false;
				System.out.println("What province are you in");
				String province = Scanner.nextLine();

				ci.setProvince(province);

			} catch (InvalidInputExeption e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		} while (flag);

		do {
			try {
				flag = false;
				System.out.println("What is your postal code");
				String postalCode = Scanner.nextLine();

				ci.setPostalCode(postalCode);

			} catch (InvalidInputExeption e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		} while (flag);

		do {
			try {
				flag = false;

				System.out.println("What is your phone no.");
				String phoneNumber = Scanner.nextLine();

				ci.setPhoneNum(phoneNumber);

			} catch (InvalidInputExeption e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		} while (flag);
		do {
			try {
				flag = false;
				System.out.println("What is your birth date yyyy/mm/dd");
				String birthDate = Scanner.nextLine().trim();

				ci.setBirthDate(birthDate);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				flag = true;
			}
		} while (flag);
		contestants.add(ci);

	}

	/**
	 * Prints the contestant object given
	 * 
	 * @param ci
	 */
	public static void printContestant(ContestantInformation ci) {
		LabelClass label = new LabelClass(ci);
		System.out.print(label.toString());
	}

	/**
	 * Prints the console options
	 */
	public static void help() {
		pl("REALITY SHOW APPLICATION HELP");
		pl("Type ( 1 ) to add new contestant");
		pl("Type ( 2 ) to get the last stored contestant's information");
		pl("Type ( 3 ) hit enter then type the contestant firstname and lastname");
		pl("Type ( 4 ) to sort the contestant information");
		pl("Type ( 5 ) to delete a contestant. After hitting 4 type the first name and last name of the contestant");
		pl("Type ( 6 ) to save the contestant list to a text file");
		pl("Type ( 7 ) to load from the save file");
		pl("Type ( 8 ) to print all contestants");
		pl("type ( 9 ) to exit");
	}

	/**
	 * Cause im lazy
	 * 
	 * @param s
	 */
	public static void pl(String s) {
		System.out.println(s);
	}

	/**
	 * searches and then prints contestants based on first and last name
	 * 
	 * @param ci
	 * @param firstName
	 * @param lastName
	 */
	public static void search(ArrayList<ContestantInformation> ci) {
		String firstName, lastName;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		pl("first name for search parameter");
		firstName = scanner.nextLine();
		pl("last name for search parameter");
		lastName = scanner.nextLine();
		if (search.linearSearch(ci, firstName, lastName) != -1) {
			pl("Contestant Found, here is the information");
			pl("******************************************");
			LabelClass label = new LabelClass(ci.get(search.linearSearch(ci, firstName, lastName)));
			pl(label.toString());
		}
	}

	/**
	 * loads from file and stores into arraylist
	 * 
	 * @param contestants
	 */
	public static void loadFile(ArrayList<ContestantInformation> contestants) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("saveFile.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int contestantNumbers = 0;
		try {
			contestantNumbers = Integer.parseInt(bufferedReader.readLine());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int k = 0; k < contestantNumbers; k++) {
			contestants.add(new ContestantInformation());
			String firstNameFromSave = null;
			String lastNameFromSave = null;
			String streetNumberFromSave = null;
			String streetAdressFromSave = null;
			String cityFromSave = null;
			String porvinceFromSave = null;
			String postalCodeFromSave = null;
			String phoneNumberFromSave = null;
			String birthDateFromSave = null;
			try {
				firstNameFromSave = bufferedReader.readLine();
				lastNameFromSave = bufferedReader.readLine();
				streetNumberFromSave = bufferedReader.readLine();
				streetAdressFromSave = bufferedReader.readLine();
				cityFromSave = bufferedReader.readLine();
				porvinceFromSave = bufferedReader.readLine();
				postalCodeFromSave = bufferedReader.readLine();
				phoneNumberFromSave = bufferedReader.readLine();
				birthDateFromSave = bufferedReader.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				contestants.get(k).setFirstName(firstNameFromSave);
				contestants.get(k).setLastName(lastNameFromSave);
				contestants.get(k).setStreetNumber(streetNumberFromSave);
				contestants.get(k).setStreetName(streetAdressFromSave);
				contestants.get(k).setCity(cityFromSave);
				contestants.get(k).setProvince(porvinceFromSave);
				contestants.get(k).setPostalCode(postalCodeFromSave);
				contestants.get(k).setPhoneNum(phoneNumberFromSave);
				contestants.get(k).setBirthDate(birthDateFromSave);
			} catch (InvalidInputExeption e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (contestants.size() > 0) {
			pl("load succesfull");
		} else {
			pl("No information on file");
		}
	}

	/**
	 * Saves onto the file
	 * 
	 * @param contestants
	 * @throws FileNotFoundException
	 */
	public static void saveFile(ArrayList<ContestantInformation> contestants) throws FileNotFoundException {
		FileOutputStream saveFile = new FileOutputStream("saveFile.txt");
		@SuppressWarnings("resource")
		PrintStream fps = new PrintStream(saveFile);
		fps.println(contestants.size());
		for (int i = 0; i < contestants.size(); i++) {
			fps.println(contestants.get(i).getFirstName());
			fps.println(contestants.get(i).getLastName());
			fps.println(contestants.get(i).getStreetNumber());
			fps.println(contestants.get(i).getStreetName());
			fps.println(contestants.get(i).getCity());
			fps.println(contestants.get(i).getProvince());
			fps.println(contestants.get(i).getPostalCode());
			fps.println(contestants.get(i).getPhoneNum());
			fps.println(contestants.get(i).getBirthDate());
		}
		pl("save succesfull");
	}

	/**
	 * Searches and delets a contestant
	 * 
	 * @param ci
	 */
	public static void deleteContestant(ArrayList<ContestantInformation> ci) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		pl("First name of contestant you want to delete");
		String firstName = scanner.nextLine();
		pl("Last name of the contestant you want to sort");
		String lastName = scanner.nextLine();
		pl("Are you sure you want to delete this contestant (y/n)");
		String confirm = scanner.nextLine();
		if (confirm.equalsIgnoreCase("y")) {
			delete(ci, search.linearSearch(ci, firstName, lastName));
			pl("Contestant has been deleted");
		} else if (confirm.equalsIgnoreCase("n")) {
			pl("Canceling delete");
			return;
		}
	}

	/**
	 * Delets contests object
	 * 
	 * @param ci
	 * @param index
	 */
	public static void delete(ArrayList<ContestantInformation> ci, int index) {
		ci.remove(index);
	}

	/**
	 * prints all the contestant objects
	 * 
	 * @param ci
	 */
	public static void printAll(ArrayList<ContestantInformation> ci) {
		for (int i = 0; i < ci.size(); i++) {
			pl("***********************************************************");
			pl(" Contestant number " + i);
			LabelClass label = new LabelClass(ci.get(i));
			System.out.print(label.toString());
		}
		pl("***********************************************************");
	}
}
