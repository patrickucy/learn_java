package day18.Demo01_Exception_Throw;
/**
 * Throw exception scenario #1: Not comply to business logic
 *  
 * @author patrickyu
 *
 */
public class Person {
	private int age;

	public int getAge() {
		if(age>100||age<0){
			throw new RuntimeException("Not an unreasonable human age");
		}
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + "]";
	}

	
}
