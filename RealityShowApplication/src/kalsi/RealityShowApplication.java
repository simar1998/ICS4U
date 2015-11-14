/**

 * 
 */
package kalsi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, ClassNotFoundException, InstantiationException, FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		ContestantInformation contestant1 = new ContestantInformation();
		ArrayList<ContestantInformation> contestants = new ArrayList<ContestantInformation>();
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
				printContestant(contestants.get(contestants.size() - 1));
			}

			if (inp.equals("3")) {
				printContestant(contestants);
			}

			if (inp.equals("4")) {
			Collections.sort(contestants);
			pl("Sorted succesfully");
			}
			if (inp.equals("5")){
				deleteContestant(contestants);
			}
			if(inp.equals("6")){
				saveFile(contestants);
			}
			if(inp.equals("7")){
				loadFile(contestants);
			}
			if(inp.equals("8")){
				System.exit(0);
			}
			
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
	 * @param ci
	 * @return
	 */
	public static String printContestant1(ContestantInformation ci) {
		LabelClass label = new LabelClass(ci);
		return label.toString();
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
	/**
	 * 
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
		pl("type ( 8 ) to exit");
	}
	/**
	 * 
	 * @param s
	 */
	public static void pl(String s) {
		System.out.println(s);
	}

	/**
	 * 
	 * @param ci
	 * @param firstName
	 * @param lastName
	 */
	public static void search(ArrayList<ContestantInformation> ci,  String firstName , String lastName) {
		Scanner scanner = new Scanner(System.in);
		pl("first name for search parameter");
		firstName = scanner.nextLine();
		pl("last name for search parameter");
		lastName = scanner.nextLine();
		if(search.linearSearch(ci, firstName, lastName)!= -1){
			pl("Contestant Found here is the information");
			pl("******************************************");
			LabelClass label = new LabelClass(ci.get(search.linearSearch(ci, firstName, lastName)));
			pl(label.toString());
		}
	}
	/**
	 * 
	 * @param contestants
	 */
	public static void loadFile(ArrayList<ContestantInformation> contestants){
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
			String firstNameFromSave = null ;
			String lastNameFromSave = null;
			String streetNumberFromSave = null;
			String streetAdressFromSave = null;
			String cityFromSave= null;
			String porvinceFromSave= null;
			String postalCodeFromSave= null;
			String phoneNumberFromSave= null;
			try {
				firstNameFromSave = bufferedReader.readLine();
				lastNameFromSave = bufferedReader.readLine();
				streetNumberFromSave = bufferedReader.readLine();
				streetAdressFromSave = bufferedReader.readLine();
				cityFromSave = bufferedReader.readLine();
				porvinceFromSave = bufferedReader.readLine();
				postalCodeFromSave = bufferedReader.readLine();
				phoneNumberFromSave = bufferedReader.readLine();
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
			} catch (InvalidInputExeption e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}	
		
	}
	/**
	 * 
	 * @param contestants
	 */
	public static void saveFile(ArrayList<ContestantInformation> contestants){
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
			String firstNameFromSave = null ;
			String lastNameFromSave = null;
			String streetNumberFromSave = null;
			String streetAdressFromSave = null;
			String cityFromSave= null;
			String porvinceFromSave= null;
			String postalCodeFromSave= null;
			String phoneNumberFromSave= null;
			try {
				firstNameFromSave = bufferedReader.readLine();
				lastNameFromSave = bufferedReader.readLine();
				streetNumberFromSave = bufferedReader.readLine();
				streetAdressFromSave = bufferedReader.readLine();
				cityFromSave = bufferedReader.readLine();
				porvinceFromSave = bufferedReader.readLine();
				postalCodeFromSave = bufferedReader.readLine();
				phoneNumberFromSave = bufferedReader.readLine();
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
			} catch (InvalidInputExeption e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}	
	}
	/**
	 * 
	 * @param ci
	 */
	public static void deleteContestant(ArrayList<ContestantInformation> ci){
		Scanner scanner = new Scanner(System.in);
		pl("First name of contestant you want to delete");
		String firstName = scanner.nextLine();
		pl("Last name of the contestant you want to sort");
		String lastName = scanner.nextLine();
		pl("Are you sure you want to delete this contestant (y/n)");
		String confirm = scanner.nextLine();
		if(confirm.equalsIgnoreCase("y")){
			delete(ci,search.linearSearch(ci, firstName, lastName));
			pl("Contestant has been deleted");
		}
		else if(confirm.equalsIgnoreCase("n")){
			pl("Canceling delete");
			return;
		}
	}
	/**
	 * 
	 * @param ci
	 * @param index
	 */
	public static void delete(ArrayList<ContestantInformation> ci , int index){
		ci.remove(index);
	}
	
	
}
