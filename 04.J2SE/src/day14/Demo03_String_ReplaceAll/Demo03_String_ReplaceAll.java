package day14.Demo03_String_ReplaceAll;
/**
 * use regular expression to  replace string
 * @author patrickyu
 *
 */
public class Demo03_String_ReplaceAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "adbf2131312312adbfa2312312321nsndas12312312";
		/**
		 * replace all digits in this string with "#NUMBER#
		 */
		 str = str.replaceAll("[\\d]+", "#NUMBER#");
		 System.out.println(str);
	}
	
	

}
