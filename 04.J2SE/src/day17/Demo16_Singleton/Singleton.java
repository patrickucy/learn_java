package day17.Demo16_Singleton;

public class Singleton {
	// step #1
	private static Singleton instance = new Singleton();

	// step #2 using protected is recommended
	protected Singleton(){ // seal our constructor so the nobody could instantiate this class
		
	}
	
	// step #3
	// set this method as a class method, otherwise you will never get this method
	public static Singleton getInstance(){
		// static method can not use a not-static property
		return instance;
	}
}
