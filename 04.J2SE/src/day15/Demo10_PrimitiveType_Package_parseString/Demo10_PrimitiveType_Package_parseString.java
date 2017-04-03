package day15.Demo10_PrimitiveType_Package_parseString;
/**
 * packaged primitive types offer a lot of useful methods that you can use
 * it allows us to convert a string into a primitive data type
 * 
 * @author patrickyu
 *
 */
public class Demo10_PrimitiveType_Package_parseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "123";
		
		String regex = "\\d+\\.?\\d+";
		if (str.matches(regex)) {
			int a = Integer.parseInt(str); // here it can't process float number
			long lnum = Long.parseLong(str);
			float f = Float.parseFloat(str);
			System.out.println(a);
		
			
		}else{
			System.out.println("not a number");
		}
		
		
	}

}
