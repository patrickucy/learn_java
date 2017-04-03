package day10.Demo08_Final_Class;
/*
 * Final class can't be inherited by any subclasses
 * the purpose of having this is that it can prevent developer from sub-classing of some key component
 */
public class Demo08_Final_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

final class Goo{
	
}



// all these classes have compile errors

//class Hoo extends Goo{
//	
//}
//
//class MyString extends String{
//	
//}
//
//class Int extends Integer{
//	
//}

// In reality, you barely use "final class", because most time you need to extend your classes