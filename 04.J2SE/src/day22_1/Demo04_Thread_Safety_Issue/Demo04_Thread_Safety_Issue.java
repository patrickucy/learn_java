package day22_1.Demo04_Thread_Safety_Issue;

import java.util.Hashtable;
import java.util.Vector;

import day22_1.Demo04_Thread_Safety_Issue.Table.Person;

/**
 * thread safety issue
 * 
 * In this demo, if you have a situation that have an infinite running
 * then that is the Thread safety issue
 * 
 * @author patrickyu
 * 
 * 
 * in t
 *
 */
public class Demo04_Thread_Safety_Issue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 *  how to instantiate an internal class?
		 */
		
		Table table = new Table();
		
		Person p1 = table.new Person();
		Person p2 = table.new Person();
		
		p1.start();
		p2.start();
		
	}

}


class Table {
	int beans = 20;

	/** 
	 * having a key word synchronized here means this method will only be call
	 * by one thread at a time! multiple threads will never execute this method
	 * at the same time
	 * 
	 * this keyword means that this method  will be locked when 
	 * a thread is executing this method. Only when this thread ends executing this 
	 * method, do we allow to let other thread to execute it. 
	 * 
	 * because this is the public resource for every thread to use. There must be a 
	 * lock to lock it when one thread is using it!!!!!! just like the public toilet
	 * @return
	 */
	public int getBeans() {
		
		/**
		 * when you use synchronized block, you need to make sure that multiple threads
		 * must see synchronize monitor as the same object
		 */
		synchronized (this) {
			if (beans == 0) {
				throw new RuntimeException();
			}
			
			/**
			 *  this means the thread volunteer its time snippet and let other threads to use it
			 *  and set itself to Runnable state 
			 */

			Thread.yield(); // give more probability to cause thread safety issue
			return beans --;
		}
		
	}
	
	class Person extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				int bean = getBeans();
				/**
				 * getName() this is a method defined by Thread, it will get its name
				 * when it initialize a thread
				 * Format:
				 * Thread-X x is number
				 */
				System.out.println(getName()+ ":" +bean); // this is the getName() from Thread
				Thread.yield();
			}
		}
	}

	public void setBeans(int beans) {
		this.beans = beans;
	}
	
}