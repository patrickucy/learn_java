package day18.Demo04_Finally_KeyWord;
/**
 * finally keyword, no matter what went wrong with your program, code in finally block 
 * will always be executed
 * @author patrickyu
 *
 */
public class Demo04_Finally_KeyWord {

	public static void main(String[] args) {
		int port = 15221;
		try{
			System.out.println("Connecting Database...");
			System.out.println("Inserting data...");
			if(port != 1521){
				throw new RuntimeException("Fail to insert data!");
			}
			System.out.println("Disconnecting Database...");
		}catch(NullPointerException e){
			System.out.println("Exception: Null Pointer exception!");

		}catch(Exception e){
			System.out.println("EXCEPTION: Database operation exception!");
		}finally{
			/**
			 * you need to put "Disconnecting Database" here, otherwise, program will just throw an 
			 * exception and do nothing, keep occupying the resources!
			 * you need to clean up the mess!
			 */
			System.out.println("Disconnecting Database...");

		}// no more catch after finally~
		System.out.println("Database operation ends");

	}
}
