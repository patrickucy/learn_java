package day11.Demo05_Interface_Comparator;
import java.util.Arrays;
import java.util.Comparator;

/**
 * we use Comparator(interface) to stipulate rules, like comparison methods
 * 		compare(obj1,obj2)
 * 		if the return result is:  >0 then obj1 > obj2
 * 								  <0 then obj2 > obj1
 * 								 ==0 then obj1 == obj2
 * 
 * Java offers customized sorting methods, but still need Comparator(interface) to stipulate rules
 * 
 * 
 */
public class Demo05_Interface_Comparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"Tom","Jerry","Andy","John Lee"};
		Arrays.sort(names,new ByLength());
		// this line of code means we sort "names" by following the rule "ByLength()"
		System.out.println(Arrays.toString(names));
	}

}

/** we compare the length of two strings
 *  here we are defining the rules how we sort an array
 */
class ByLength implements Comparator<String>{ //here is generic programming

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length() - o2.length(); // the result here satisfy our rules: >0 <0 ==0
	}
	
}

// here is an example of using this Comparator
// this is why java is so powerful! 
// this is how the web sites sort items in different way

//class ByRank implements Comparator<Card>{ //here is generic programming
//
//	@Override
//	public int compare(Card o1, Card o2) {
//		// TODO Auto-generated method stub
//		return o1.getRank() - o2.getRank();
//	}
//}
