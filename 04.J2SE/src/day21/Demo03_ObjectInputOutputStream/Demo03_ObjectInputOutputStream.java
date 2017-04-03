package day21.Demo03_ObjectInputOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * instance of a class can be serialized
 * it is a high-level IOStream, it can convert our object to 
 * byte data(serialization)
 * 
 * @author patrickyu
 *
 */
public class Demo03_ObjectInputOutputStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person p = new Person(21, "patrick", "male","other info");
		
		/**
		 * create a file that can store our data of objects
		 */
		FileOutputStream fos = new FileOutputStream("PersonDataDemo.txt");
		
		
		/**
		 * create a high-level output stream for object serialization
		 */
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		
		/**
		 * writeObject(Object o)
		 * only this method is useful
		 * 
		 * as you can see here it can't be serialized!!
		 * why?
		 * because i need to implements Serializable interface in order to 
		 * tell the ObjectOutputStream to serialize it 
		 */
		oos.writeObject(p);
		oos.close();
		
		
		
		
		
		/**
		 * read those object data back (de-serialization)
		 * ObjectInputStream
		 * 
		 */
		FileInputStream fis = new FileInputStream("PersonDataDemo.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person p1 = (Person)ois.readObject();
		System.out.println(p1);
		ois.close();
		
		
		/**
		 * the content of the deserialzed object is exactly the same as before
		 * but from the point of memory, they are not the same object anymore
		 * 
		 * in fact this is a duplicate
		 */
		System.out.println(p.equals(p1)); 	// true     logically the same thing
		System.out.println(p == p1); 		// false	practically the different thing
		
		
		
		/**
		 * you can see here p has "other info"
		 * but p2 doesn't have that. Because "other" property is transient 
		 */
		System.out.println(p);
		System.out.println(p1);
	}
}


class Person implements Serializable { /**
	 * just a version id
	 * because you might later define a higher version of Person class
	 * Even though we still get a person class, but the properties might 
	 * already have been changed a lot. This id is to distinguish which
	 * kind of version Class you are really referring to 
	 * 
	 * it's just a record to notify yourself what kind of version of current
	 * class, in case of failure of deserialization
	 */
	private static final long serialVersionUID = 1L;
//  you have to have this interface in order to be serialized
	
	/**
	 * if you have a property is also a class defined by you, then
	 * this class must implement Serializable as well. However, like 
	 * String, the java API, they all have been setup as Serializable.
	 * So you don't have to worry about this. You just need to take 
	 * care of your own Classes
	 */
	private int age;
	private String name;
	private String gender;
	
	/**
	 *  if you define a transient property, then this property will not be
	 *  serialized !!!
	 *  
	 *  why do we need this ?
	 *  
	 */
	private transient String other; //
	
	
	
	
	
	
	
	public Person(int age, String name, String gender, String other) {
		super();
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.other = other;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Person(int age, String name, String gender) {
		super();
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (this.other == null) {
			if (other.other != null)
				return false;
		} else if (!this.other.equals(other.other))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", gender=" + gender
				+ ", other=" + other + "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}