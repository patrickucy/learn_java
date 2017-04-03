package day17.Demo02_Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Queue
 *  FIFO
 *  
 * @author patrickyu
 *
 */
public class Demo02_Queue {

	public static void main(String[] args) {
		/**
		 *  queue usually supports generic programming, defining the data type of elements
		 */
		Queue<String> queue = new LinkedList<String>();
//		Queue<String> queue2 = new Queue<String>();// you can't instantiate a queue like this
		/**
		 * adding elements to a queue
		 */
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		System.out.println(queue);
		
		
		/**
		 * peek()
		 * get the header of this queue
		 * it just refers the header of our queue without deleting it from that queue
		 */
		System.out.println(queue.peek()); // A
		System.out.println(queue.peek()); // A
		
		
		/**
		 * poll()
		 * get the header of this queue, at the same time, it deletes the header from its queue
		 * 
		 */
		System.out.println(queue);
		System.out.println(queue.poll()); //A
		System.out.println(queue.poll()); //B
		System.out.println(queue);
		
		
		String e = null;
		while (( e = queue.poll()) != null) {
			System.out.println(e);
		}
		/**
		 *  enumerating queue is a one-time process
		 *  because you have to put out every element in order to check 
		 *  after you check every thing, all elements have been pulled out
		 *  and the queue is empty already
		 */
		
		
		
		
	}
}
