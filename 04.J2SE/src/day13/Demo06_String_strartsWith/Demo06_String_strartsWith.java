package day13.Demo06_String_strartsWith;

public class Demo06_String_strartsWith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "HelloWorld";
		if (str.startsWith("He")) {
			System.out.println("indeed starts with He");
		}
		
		if (str.endsWith("rld")) {
			System.out.println("indeed endsWith  rld ");
		}
		
		
		/**
		 *   a similation of Text message platform system
		 *   send a text,with HD prefix, plus your content
		 */
		
		String message = "hd I wanna learn java";
		if (message.toUpperCase().startsWith("HD")) {
			System.out.println("indeed starts with HD");
		}else{
			System.out.println("not starts with HD");
		}
		
		String str2 = "What's the length of this string?";
		System.out.println("The length is "+ str2.length());
		
	}
	
	
	
	

}
