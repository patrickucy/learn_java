package day14.Demo04_String_Filtering;
/**
 * filter sensitive words
 * @author patrickyu
 *
 */
public class Demo04_String_Filtering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "TMD! 你怎么这么SB啊!";
		String message = doMessage(str);
		System.out.println(message);
		
		
		

	}
	
	public static String doMessage(String message){
		String regex = "(TMD|TNND|CAO|SB|DSB|CNM)";
		String msg = message.replaceAll(regex, "***");
		return msg;
	}

}
