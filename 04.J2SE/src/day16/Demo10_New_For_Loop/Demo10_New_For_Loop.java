package day16.Demo10_New_For_Loop;
/**
 * in our new for loop, we can't delete any elements in a collection
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo10_New_For_Loop {

	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<String>();
		collection.add("1");
		collection.add("2");
		collection.add("3");
		collection.add("4");
		collection.add("5");
		collection.add("6");
		
		
		// in fact, here is the core theory of the new for loop,
		// just a generic programming !
//		Iterator<String> it = collection.iterator();
//		while (it.hasNext()) {
//			String e = it.next();
//			System.out.println(e);
//		}
		
		
		// in this new for loop, we can't delete any elements in a collection
		for(String e : collection){
			System.out.print(e);
		}
		System.out.println();
		
		String[] array = {"a","b","c","d","e"};
		for(String e: array){
			System.out.print(e);
		}

	
		
	}
}
