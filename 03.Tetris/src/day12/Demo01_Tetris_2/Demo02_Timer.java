package day12.Demo01_Tetris_2;
import java.util.Timer;
import java.util.TimerTask;
/**
 * TimerTask is an abstract class
 * including the abstract method run(), this is the code block you will keep repeating
 */
public class Demo02_Timer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Timer timer = new Timer();
//		TimerTask task = new TimerTask(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("Say hello");
//				
//			}
//			
//		};
//		
//		// schedule 1000 millisecond = 1 second later to execute task, and do that every 1000 millisecond
//		timer.schedule(task, 1000,1000);
		
		
		A instance = new B();
		instance.test();
	}

}


class A {
	public void test(){
		System.out.println("Testing A");
	}
}

class B extends A{
	public void test(){
		System.out.println("Testing B");
	}
}
