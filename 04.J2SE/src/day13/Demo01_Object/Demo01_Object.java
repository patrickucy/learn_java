package day13.Demo01_Object;

public class Demo01_Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person guy = new Person();
		guy.sayHello();
		
		Object obj = new Person(); 
//		this is polymorphism,  super class reference 
//		is receiving a reference of its subclass 
		toDo("dfdsfsd");
		toDo(obj.toString());
		
	}
	
	
//	if we define the data type as "Object" then we can pass any argument to here 
//	this is how we use polyporphism 
	public static void toDo(Object info){
		System.out.println(info);
	}

}

class Person{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello(){
		String str = this.toString();
		System.out.println(str);
	}
}