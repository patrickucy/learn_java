package day10.Demo07_Static_Block;
/*
 * static block 
 */
public class Demo07_Static_Block {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo f1 = new Foo();
		Foo f2 = new Foo();
		//you can see the results from the console below, they just call the block
	}

}

class Foo{
//	System.out.println("hi");
	// there is compile error here
	// because you can't just write a statement within a class arbitrarily 
	// however, you can just do this 
	
	{
		System.out.println("hi");
	}
	// you can define block within a class
	// this block will be called when creating an object
	
	// in reality, using block is really rare, -> just telling you there such thing exists 
	// because, you can totally just implement this kind of code block in the constructor  
	
	// for static block, it will be used more frequent than previous one. But still pretty rare
	// as before, this is a  "class block", it will be called when the class is loaded.
	// class will be loaded just once, so that static block will as well just be called once
	// often used for resource just needed for once. like: configuration file, element figures 
	static{
		System.out.println("Load Foo.class");
	}
	
	// From this example, you can find that static block has just been called for once, 
	// whereas block has been called for twice 
}











