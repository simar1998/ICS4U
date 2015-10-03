/**
 * class, ContestantInformation, to hold the information of each contestant. 
 * It should have fields for first name, last name, street address (street number 
 * and street name), city, province, postal code, phone number and birth date. Use 
 * the String class to ensure the input is stored in the same format.
 * 
 * @author Simar Pal Kalsi
 * 
 */
package kalsi;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ContestantInformation {
	private String firstName, lastName, city, province, postalCode, streetName, streetNumber, phoneNum, birthDateString;
	private Calendar birthDate = new GregorianCalendar();

	public enum Province {
		on, bc, pe, ab, mb, nb, bl, ns, nt, qc, sk, yt, Alberta, BritishColumbia, Manitoba, NewBrunswick, NewfoundlandandLabrador, NovaScotia, Ontario, PrinceEdwardIsland, Quebec, Saskatchewan, NorthwestTerritories, Nunavut, Yukon
	}

	Province provinceEnum;
	private char[] newArrays;

	/**
	 * 
	 */
	public ContestantInformation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param string
	 * @param enumClass
	 * @param message
	 * @throws InvalidInputExeption
	 */
	private <E extends Enum<E>> void provinceExistance(String string, Class<E> enumClass, String message)
			throws InvalidInputExeption {
		boolean bool = true;
		for (E e : enumClass.getEnumConstants()) {
			if (!e.name().equalsIgnoreCase(string)) {
				bool = false;
			} else {
				bool = true;
				break;
			}
		}
		if (bool == false) {
			throw new InvalidInputExeption("Not a valid perameter for field " + message);
		}
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param streetNumber
	 * @param streetName
	 * @param city
	 * @param province
	 * @param postalCode
	 * @param phoneNum
	 * @param birthDate
	 */
	public ContestantInformation(String firstName, String lastName, int streetNumber, String streetName, String city,
			String province, String postalCode, int phoneNum, Calendar birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.streetNumber = "" + streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.postalCode = postalCode;
		this.phoneNum = "" + phoneNum;
	}

	/**
	 * 
	 * @param firstName
	 * @throws InvalidInputExeption
	 */
	public void setFirstName(String firstName) throws InvalidInputExeption {
		checkInput(firstName, "Please only enter letter in the first name");
		this.firstName = firstName.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param lastName
	 * @throws InvalidInputExeption
	 */
	public void setLastName(String lastName) throws InvalidInputExeption {
		checkInput(lastName, "Please only enter letter in the last name");
		this.lastName = lastName.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param streetNumber
	 * @throws InvalidInputExeption
	 */
	public void setStreetNumber(String streetNumber) throws InvalidInputExeption {
		checkInput(Integer.parseInt(streetNumber), "Please only enter numbers in the street number");
		this.streetNumber = streetNumber.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @throws InvalidInputExeption
	 * @param streetName
	 */
	public void setStreetName(String streetName) throws InvalidInputExeption {
		checkInput(streetName, "Please only enter letter in the street name name");
		this.streetName = streetName.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param city
	 * @throws InvalidInputExeption
	 */
	public void setCity(String city) throws InvalidInputExeption {
		checkInput(city, "Please only enter letter in the city name");
		this.city = city.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param province
	 * @throws InvalidInputExeption
	 */
	public void setProvince(String province) throws InvalidInputExeption {
		checkInput(province, "Please only put leters in the province name");
		provinceExistance(province, Province.class, "Province");
		this.province = province.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param postalCode
	 * @throws InvalidInputExeption
	 */
	public void setPostalCode(String postalCode) throws InvalidInputExeption {
		if (postalCode.length() > 6) {
			throw new InvalidInputExeption("The postal code given has more that 6 digits");
		} else if (postalCode.length() < 6) {
			throw new InvalidInputExeption("The postal code given has less that 6 digits");
		}
		for (int i = 0; i < 6; i++) {
			i++;
			
			if (!Character.isLetter(postalCode.charAt(i - 1))) {
				throw new InvalidInputExeption("Incorrect Format");
			}
			if (!Character.isDigit(postalCode.charAt(i))) {
				throw new InvalidInputExeption("Incorrect Format");
			}
		}
		this.postalCode = postalCode.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param phoneNum
	 * @throws InvalidInputExeption
	 */
	public void setPhoneNum(String phoneNum) throws InvalidInputExeption {
		checkInput(Integer.parseInt(phoneNum), "Please only enter numbers in the phone number");
		if (!(phoneNum.length() == 9)) {
			throw new InvalidInputExeption("Invalid phone number please enter new one");
		} else if (phoneNum.charAt(0) != '1' && phoneNum.length() > 9) {
			char[] array = phoneNum.toCharArray();
			newArrays = null;
			for (int i = 0; i < array.length; i++) {
				newArrays[i] = array[i + 1];
			}
			phoneNum = newArrays.toString();
		}
		this.phoneNum = phoneNum.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param yyyy
	 * @param mm
	 * @param dd
	 * @throws InvalidInputExeption
	 */
	public void setBirthDate(int yyyy, int mm, int dd) throws InvalidInputExeption {
		String date = yyyy + "" + mm + "" + dd;
		checkInput(Integer.parseInt(date), "Please only enter numbers in the date of birth");
		this.birthDate.set(yyyy, mm - 1, dd);
		this.birthDateString = this.birthDate.toString();
	}

	/**
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * 
	 * @return the street number
	 */
	public String getStreetNumber() {
		return this.streetName;
	}

	/**
	 * 
	 * @return the street name
	 */
	public String getStreetName() {
		return this.streetName;
	}

	/**
	 * 
	 * @return the city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * 
	 * @return the province
	 */
	public String getProvince() {
		return this.province;
	}

	/**
	 * 
	 * @return the Postal Code
	 */
	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 * 
	 * @return the Phone Number
	 */
	public String getPhoneNum() {
		return this.phoneNum;
	}

	/**
	 * 
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return this.birthDateString;
	}

	/**
	 * @return everything
	 */
	public String toString() {
		return ("Name: " + firstName + " " + lastName + " City: " + city + " Province: " + province + " Postal Code: "
				+ postalCode + " Street name: " + streetName + " Street Number: " + streetNumber + " Phone Number"
				+ phoneNum + " Birthdate: " + birthDate);
	}

	public void checkInput(String s, String message) throws InvalidInputExeption {
		char[] array = s.toCharArray();
		for (char c : array) {
			if (!Character.isLetter(c)) {
				throw new InvalidInputExeption(message);
			}
		}
	}

	public void checkInput(int i, String message) throws InvalidInputExeption {
		String s = i + "";
		char[] array = s.toCharArray();
		for (char c : array) {
			if (!Character.isDigit(c)) {
				throw new InvalidInputExeption(message);
			}
		}
	}
}
