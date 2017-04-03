package day17.Demo01_Sublist;
/**
 * get subList of a List collection
 */
import java.util.ArrayList;
import java.util.List;

public class Demo01_Sublist {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i<10; i++){
			list.add(i);    // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		}
		
		System.out.println("List: "+list);
		
		
		/**
		 *  get subList
		 */
		List<Integer> subList = list.subList(4, 8);  // [4,8)
		System.out.println("subList: "+ subList);
		
		
		for(int i = 0; i<subList.size(); i++){
			int num = subList.get(i);
			subList.set(i, subList.get(i)*10);
		}
		System.out.println("subList: "+ subList);
		System.out.println("List: "+list);
		/**
		 *  from this result you can see that even though you just manipulated the subList, 
		 *  in fact, at the same time, you were manipulating the original List!!!!!!
		 *  
		 */
	}
	
}
