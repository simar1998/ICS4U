package kalsi;

import java.util.ArrayList;

public class BinarySorting {

	public BinarySorting() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(search(list, 2));
	}

	public static int search(ArrayList<Integer> list, int i) {
		int endOfList = list.size() - 1;
		int start = 0;
		int midPoint = 0;
		boolean found = false;
		while (start != 6) {
			midPoint = (start + endOfList) / 2;
			if (i < list.get(midPoint)) {
				start = midPoint - 1;
			} else if (i > list.get(midPoint)) {
				start = midPoint + 1;
			} else if (i == list.get(midPoint)) {
				return 0;
				
			}
		}
		if(found){
			return 0;
		}

			return -1;
	}

}
