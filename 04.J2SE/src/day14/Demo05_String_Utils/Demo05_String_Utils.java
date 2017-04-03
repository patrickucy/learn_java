package day14.Demo05_String_Utils;

import org.apache.commons.lang3.StringUtils;

public class Demo05_String_Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String repeat = StringUtils.repeat("hello",5);
		System.out.println("repeat:"+repeat);
		
		String[] array = {"aa","bb","cc","dd"};
		String join = StringUtils.join(array,"#"); // this is the reverse operation of split()
		System.out.println(join);
		
		String leftPad = StringUtils.leftPad("hello", 10,'#');
		// here is that you want this String to have a length of 10, if you don't have a length of 10,then 
		// it insert # to its leftside until it gets the length of 10
		System.out.println(leftPad);
	}
}
