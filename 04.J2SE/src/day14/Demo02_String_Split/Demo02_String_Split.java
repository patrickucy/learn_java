package day14.Demo02_String_Split;

import java.util.Arrays;

/**
 * split String according to regular expression
 * @author patrickyu
 *
 */
public class Demo02_String_Split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1234 adfasdf jkljklj asdfasdfasf fsadfas";
		String regex = "\\s";
		String[] array = str.split(regex); // here means split at this"regex"
		System.out.println(Arrays.toString(array));


		String str1 = "?;;;avf;;;;;;fd12;tg45;1231s;nhnh78;;;;;";
		/**
		 *  if you wanna split, if there is not content after ;, then it will just ignore whatever there is 
		 */
		String[] array2 = str1.split(";+"); // here means it has at least one ;
		System.out.println(Arrays.toString(array2));
	}

}
