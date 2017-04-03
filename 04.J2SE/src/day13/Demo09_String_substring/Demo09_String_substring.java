package day13.Demo09_String_substring;

public class Demo09_String_substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Thinking in Java";
		/**
		 *  capture the word "in" in such string
		 */
		String sub = str.substring(9, 11); // this method always cut it like this [9,11)
		sub = str.substring(12, str.length()); // this method always cut it like this [12,length)
		
		/**
		 *  trim a string, you just need to tell it the position you want tos start, 
		 *  it automatically trim it to the end
		 */
		sub = str.substring(12);

		System.out.println(sub);
	}

}
