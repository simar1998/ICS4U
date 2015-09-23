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
	public enum province{
	on,bc,pe,ab,mb,nb,bl,ns,nt,qc,sk,yt
	
	}
	/**
	 * 
	 */
	public ContestantInformation() {
		// TODO Auto-generated constructor stub
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
		this.firstName = firstName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @param streetNumber
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * 
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
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
	}

	/**
	 * 
	 * @param phoneNum
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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