package kalsi;

public class ContestantInformation {
	String firstName, lastName, city, province, postalCode, streetName, streetNumber,phoneNum, birthDate;

	public ContestantInformation() {
		// TODO Auto-generated constructor stub
	}

	public ContestantInformation(String firstName, String lastName, int streetNumber, String streetName, String city,
			String province, String postalCode, int phoneNum, int birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = "" + birthDate;
		this.streetNumber = "" + streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.postalCode = postalCode;
		this.phoneNum = "" + phoneNum;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getStreetNumber() {
		return this.streetName;
	}

	public String getStreetName() {
		return this.streetName;
	}

	public String getCity() {
		return this.city;
	}

	public String getProvince() {
		return this.province;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public String getBirthDate() {
		return this.birthDate;
	}
	public void printAll(){
		System.out.println("Name: "+ firstName +" " + lastName
				+" City: "+city+" Province: "+  province +" Postal Code: "+ postalCode +" Street name: "+
				streetName+" Street Number: "+  streetNumber+ " Phone Number" +phoneNum+
				" Birthdate: "+birthDate);
	}
	}
