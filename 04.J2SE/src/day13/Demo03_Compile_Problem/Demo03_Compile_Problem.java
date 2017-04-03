package day13.Demo03_Compile_Problem;

public class Demo03_Compile_Problem {
	public static void main(String[] args) {
		String str1 = "HelloWorld";
		String str2 = "Hello";
		String str3 = "World";
		String str4 = str2 + str3;
		
		String str5 = "Hello"+"World";
		// after compiled this file, str5 = "HelloWorld" immediately,it will not leave it to future calculation 
		
		String str6 = "H"+'e'+"lloWorld";
		
		System.out.println(str1==str4); //false
		// str4 is not a ZiMianLiang! as long as you are not using ZiMianLiang, they will not be the same object
		// the most important issue is, str2 and str3 and variables,!
		
		
		System.out.println(str1==str6); //true
		
	}
}
