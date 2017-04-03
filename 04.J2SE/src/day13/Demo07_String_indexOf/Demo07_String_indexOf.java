package day13.Demo07_String_indexOf;
/**
 * indexOf()
 * String 
 * @author patrickyu
 *
 */
public class Demo07_String_indexOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "thinking in java";
		int index = str.indexOf("java");
		System.out.println(index);
		// find the position of target string in source string
		
		
		index = str.indexOf("in", 5); //from index 5 to find our target string 
		System.out.println(index);
		
		index = str.lastIndexOf("in");
		System.out.println(index);


	}

}
