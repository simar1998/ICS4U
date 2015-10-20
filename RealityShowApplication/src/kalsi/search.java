/**
 * 
 */
package kalsi;

import java.util.ArrayList;

/**
 * @author 334915576
 *
 */
public class search {

	/**
	 * 
	 */
	public search() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param ci
	 * @param target
	 * @return
	 */
	public static Integer binarySearchClass(ArrayList<ContestantInformation> ci, ContestantInformation target) {
		int end = ci.size();
		int midPoint;
		int start = 0;
		for (int i = 0; i < end; i++) {
			midPoint = (end + start) / 2;
			if ((ci.get(midPoint).getFirstName().compareTo(target.getFirstName())
					+ ci.get(midPoint).getLastName().compareTo(target.getLastName())) == 0) {
				return 0;
			} else if ((ci.get(midPoint).getFirstName().compareTo(target.getFirstName())
					+ ci.get(midPoint).getLastName().compareTo(target.getLastName())) == 2) {
				start = midPoint - 1;
			} else if ((ci.get(midPoint).getFirstName().compareTo(target.getFirstName())
					+ ci.get(midPoint).getLastName().compareTo(target.getLastName())) == -2) {
				end = midPoint + 1;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param ci
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public static Integer binarySearchClass(ArrayList<ContestantInformation> ci, String firstName, String lastName) {
		int end = ci.size();
		int midPoint;
		int start = 0;
		for (int i = 0; i < end; i++) {
			midPoint = (end + start) / 2;
			if (ci.get(midPoint).getFirstName().compareTo(firstName) == 0
					&& ci.get(midPoint).getLastName().compareTo(lastName) == 0) {
				return 0;
			} else if (ci.get(midPoint).getFirstName().compareTo(firstName) == 1
					&& ci.get(midPoint).getLastName().compareTo(lastName) == 1) {
				start = midPoint - 1;
			} else if ((ci.get(midPoint).getFirstName().compareTo(firstName)
					+ ci.get(midPoint).getLastName().compareTo(lastName)) == -2) {
				end = midPoint + 1;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param ci
	 * @param target
	 * @return
	 */
	public static Integer linearSearch(ArrayList<ContestantInformation> ci, ContestantInformation target) {
		int length = ci.size();
		for (int i = 0; i < length; i++) {
			if (ci.get(i).getFirstName().equals(target.getFirstName())
					&& ci.get(i).getLastName().equals(target.getLastName())) {
				return 0;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param ci
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public static Integer linearSearch(ArrayList<ContestantInformation> ci, String firstName, String lastName) {
		int length = ci.size();
		for (int i = 0; i < length; i++) {
			if (ci.get(i).getFirstName().equals(firstName) && ci.get(i).getLastName().equals(lastName)) {
				return 0;
			}
		}
		return -1;
	}

}
