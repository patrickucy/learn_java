package day10.Demo04_Class_In_Different_Files;
/*
 * poker cards
 */
public class Card {
	private int suit;
	private int rank;
	
	public Card(int suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}
	
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
