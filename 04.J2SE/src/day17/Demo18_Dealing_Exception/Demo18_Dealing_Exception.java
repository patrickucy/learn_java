package day17.Demo18_Dealing_Exception;
/**
 * dealing exception in java
 * 
 * @author patrickyu
 *
 */
public class Demo18_Dealing_Exception {
	
	public static void main(String[] args) {
		System.out.println("Program starts");
		try{ // you can enclose code that could go wrong
			String str = "";
//			String str = null;
			System.out.println(str.length()); // exception here! App just crash
			System.out.println(str.charAt(1));
			
			/**
			 * if java get a exception, java will new an Object for you,
			 * and tell you what was happening 
			 */
		}catch(NullPointerException e){
			System.out.println("You now have a null pointer exception");
			/**
			 * having this catch means your app will not crash
			 * 
			 * It's like when you are running QQ in your computer, if you don't have network
			 * then it will just terminate some configuration
			 * 
			 * and the Exception Type you have to be exactly the problem
			 * if you don't catch that exception, then java will Kill this program
			 * 
			 * if there is no Exception, then program will not execute this block
			 */
			System.out.println(e);
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("String index is out of bound!");
		}catch(Exception e){
			System.out.println(e);
			System.out.println("There is an exception");
		}
		
		System.out.println("Program ends");
	}
}
