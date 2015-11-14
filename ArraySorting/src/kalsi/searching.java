package kalsi;

import java.util.ArrayList;

public class searching {

	public static void main(String[] args) {
	}

	public static Integer binarySearchClass(ArrayList<Integer> list, int target) {
		int end = list.size();
		int midPoint;
		int start = 0;
		for (int i = 0; i < end; i++) {
			midPoint = (end + start) / 2;
			if (target == list.get(i)) {
				return i;
			} else if (target > list.get(i)) {
				start = midPoint - 1;
			} else if (target < list.get(i)) {
				end = midPoint + 1;
			}
		}
		return -1;
	}
	public static Integer binarySearchClass(ArrayList<Double> list, Double target) {
		int end = list.size();
		int midPoint;
		int start = 0;
		for (int i = 0; i < end; i++) {
			midPoint = (end + start) / 2;
			if (target == list.get(i)) {
				return i;
			} else if (target > list.get(i)) {
				start = midPoint - 1;
			} else if (target < list.get(i)) {
				end = midPoint + 1;
			}
		}
		return -1;
	}
	public static Integer binarySearchClass(ArrayList<String> list, String target) {
		int end = list.size();
		int midPoint;
		int start = 0;
		for (int i = 0; i < end; i++) {
			midPoint = (end + start) / 2;
			if (list.get(i).compareTo(target) == 0) {
				return i;
			} else if (list.get(i).compareTo(target) == 1) {
				start = midPoint - 1;
			} else if (list.get(i).compareTo(target) == -1) {
				end = midPoint + 1;
			}
		}
		return -1;
	}
	public static Integer linearSearch(ArrayList<Integer> list, Integer target) {
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (list.get(i) == target) {
				return i;
			}
		}
		return -1;
	}
	public static Integer linearSearch(ArrayList<Double> list, double target) {
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (list.get(i) == target) {
				return i;
			}
		}
		return -1;
	}
	public static Integer linearSearch(ArrayList<String> list, String target) {
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (list.get(i).equals(target)) {
				return i;
			}
		}
		return -1;
	}

}
