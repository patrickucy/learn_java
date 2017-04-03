package day10.Demo04_Class_In_Different_Files;
/*
 * 
 */
public class Player {
	private String name;
	
	private Card[] cards = {};
	
	public Player(String name){
		this.name = name;
		this.cards = new Card[]{};//here is a array with no element, it's different from null
		/**
		 *  String str = null;
		 *  this is a String that doen't exist
		 *  String str = "";
		 *  this is a String that exists but have nothing
		 *  
		 *  the same situation as above
		 */
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
