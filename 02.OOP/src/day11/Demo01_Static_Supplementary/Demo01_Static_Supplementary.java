package day11.Demo01_Static_Supplementary;
/*
 * in sum only the variable defined as static final can't be altered !!! 
 * the object it referring can still be altered
 */
public class Demo01_Static_Supplementary {
	public static final String[] NAMES = {"Tom","Andy"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int a = 5;// after "a" being initialized, a can no longer be altered!!!
		
		final int[] ary = {6,7}; 
//		ary = null;// [compile error] after "ary" being initialized, this is a reference, and it can't be altered
		ary[0] = 8;// However, its elements CAN be altered!, because it's just the reference can't be altered
		ary[0] ++;
		// here is the same theory. "NAMES" itself can't be altered, however the object it referring -- array, 
		// the elements inside of it can still be altered !!!
		NAMES[0] = "Jerry";
		System.out.println(NAMES[0]);
		System.out.println(ary[0]);
		
		
		final Foo f = new Foo();
		f.a++;
		System.out.println(f.a);
		// here is still the same theory, the reference variable itself can't be altered
		// however, the properties of that object it referring CAN be altered!
	}

}

class Foo{
	int a = 5;
	// if you add a "final" here for this property, then this property can't be altered !
}