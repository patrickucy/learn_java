package day11.Demo07_Anonymous_Internal_Class;
import java.util.Arrays;
import java.util.Comparator;
/**
 * 
 * Anonymous_Internal_Class
 * 1) you must have a superclass
 * 2) anonymous internal class can implement interface/ abstract class
 * need to implement all abstract methods
 *
 */
public class Demo07_Anonymous_Internal_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creating a Koo instance
		Koo koo = new Koo(); 
		
		
		
		
		// creating a Koo anonymous subclass instance,  {} is the body of subclass 
		Koo koo2 = new Koo(){ 
			//after creating this, this is in fact the SUBCLASS!! of Koo
		};
		
		
		
		
		
		Koo koo3 = new Koo(){
			public void test(){
				System.out.println("koo3");
			}
			// in fact this is a convenient way of overriding a method in superclass
			// the purpose of anonymous is because, you might just need it to be used just once
		};
		koo.test();
		koo3.test(); // call the method of such object
		
		
		
		
		
		// special case !!!!!
		// comparator anonymous internal class -> subclass
		Comparator<String> byLength = new Comparator<String>(){
			// in fact, you CAN NOT new a interface! 
			// the reason why you can new a Comparator is because, you are using a anonymous subclass!!
			
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
		}; // this means that logically, it's just one line of code
		
		String[] names = {"Andy","Lee","Tom","John Xu","Jerry"};
		Arrays.sort(names, byLength); 
		//now we can just this object directly, in fact you can replace bylength with what is above
		
		System.out.println(Arrays.toString(names));
		
		
		
		
		
		
		// this is how you combine all those stuff above together!
		// compact way!
		// in real work, this is how developer how to code it like this
		Arrays.sort(names, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int tempResult = -(o1.length() - o2.length());
				if (tempResult == 0) {
					return -( o1.charAt(0) - o2.charAt(0));
				}
				return tempResult;
			}
		});
		System.out.println(Arrays.toString(names));

		
	}

}

class Koo{
	public void test(){
		System.out.println("Koo.test()");
	}
}