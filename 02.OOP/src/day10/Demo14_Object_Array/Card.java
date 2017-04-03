package day10.Demo14_Object_Array;
/*
 * poker cards
 */

// just like OC, it is the default setting 
// All classes are default setting "Object" as their super class
// This is why every thing is object

public class Card /* extends Object*/ {
	private int suit;
	private int rank;
	
	// Suits
	/** Fang kuai */ //this is a short description comment, if you hover your cursor on such object
	// it will show you 
	public static final int DIAMOND = 0;
	public static final int CLUB 	= 1;
	public static final int HEART 	= 2;
	/** Hei tao */
	public static final int SPADE 	= 3;
	public static final int JOKER 	= 4;

	
	// Ranks
	public static final int THREE 	= 0;
	public static final int FOUR 	= 1;
	public static final int FIVE 	= 2;
	public static final int SIX 	= 3;
	public static final int SEVEN 	= 4;
	public static final int EIGHT 	= 5;
	public static final int NINE 	= 6;
	public static final int TEN 	= 7;
	public static final int JACK 	= 8;
	public static final int QUEEN 	= 9;
	public static final int KING 	= 10;
	public static final int ACE		= 11;
	public static final int DEUCE	= 12;
	public static final int BLACK	= 13;
	public static final int COLOR	= 14;




	
	public Card(int suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	
	private final static String[] SUIT_NAMES = {"Diamond","Club","Heart","Spade",""};
	private final static String[] RANK_NAMES = {"3","4","5","6","7","8","9","10","J",
		"Q","K","A","2","Little Joker","Big Joker"};

	/** overriding toString method in Object class: the same as the description method in OC*/
	public String toString(){
		 String suitName = SUIT_NAMES[this.suit];
		 String rankName = RANK_NAMES[this.rank];
		 // here there still a problem, if you got a joker, you don't have a suit
		return suitName + " " +rankName;
	}
	// Later when you have a job, you get a situation that you have to map every object from 0 to n
	// you use array instead of for loop and switch case
	
	
	//just like OC, here you define your own getter
	public int getRank(){
		return rank;
	}
	
	//just like OC, here you define your own getter
	public void setRank(int rank){
		this.rank = rank;
	}
	
	public int getSuit(){
		return suit;
	}
	
	//just like OC you can just type set"Property" you get a faster way to write setter 
	public void setSuit(int suit){
		this.suit = suit;
	}
	
}
