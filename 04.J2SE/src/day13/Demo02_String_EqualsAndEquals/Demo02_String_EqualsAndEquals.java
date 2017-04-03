package day13.Demo02_String_EqualsAndEquals;
/**
 * String will in fact use its exact value duplicate
 * 
 * @author patrickyu
 *
 */
public class Demo02_String_EqualsAndEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Hello World";
		String str2 = "Hello World";
		String str3 = "Hello World";

		String str4 = new String("Hello World");
		// here you are telling java directly to create new String for you
		
		
		// here is comparing the reference !!!!!!! not the content of such reference
		// this is how java save memory
		System.out.println(str1 == str2); //true
		System.out.println(str1 == str3); //true
		
		// now, although the content is the same, but in fact now is different;
		System.out.println(str1 == str4); //false


		// so what's the difference ?
		// if you use "XXX" directly, then it will automatically use the same object
		// if you use new String(), then you are directly telling java to create a new object for you
		
		// In sum, you should always use "equals()" rather than "=="
	}

}
