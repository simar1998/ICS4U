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
		ContestantInformation contestant2 = new ContestantInformation();
		ArrayList <ContestantInformation> contestants = new ArrayList();
		int contestantNum = 0;
		Scanner scannerInput = new Scanner(System.in);
		String inp = scannerInput.nextLine();
		for(int i = 0; i <= contestantNum; i++){
			switch(inp){
			case "add" :
				storeValues(contestant1);
			}
		}
		storeValues(contestant1);
		 		
		}
	public static void storeValues(ContestantInformation ci) throws IllegalAccessException,
	IllegalArgumentException, NoSuchMethodException, SecurityException, ClassNotFoundException{
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
				try{
				System.out.println(questions[i]);
				String scannerInput = scanner.nextLine();
				classContestantInfo.getDeclaredMethod(methods[i], stringParameter).invoke(ci, scannerInput);
				flag = false;
				if(scannerInput.equals("exit this")){
					System.out.println("Thank you for using reality show application form");
					return;
				}
				}	catch(InvocationTargetException e){
					 if(e.getCause() instanceof InvalidInputExeption){
						 System.out.println(e.getCause().getMessage());
					 }
				}
			}
			 while (flag);
			}
	}
	

	}

