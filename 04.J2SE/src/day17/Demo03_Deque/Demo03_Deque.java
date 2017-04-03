package day17.Demo03_Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * since Deque can do operation at both sides
 * you can just seal one side to form a stack !
 * FILO
 * @author patrickyu
 *
 */
public class Demo03_Deque {

	public static void main(String[] args) {
		/**
		 *  stack application
		 *  when you using 2 classes having a name conflict within the same class
		 *  we can use "qualified name" to access different class
		 *  just like the following
		 * 
		 */
//		java.util.Date date = new java.util.Date();
//		java.sql.Date dateSql = new java.sql.Date(date)
		
//		java.util.Deque<Character> stack = new LinkedList<Character>();
		Deque<Character> stack = new LinkedList<Character>();
		
		/**
		 * push(E e)
		 * push element in a stack
		 */
		stack.push('A');
		stack.push('B');
		stack.push('C');
		stack.push('D');
		stack.push('E');
		
		System.out.println(stack); // [E, D, C, B, A]

		/**
		 * get the header of a stack 
		 * E pop(), this method will, at the same time, delete the element in the collection
		 */
		
		char c = stack.pop();
		System.out.println("pop: "+ c);
		System.out.println(stack);
		
		Character c1 = null;
//		while ((c1 = stack.pop()) != null) {
//			System.out.println(c1);
//		}
		// to enumerate this in the old way is no longer valid right now
		
		while (stack.peek() != null) {
			c1 = stack.pop();
			System.out.println(c1);
		}
		/**
		 * the reason of doing this in this way, because if you don't have any elements in stack, 
		 * and you pop(), there will be a runtime error : NoSuchElementException
		 * however, you can use peek() to do this
		 * 
		 *  Deque supports size(), we can use for loop to enumerate
		 */

//		for (int i = 0; i < stack.size(); i++) {
//			c = stack.pop();
//			System.out.println(c);
//		}
		/**
		 *   in addition, don't push "null" in a stack !!!!!!!!!!!!!!!!!!
		 *   if you want to  enumerate a stack, you should use peek() first then pop()
		 *   
		 */
		
		for (int i = stack.size(); i >0; i--) {
			c = stack.pop();
			System.out.println(c);
		}
		
		
	}
}
