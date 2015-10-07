package kalsi;

import java.util.ArrayList;

public class BinarySorting {

	public BinarySorting() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public int search(ArrayList<Integer> list , int i){
		int endOfList = list.size() -1;
		int start = 0;
		int midPoint = 0;
		int arrayPos;
		final int MID = endOfList /2;
		boolean found = false;
		while(!found){
		 midPoint = (endOfList - start)/2;	
		 if( i < list.get(midPoint)){
			 midPoint = midPoint /2;
		 }
		 else if( i > list.get(midPoint)){
			 midPoint = midPoint/2 +MID;
		 }
		 else if( i == list.get(midPoint)){
			 break;
		 }
		}
		return list.get(midPoint);
	}

}
