package day18.Demo03_Exception_KeyWord_Throws;
/**
 * when declaring a method, you can use throws to declare that this method could go wrong
 * 
 * @author patrickyu
 *
 */
public class Demo03_Exception_KeyWord_Throws {

	public static void main(String[] args) { // don't use throws at main function, this is useless
		try{
			dosome();
		}catch(Exception e){
			e.printStackTrace();
			/**
			 *  what doesn't this do ?
			 *  this is telling you where the program went wrong! the process it went wrong
			 *  tell you the stack and heap error information, usually we do our development
			 *  this is needed!
			 */
			System.out.println(e.getMessage());
			/**
			 *  this is telling you the reason it went wrong!
			 */
		}
	}
	public static void dosome() throws Exception { // class method, to be used by class itself
		/**
		 * if you throw a runtime exception, then you don't have to define throws here
		 * 
		 */
		try {
			String str = "";
			System.out.println(str.charAt(1));
		} catch (Exception e) {
			throw e;
		}
	}
}
