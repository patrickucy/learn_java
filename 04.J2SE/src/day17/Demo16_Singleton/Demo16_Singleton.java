package day17.Demo16_Singleton;
/**
 * Singleton design pattern
 * @author patrickyu
 *
 */
public class Demo16_Singleton {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		

		System.out.println(s1 == s2); // true
	}
}
