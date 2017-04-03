package day21.Demo05_Thread_2;
/**
 * Approach #2
 * using runnable Interface
 * 
 * this is the recommended way of using multi-thread programming
 */
public class Demo05_Thread_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * in this way, your task and thread are separate now
		 * 
		 */
		Runnable me = new Person1();
		Runnable plumber = new Person2();
		Runnable t3 = new Runnable(){
			
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("I am here to check your water comsuption !");
				}
			}
			
		};
				
		Thread th1 = new Thread(me);
		Thread th2 = new Thread(plumber);
		Thread th3 = new Thread(t3);
		
		th1.start(); 
		th2.start();
		th3.start();
		
		
		/**
		 * don't think these task in a continues way
		 */
		
		
		

	}

}


/**
 *  define a class like before, but this you implements Runnable instead
 *  and still the run() is the exact block of code that could go concurrently
 *
 */
class Person1 implements Runnable {


	/**
	 * override run(), and define the code that you want it to be concurrent
	 */
	public void run(){
		for (int i = 0; i < 1000; i++) {
			System.out.println("who the hell are you !");
		}
	}
	
	
	
}


class Person2 implements Runnable {
	public void run(){
		for (int i = 0; i < 1000; i++) {
			System.out.println("I am a plumber !");
		}
	}
}