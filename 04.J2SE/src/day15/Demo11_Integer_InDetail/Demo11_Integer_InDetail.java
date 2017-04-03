package day15.Demo11_Integer_InDetail;
/**
 * Integer also gives us some useful methods to use
 * @author patrickyu
 *
 */
public class Demo11_Integer_InDetail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 *  Integer offers method to interpret an integer to hex, binary string 
		 */
		String hex = Integer.toHexString(100);
		String bin = Integer.toBinaryString(100);
		System.out.println("hex: "+hex);
		System.out.println("bin: "+bin);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

		
	}

}
