package day13.Demo04_Comparison_In_String;
/**
 * Methods for String comparision
 * @author patrickyu
 *
 */
public class Demo04_Comparison_In_String {
	public static void main(String[] args) {
		String str1 = "HelloWorld";
		String str2 = "helloWorld";
		/**
		 *  when you use equals(), it is in fact a case sensitive method
		 */
		System.out.println(str1.equals(str2));
		
		
		/**
		 *  case insensitive
		 */
		System.out.println(str1.equalsIgnoreCase(str2));
		
//		if(str1.equals("HelloWorld")){
		// what if str1 == null? there will be a runtime error

		if("HelloWorld".equals(str1)){
			// this is the recommended way!!!
			// there never will be a empty pointer error in such way!
			// when we are doing string comparison, you have to do it this way! 
			// prevent the potential runtime error
			System.out.println("Same Content");
		}else{
			System.out.println("Differnet Content");
		}
	}
}
