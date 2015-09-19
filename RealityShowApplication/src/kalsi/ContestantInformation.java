package kalsi;

public class ContestantInformation {
	String firstName,lastName, city, province, postalCode, streetName, streetNumber, phoneNum, birthDate;
	public ContestantInformation() {
		// TODO Auto-generated constructor stub
	}

	public ContestantInformation(String firstName, String lastName, int streetNumber, String streetName, String city,
			String province, String postalCode, int phoneNum, int birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = ""+birthDate;
		this.streetNumber = ""+streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.postalCode = postalCode;
		this.phoneNum = ""+phoneNum;
	}

}
