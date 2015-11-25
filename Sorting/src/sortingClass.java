import java.util.ArrayList;

/**
 * 
 */

/**
 * 
 * @author simar
 *This class contains all the methods that you can call to sort an arraylist
 */
public class sortingClass {

	/**
	 * This method swaps the two index of the given ArrayList
	 * @param list An arrayList 
	 * @param index1 The first index for swapping 
	 * @param index2 The second index for swapping 
	 */
	private void swap(ArrayList<Integer> list, int index1 , int index2){
		int temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}
	/**
	 * This method uses the selection sorting algorithm to sort the ArrayList
	 * @param list The ArrayList to be sorted
	 * @return 
	 */
	public static String selectionSort(ArrayList<Integer> list){
		int length = list.size();
		int counter = length;
		int min = 0;
		for(int i = 0 ; i < length;i++){
			for(int j = 0; j<counter;j++){
				min = Math.min(min, list.get(j));
			}
			list.set(i, min);
			counter--;
		}
		return toString(list);
	}
	/**
	 * This method uses the dumb bubble sorting algorithm to sort the array
	 * @param list The ArrayList provided will sort the array
	 */
	public static void bubbleSortDumb(ArrayList<Integer> list){
		int length = list.size();
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				
			}
		}
	}
	/**
	 * This method returns a string of all the array values
	 * @param list the ArrayList 
	 * @return the ArrayList's elements in string format
	 */
	private static String toString(ArrayList<Integer> list){
		String s = "";
		for(int i = 0; i <list.size(); i++){
			s = s + " " + list.get(i);
		}
		return s;
	}

}
