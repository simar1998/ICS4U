/**
 * 
 */
package kalsi;

/**
 * @author 334915576 label class formats and returns a presentable version of
 *         the object
 *
 */
public class LabelClass {

	/**
	 * 
	 */
	ContestantInformation ci = new ContestantInformation();

	/**
	 * constructor
	 * 
	 * @param ci
	 */
	public LabelClass(ContestantInformation ci) {
		// TODO Auto-generated constructor stub
		this.ci = ci;
	}

	/**
	 * formats the name
	 * 
	 * @return
	 */
	private String formatName() {
		return pascalCase(ci.getFirstName()) + "," + pascalCase(ci.getLastName());
	}

	/**
	 * formatss the adress
	 * 
	 * @return
	 */
	private String formatAdress() {
		return pascalCase(ci.getStreetNumber()) + " " + pascalCase(ci.getStreetName()) + " \n"
				+ pascalCase(ci.getCity()) + " " + pascalCase(ci.getProvince()) + "\n"
				+ ci.getPostalCode().toUpperCase();
	}

	/**
	 * formats number
	 * 
	 * @return
	 */
	private String formatNumber() {
		char[] pH = ci.getPhoneNum().toCharArray();
		char[] fPH = { '(', pH[0], pH[1], pH[2], ')', ' ', pH[3], pH[4], pH[5], ' ', '-', ' ', pH[6], pH[7], pH[8],
				pH[9] };
		return String.copyValueOf(fPH);
	}

	/**
	 * Does the pascal case to given string
	 * 
	 * @param s
	 * @return
	 */
	private String pascalCase(String s) {
		String pascalCase = null;
		String[] pascal = s.split(" ");
		for (int i = 0; i < pascal.length; i++) {
			char[] array = pascal[i].toCharArray();
			array[0] = Character.toUpperCase(array[0]);
			for (int a = 0; a < array.length; a++) {
				pascal[i] = pascal[i] + array[a];
			}
		}
		for (int b = 0; b < pascal.length; b++) {
			pascalCase = pascal[b] + " ";
		}
		return pascalCase;
	}

	/**
	 * retruns the ompleted formated string
	 */
	public String toString() {
		return formatName() + "\n" + formatAdress() + "\n" + formatNumber();
	}

}
