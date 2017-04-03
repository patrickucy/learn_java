package day15.Demo08_Interger_PackageClassForAllPrimitiveType;
/**
 * package class for primitive data type
 * @author patrickyu
 *
 */
public class Demo08_Interger_PackageClassForAllPrimitiveType {

	public static void main(String[] args) {
		/**
		 * packaging primitive data type
		 */
		
		int i = 1;
		Integer in = new Integer(i);
		Integer in1 = new Integer(i);
		
		Long lon = new Long(1l);	
//		String s = "aa"; // this is convenient!
		
		
		System.out.println(in == in1); // just as before, new a Object will be different !!!
		
		/**
		 *  all package class for primitive types support a method called valueOf();
		 *  this method will buffer such primitive data, it will stay at the buffer,
		 *  they will only be change when you alter their content, or create a new one
		 *  And this is a recommended way !  -> save memory!
		 */
		Integer in2 = Integer.valueOf(i);
		Integer in3 = Integer.valueOf(i);
		System.out.println(in2 == in3); // since they are both in buffer, they are now the exact same object!
		
		
		/**
		 *  converting packaged primitive type back to its original
		 *  there is a method call xxxValue() xxx is the name of that primitive type
		 *  accessing the primitive data of such package class
		 *  
		 *  primitive type -> reference type  : packaging
		 *  reference type -> primitive type  : un-packaging
		 */
		
		int i2 = in2.intValue();
		System.out.println(i2);
		
		long longNum = lon.longValue();

	
	}
	
}
