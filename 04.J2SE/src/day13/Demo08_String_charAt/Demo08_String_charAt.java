package day13.Demo08_String_charAt;

public class Demo08_String_charAt {
	public static void main(String[] args) {
		String str = "helloworld";
		System.out.println(str.charAt(5));
		// 	palindromic
		String str1 = "helloolleh";
		/**
		 *  How do we identify palindromic ?
		 *  compare hear and tail !
		 *  1) loop , we need to repeat length()/2 times 
		 *  2) query if element at ordering is the same as that at reverse ordering
		 *  
		 */
		for (int i = 0; i < str1.length()/2; i++) {
			if(str1.charAt(i) == str1.charAt(str1.length()-1 -i)){
				continue;
			}else{
				
				System.out.println("Not palindromic");
				return; // return is another way of breaking a loop
			}
		}
		System.out.println("Yes pablindromic");


	}
}
