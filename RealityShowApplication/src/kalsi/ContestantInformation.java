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

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

public class ContestantInformation {
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
	private <E extends Enum<E>> void provinceExistance(String string, Class<E> enumClass, String message) throws InvalidInputExeption {
		boolean bool = true;
		for (E e1 : enumClass.getEnumConstants()) {
			if (e1.name().equals(string)) {
				bool = true;
			} else {
				bool = false;
			}
		}
		if (bool == false) {
			new InvalidInputExeption("Not a valid perameter for field " + message);
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
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param streetNumber
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param province
	 */
	public void setProvince(String province) throws InvalidInputExeption {
		this.province = province.replaceAll("\\s", "").toLowerCase();
		provinceExistance(province, Province.class, "Province");
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
			if (Character.isLetter(postalCode.charAt(i - 1))) {
				throw new InvalidInputExeption("Incorrect Format");
			}
			if (!Character.isLetter(postalCode.charAt(i))) {
				throw new InvalidInputExeption("Incorrect Format");
			}
		}
		this.postalCode = postalCode.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param phoneNum
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum.replaceAll("\\s", "").toLowerCase();
	}

	/**
	 * 
	 * @param yyyy
	 *            mm dd
	 */
	public void setBirthDate(int yyyy, int mm, int dd) {
		this.birthDate.set(yyyy, mm, dd);
		this.birthDateString = this.birthDate.toString();
	}

	public void setAll(String[] s) throws InvalidInputExeption {
		setFirstName(s[0]);
		setLastName(s[1]);
		setStreetName(s[2]);
		setStreetNumber(s[3]);
		setCity(s[4]);
		setProvince(s[6]);
		setPostalCode(s[5]);
		setPhoneNum(s[7]);
		String bDay = s[8];
		String yyyy = Character.toString(bDay.charAt(0)) + Character.toString(bDay.charAt(1))
				+ Character.toString(bDay.charAt(2)) + Character.toString(bDay.charAt(3));
		String mm = Character.toString(bDay.charAt(4)) + Character.toString(bDay.charAt(5));
		String dd = Character.toString(bDay.charAt(6)) + Character.toString(bDay.charAt(7));
		setBirthDate(Integer.parseInt(yyyy), Integer.parseInt(mm), Integer.parseInt(dd));
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

}