package day17.Demo10_Map_Intro;

import java.util.HashMap;
import java.util.Map;

public class Demo10_Map_Intro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// the same concept as NSDictionary in OC!
		Map<String,Point> map = new HashMap<String,Point>();
		map.put("1,2", new Point(1,2));
		map.put("2,2", new Point(2,2));
		map.put("3,2", new Point(3,2));
		map.put("3,4", new Point(3,4));

		System.out.println("Number of elements in map: "+ map.size());
		System.out.println(map);
		
		Point p = map.get("3,4");
		System.out.println(p);
		
		
		/**
		 * this is in fact a replacement, and this replacement will return the value that being replaced
		 */
		Point replacedPoint  = map.put("3,4", new Point(4,4));
		Point newPoint = map.get("3,4");
		System.out.println(map);
		System.out.println(replacedPoint);
		System.out.println(newPoint);
		
		
		Point get = map.get("1,1"); 
		// if there is no such value mapping such key, it will then return a null
		System.out.println(get); 
		
		boolean hasKey = map.containsKey("3,4");
		boolean hasValue = map.containsValue(new Point(2,2));
		System.out.println(hasKey);
		System.out.println(hasValue);
		
		
	}
}
