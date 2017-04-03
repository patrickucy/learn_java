package day16.Demo08_Generic_Programming_In_Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * collection supports generic programming
 * generic type is to describe the type of elements in collections
 * 
 * and generic type in Collection just have one parameter, specifying what
 * type of data you store in a Link 
 * 
 * @author patrickyu
 *
 */
public class Demo08_Generic_Programming_In_Collection {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		String str = list.get(0); // now you don't have to cast yourself!!!!!
	}
	
}
