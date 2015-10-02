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
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
	NoSuchMethodException, SecurityException, InvalidInputExeption, ClassNotFoundException, InstantiationException {
		// TODO Auto-generated method stub
		ContestantInformation contestant1 = new ContestantInformation();
		ContestantInformation contestant2 = new ContestantInformation();
		Scanner scanner = new Scanner(System.in);
		String[] questions = { "What is your first name", "What is your last name",
				"What is your Street Name" , "What is your Sreet Number", "What city do you live in",
				"What province are you in", "What is your postal code", "What is your phone no.",
				"What is your birth date yyyy/mm/dd" };
		String[] methods = {"setFirstName","setLastName","setStreetName",
				"setStreetNumber","setCity","setProvince","setPostalCode","setPhoneNum",
				"setBirthDate"};

		Class<?> classContestantInfo = Class.forName("kalsi.ContestantInformation");
		Object objectCI = classContestantInfo.newInstance();
		Class<String> parameters = String.class;
		boolean flag = true;
		for(int i = 0; i <methods.length;i++){
			do{
				flag = false;
				System.out.println(questions[i]);
				String scannerInput = scanner.nextLine();
				classContestantInfo.getDeclaredMethod(methods[i],parameters).invoke(contestant1, scannerInput);
				}
			while(flag);
		}
		
		
		}
	
	}


