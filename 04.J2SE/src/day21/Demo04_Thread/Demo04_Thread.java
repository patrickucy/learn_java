package day21.Demo04_Thread;

/**
 * my first multi-thread demo
 * @author patrickyu
 *
 */
public class Demo04_Thread {
	
	public static void main(String[] args) {
		Thread me = new Person1();
		Thread plumber = new Person2();
		
		/**
		 *  call start();
		 *  then concurrence happens!
		 *  don't call run() by yourself! otherwise it would synchronized version
		 */
		me.start();
		plumber.start();
	}

}


/**
 * 
 * @author patrickyu
 *
 * we have to inherit a Thread,!
 */
class Person1 extends Thread  {

	/**
	 * override run(), and define the code that you want it to be concurrent
	 */
	public void run(){
		for (int i = 0; i < 1000; i++) {
			System.out.println("who the hell are you !");
		}
	}
	
	
	
}


class Person2 extends Thread {
	public void run(){
		for (int i = 0; i < 1000; i++) {
			System.out.println("I am a plumber !");
		}
	}
}
























