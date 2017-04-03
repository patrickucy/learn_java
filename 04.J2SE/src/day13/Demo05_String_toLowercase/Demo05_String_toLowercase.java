package day13.Demo05_String_toLowercase;
/**
 * String useful methods
 * @author patrickyu
 *
 */
public class Demo05_String_toLowercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "      Hello     World    ";
		/**
		 * transform all letters into lowercase letters
		 */
		String lower = str.toLowerCase();
		System.out.println(lower);
		
		String upper = str.toUpperCase();
		System.out.println(upper);
		
		String trim = str.trim();
		 
		System.out.println(trim);

	}

}
