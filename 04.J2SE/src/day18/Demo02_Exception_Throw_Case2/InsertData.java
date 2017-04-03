package day18.Demo02_Exception_Throw_Case2;

import javax.management.RuntimeErrorException;

/**
 * throw exception scenario #2
 * exception is not responsible to current code
 * @author patrickyu
 *
 */
public class InsertData {
	

	public static void main(String[] args) {
		System.out.println("Getting user data ...");
		System.out.println("Cheching data completeness ...");
		
		try{ 
			/**
			 * why using try here? 
			 * this is like a preparation telling you that there will be exception happening when
			 * executing these code.
			 */	
		
			insert("192.168.1.2","1521");
		}catch(Exception e){
			System.out.println(e);
			System.out.println("inserting data failed");
			System.out.println("override insertion and do other operations");
		}
		System.out.println("Register successfully!");
		
	}
	
	public static void insert(String ip,String port){
		/**
		 * here is a simulation, assume the port is not 3306, we say fail to connect database
		 */
		try{
			if(!"3306".equals(port)){
				// simulation of javaVM to throw exception
				throw new RuntimeException("fail to access database!");
			}
			System.out.println("Inserting data to database ...");
		}catch(Exception e){
//			System.out.println("this is it~");
			/**
			 * if you catch any exceptions here, you should not deal it here! but to notify
			 * the outside world, telling outside what is suppose to do. in order to notify
			 * outside world, just throw this exception again to its outside function
			 * 
			 */
			throw e;
		}
	}
}
