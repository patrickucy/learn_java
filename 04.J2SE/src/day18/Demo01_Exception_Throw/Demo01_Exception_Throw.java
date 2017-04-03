package day18.Demo01_Exception_Throw;
/**
 * throw key word
 * 
 * using throw to actively throw an Exception
 * there are two cases, as follow:
 * 1. no semantic mistakes, but it doesn't comply our business logic
 * we can consider this as a Exception.
 * 2. when program is running, and it occurs an exception, but it is not 
 * your current responsibility to deal with such exception. then we need
 * to throw such exception
 * 
 * @author patrickyu
 *
 */
public class Demo01_Exception_Throw {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.setAge(1000);
		System.out.println("Our age is: "+ p.getAge());
	}
}
