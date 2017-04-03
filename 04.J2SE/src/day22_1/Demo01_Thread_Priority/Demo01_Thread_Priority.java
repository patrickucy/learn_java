package day22_1.Demo01_Thread_Priority;
/**
 * 
 * @author patrickyu
 *
 * setup Thread Priority
 *
 */
public class Demo01_Thread_Priority {

	public static void main(String[] args) {
		
		/**
		 * approach #1 to create a thread
		 * here is the anonymous internal class
		 */
		Thread t1 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				for (int i = 0; i <1000; i++) {
					System.out.println("max");
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				for (int i = 0; i <1000; i++) {
					System.out.println("nor");
				}
			}
		};
		
		
		Thread t3 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				for (int i = 0; i <1000; i++) {
					System.out.println("min");
				}
			}
		};
		
		/**
		 * only 10~1 available
		 * 10->max
		 * 1->min
		 * also you can just use class constant
		 * 
		 * setup a priority for thread is to maximize their probability to be executed
		 * but, it doesn't make any promise
		 */
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY); // default
		t3.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		
		System.gc(); // this is garbage collection, also it doesn't promise, just like thread priority
	}
}
