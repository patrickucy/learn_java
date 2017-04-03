package day10.Demo11_Final_vs_Static_Variable;
/*
 * this is the discrimination of these two description 
 * in fact, final is rarely used in real projects
 * 
 * final static -> const in C++ 
 * static -> one copy of such "thing" like variables, methods, objects
 */
public class Demo11_Final_vs_Static_Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog wangcai = new Dog(8);
		Dog wangwang = new Dog(9);
		System.out.println(wangcai.id + "," + wangwang.id + "," + Dog.numOfDogs);
		
//		wangcai.id = 10; // compile error here!!
		
	}

}

class Dog{
	final int id; // here means this ID can't be alter since its initialization
	int age;
	static int numOfDogs; // static variable just has one piece, recording the number of dogs
	public Dog(int id){
		this.id = id;
		Dog.numOfDogs++; 
		// recommend you use "Dog.numOfDogs", because this is the static way of call this property
		// this.numOfDogs is not wrong, it's just not the convention to do so
		// however, you should get used to using it as a class property 
	}
}