/**
 * 
 */
package kalsi;

/**
 * @author 334915576
 *
 */
public class LabelClass {

	/**
	 * 
	 */
	ContestantInformation ci = new ContestantInformation();

	/**
	 * 
	 * @param ci
	 */
	public LabelClass(ContestantInformation ci) {
		// TODO Auto-generated constructor stub
		this.ci = ci;
	}
/**
 * 
 * @return
 */
	private String formatName() {
		return pascalCase(ci.getLastName()) + "," + pascalCase(ci.getLastName());
	}
/**
 * 
 * @return
 */
	private String formatAdress() {
		return pascalCase(ci.getStreetNumber()) + " " + pascalCase(ci.getStreetNumber()) + " \n"
				+ pascalCase(ci.getCity()) + " " + pascalCase(ci.getProvince()) + "\n"
				+ ci.getPostalCode().toUpperCase();
	}
/**
 * 
 * @return
 */
	private String formatNumber() {
		char[] pH = ci.getPhoneNum().toCharArray();
		char[] fPH = { '(', pH[0], pH[1], pH[2], ')', ' ', pH[3], pH[4], pH[5], ' ', '-', ' ', pH[6], pH[7], pH[8],
				pH[9] };
		return fPH.toString();
	}
/**
 * 
 * @param s
 * @return
 */
	private String pascalCase(String s) {
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				array[i] = Character.toUpperCase(array[i]);
			} else if (array[i - 1] != ' ' && i != 0) {
				array[i] = Character.toLowerCase(array[i]);
			} else if (array[i] == ' ') {
				array[i + 1] = Character.toUpperCase(array[i + 1]);
			}
		}
		return s = array.toString();
	}
	/**
	 * 
	 */
	public String toString(){
		return formatName()+"\n"+formatAdress()+"\n"+formatNumber();
	}

}
