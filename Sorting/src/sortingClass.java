package sortingAssignment;

import java.util.ArrayList;
import java.util.Arrays;

public class sortingClass {

	/**
	 * This method uses the dumb bubble sorting algorithm to sort the array
	 * 
	 * @param
	 */
	public static String bubbleSortDumb(int[] list) {
		int length = list.length;
		for (int i = 0; i < length; i++) {
			for (int j = 1; j < length; j++) {
				if (list[j] < list[j - 1]) {
					swap(list, j, j - 1);
				}
			}
		}
		return toString(list);
	}

	/**
	 * This method returns a string that is the sorted using selection sort
	 * 
	 * @param list
	 * @return
	 */
	public static String selectionSort(int[] list) {
		int length = list.length;
		for (int i = 0; i < length - 1; i++) {
			int first = i;
			for (int j = i + 1; j < length; j++) {
				if (list[j] < list[first]) {
					first = j;
				}
			}
			swap(list, first, i);
		}
		return toString(list);
	}

	/**
	 * This method returns a string that is sorted using insert sort
	 * 
	 * @param list
	 * @return
	 */
	public static String insertSort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			int indexIn = i - 1;
			int indexAt = list[i];

			while (indexIn >= 0 && list[indexIn] > indexAt) {
				list[indexIn + 1] = list[indexIn];
				indexIn--;
			}
			list[indexIn + 1] = indexAt;

		}
		return toString(list);

	}

	/**
	 * This is the non-recursive quick sort method and it returns a sorted
	 * string using qucik sort
	 * 
	 * @param list
	 * @return
	 */
	public static String quickSort(int[] list) {
		if (list == null || list.length == 0) {
			return null;
		}
		int length = list.length;
		quickSort(list, 0, length - 1);
		return toString(list);
	}

	/**
	 * This is the recursive quick sort method
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	private static void quickSort(int[] array, int low, int high) {

		int i = low;
		int j = high;
		int pivot = array[low + (high - low) / 2];
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(array, i, j);
				i++;
				j--;
			}
		}
		if (low < j)
			quickSort(array, low, j);
		if (i < high)
			quickSort(array, i, high);
	}
	/**
	 * This is the non recursive merge sort method that retruns the sorted array using merge sort
	 * @param list
	 * @return
	 */
	public static String mergeSort(int[] list){
		if(list.length == 0 || list == null){
			return "";
		}
		mergeSortRecursive(list);
		return toString(list);
	}
	/**
	 * Thsi is the recursive pattern method for merge sort it splits the array into two and calls merge 
	 * @param list
	 */
	private static void mergeSortRecursive(int[] list){
		if(list.length > 1){
		int middle = list.length/2;
		int[] partOne = Arrays.copyOfRange(list, 0,middle);
		int partTwo[] = Arrays.copyOfRange(list, middle, middle *2);
		mergeSortRecursive(partOne);
		mergeSortRecursive(partTwo);
		merge(list , partOne , partTwo);
		}
	}
	/**
	 * This method arranges the indexs according to theri size
	 * @param list
	 * @param partOne
	 * @param partTwo
	 */
	private static void merge(int[] list, int[] partOne,int[] partTwo){
		int sumOfAllIndex = partOne.length + partTwo.length;
		int index ,indexOne, indexTwo;
		index = indexOne = indexTwo = 0;
		while(index < sumOfAllIndex){
			if((indexOne < partOne.length) &&(indexTwo<partTwo.length)){
				if(partOne[indexOne] < partTwo[indexTwo]){
					list[index] = partOne[indexOne];
					index++;
					indexOne++;
				}
				else{
					list[index] = partTwo[indexTwo];
					index++;
					indexTwo++;
				}
			}
			else{
				if(indexOne >= partOne.length){
					while(indexTwo < partTwo.length){
						list[index] = partTwo[indexTwo];
						index++;
						indexTwo++;
					}
				}
				if(indexTwo >= partTwo.length){
					while(indexOne < partOne.length){
						list[index] = partOne[indexOne];
						indexOne++;
						index++;
					}
				}
			}
		}
	}
	/**
	 * This Method converts the arrays int a string and returns it
	 * 
	 * @param list
	 * @return
	 */
	private static String toString(int[] list) {
		String s = "";
		for (int i = 0; i < list.length; i++) {
			s = s  + list[i] + " ";
		}
		return s;
	}

	/**
	 * This method swaps the two index of the given ArrayList
	 * 
	 * @param list
	 * @param index1
	 * @param index2
	 */
	private static void swap(int[] list, int index1, int index2) {
		int temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}
}
