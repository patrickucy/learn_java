package day10.Demo05_Static_Property;
/*
 * static variable: owned by the class itself, we could say it as class variable
 * static variable: just only one piece shared by all objects that are referring to
 * instance variable: every object owns themselves one piece of such property
 */
public class Demo05_Static_Property {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat tom = new Cat(5);
		Cat kitty = new Cat(2);
		System.out.println(tom.age + "," + kitty.age + "," + Cat.numberOfCats);
	}

}


class Cat{
	int age;
	static int numberOfCats; //in fact, the static property acts like a global variable but just one piece 
	public Cat(int age){
		this.age = age; //this means the property belongs to object
		Cat.numberOfCats++; // Using "Cat" directly here meaning "numberOfCats" belongs to the class
	}
}