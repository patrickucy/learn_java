package day17.Demo12_Map_Loophole;

import java.util.HashMap;
import java.util.Map;

/**
 * since hasSet has its loophole, and it is based on the theory of hashMap
 * there has to be some similar loophole for hashMap
 * Here is a demo to discuss its loophole!
 * @author patrickyu
 *
 */
public class Demo12_Map_Loophole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Point,String> map = new HashMap<Point,String>();
		
		Point p = new Point(1,2);
		map.put(p, "hello");
		p.setX(3);
		/**
		 * if you change the property, you in fact change its hashCode!
		 * now you have 1 key for two values
		 */
		map.put(p, "world");
		System.out.println(map);
		
		String str = map.get(p);
		System.out.println(str);
		/**
		 * now you can't access "hello"!!!!!
		 * how to access back to "hello"?
		 * change your properties back to its original value
		 */
		p.setX(1);
		str = map.get(p);
		System.out.println(str);
		
		
		/**
		 * Summary!
		 * when you are using Map.
		 * you use object as your key, in real application, this object should not 
		 * change its hashCode[properties] constantly. Otherwise, you might not get
		 * what you want
		 * 
		 * Usually just use String
		 */
	}

}
