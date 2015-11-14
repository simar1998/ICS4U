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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ContestantInformation implements Comparable {
	private String firstName, lastName, city, province, postalCode, streetName, streetNumber, phoneNum, birthDateString;
	private Calendar birthDate = new GregorianCalendar();

	public enum Province {
		on, bc, pe, ab, mb, nb, bl, ns, nt, qc, sk, yt, Alberta, BritishColumbia, Manitoba, NewBrunswick, NewfoundlandandLabrador, NovaScotia, Ontario, PrinceEdwardIsland, Quebec, Saskatchewan, NorthwestTerritories, Nunavut, Yukon
	}

	Province provinceEnum;

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
		checkInput(firstName, "Please only enter letter in the first name", true);
		this.firstName = firstName.toLowerCase();
	}

	/**
	 * 
	 * @param lastName
	 * @throws InvalidInputExeption
	 */
	public void setLastName(String lastName) throws InvalidInputExeption {
		checkInput(lastName, "Please only enter letter in the last name", true);
		this.lastName = lastName.toLowerCase();
	}

	/**
	 * 
	 * @param streetNumber
	 * @throws InvalidInputExeption
	 */
	public void setStreetNumber(String streetNumber) throws InvalidInputExeption {
		checkInput(streetNumber, "Please only enter numbers in the street number", false);
		this.streetNumber = streetNumber.toLowerCase();
	}

	/**
	 * 
	 * @throws InvalidInputExeption
	 * @param streetName
	 */
	public void setStreetName(String streetName) throws InvalidInputExeption {
		checkInput(streetName, "Please only enter letter in the street name name", true);
		this.streetName = streetName.toLowerCase();
	}

	/**
	 * 
	 * @param city
	 * @throws InvalidInputExeption
	 */
	public void setCity(String city) throws InvalidInputExeption {
		checkInput(city, "Please only enter letter in the city name", true);
		this.city = city.toLowerCase();
	}

	/**
	 * 
	 * @param province
	 * @throws InvalidInputExeption
	 */
	public void setProvince(String province) throws InvalidInputExeption {
		checkInput(province, "Please only put leters in the province name", true);
		provinceExistance(province, Province.class, "Province");
		this.province = province.toLowerCase();
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
		this.postalCode = postalCode.toLowerCase();
	}

	/**
	 * 
	 * @param phoneNum
	 * @throws InvalidInputExeption
	 */
	public void setPhoneNum(String phoneNum) throws InvalidInputExeption {
		checkInput(phoneNum, "Please only enter numbers in the phone number", false);
		if (phoneNum.length() != 10) {
			throw new InvalidInputExeption("Invalid phone number please enter new one");
		}
		this.phoneNum = phoneNum.toLowerCase();
	}

	/**
	 * 
	 * @param yyyy
	 * @param mm
	 * @param dd
	 * @throws InvalidInputExeption
	 */
	public void setBirthDate(String b) throws InvalidInputExeption {
		int yyyy = Integer.parseInt(Character.toString(b.charAt(0)) + Character.toString(b.charAt(1))
				+ Character.toString(b.charAt(2)) + Character.toString(b.charAt(3)));
		int mm = Integer.parseInt(Character.toString(b.charAt(4)) + Character.toString(b.charAt(5)));
		int dd = Integer.parseInt(Character.toString(b.charAt(6)) + Character.toString(b.charAt(7)));
		String date = Character.toString(b.charAt(0)) + Character.toString(b.charAt(1))
				+ Character.toString(b.charAt(2)) + Character.toString(b.charAt(3)) + ""
				+ Character.toString(b.charAt(4)) + Character.toString(b.charAt(5)) + ""
				+ Character.toString(b.charAt(6)) + Character.toString(b.charAt(7));
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
		return this.streetNumber;
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

	public void checkInput(String s, String message, boolean b) throws InvalidInputExeption {
		if (b == true) {
			char[] array = s.toCharArray();
			for (char c : array) {
				if (!Character.isLetter(c) && c != ' ') {
					throw new InvalidInputExeption(message);
				}
			}
		}
		if (b == false) {
			String s1 = s + "";
			char[] array = s1.toCharArray();
			for (char c : array) {
				if (!Character.isDigit(c)) {
					throw new InvalidInputExeption(message);
				}
			}
		}
	}

	public boolean equals(ContestantInformation ci) {
		if (this.getFirstName().equals(ci.getFirstName()) && this.getLastName().equals(ci.getLastName())) {
			return true;
		}
		return false;
	}

	public int compareTo(Object ci) {
		return (this.getFirstName() + this.getLastName())
				.compareTo(((ContestantInformation) ci).getFirstName() + ((ContestantInformation) ci).getLastName());
	}

}
