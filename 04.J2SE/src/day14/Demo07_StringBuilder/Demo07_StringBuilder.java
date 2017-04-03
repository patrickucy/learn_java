package day14.Demo07_StringBuilder;
/**
 *  StringBuilder for constant string alteration
 * @author patrickyu
 *
 */
public class Demo07_StringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 *  String s = "a";
		 *  s += "b";
		 *  
		 */
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("a*");
		strBuilder.append("b%");
		String str = strBuilder.toString();
		System.out.println(str);
		
		
		
		StringBuilder builder = new StringBuilder("a|");
		// adding new stuff to current string
		for (int i = 0; i < 1000000; i++) {
			builder.append("a*");
		}
		str = builder.toString();
		System.out.println(str);

		
	}

}
