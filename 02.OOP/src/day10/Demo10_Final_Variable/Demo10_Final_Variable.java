package day10.Demo10_Final_Variable;
/*
 * Final variable
 * 
 * once you initialize a final variable, you shall no longer alter such variable!
 * 
 * in fact, it is very similar with the "const" key word in C++
 */
public class Demo10_Final_Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int a;
		int b;
		a = 5; // here is not a alteration, but a initialization 
		b = 6;
		
//		a = 8; // there will be a compile error here, because it can't be alter after its initialization
		b = 9; // here, of course, you can alter at your will
		
		test(6,7);
	}
	
	public static void test(final int x, int y){
//		x = 5; // there will be a compile error here! in fact it is the same effect as "const" in C++
		y = 6;
	}

}
