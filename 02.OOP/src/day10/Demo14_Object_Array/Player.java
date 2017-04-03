package day10.Demo14_Object_Array;
/*
 * 
 */
public class Player {
	private String name;
	
	private Card[] cards = {};
	
	public Player(String name){
		this.name = name;
		this.cards = new Card[]{};//here is a array with no element, it's different from null
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
