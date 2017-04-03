package day14.Demo01_String_Regular_Expression;
/**
 * String in java support Regular expression
 * 1: matching regular expression
 * 
 * boolean matches(String regex)
 * match current string according to specific regular expression
 * @author patrickyu
 *
 */
public class Demo01_String_Regular_Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * regular expression for email address
		 * \w+@\w+(\.com|\.cn|\.com\.cn){1}
		 */
		String regex = "\\w+@\\w+(\\.com|\\.cn|\\.com\\.cn){1}"; 
		// because \ in java has conflict with \ in regular expression
		System.out.println(regex);
		String mail = "whatthe_fuck@gmail.com";
		boolean isMail = mail.matches(regex);
		
		System.out.println(isMail);
		
		/**
		 * write a regular expression for chinese ID
		 * [0-9]{17}(x|X){1}
		 * [0-9]{15}
		 * 
		 * 1) ID with 15 digits
		 * 2) ID with 18 digits ending with x
		 * 
		 */
		String idRegex = "[0-9]{17}(x|X){1}";
		String myid1 = "42212334488985774x";
		String myid2 = "42212334488985774X";
		System.out.println(myid1.matches(idRegex));
		System.out.println(myid2.matches(idRegex));


		 
		
	}

}
