package day11.Demo06_Internal_Class;

import java.util.Arrays;
import java.util.Comparator;

/*
 * internal class
 * 1) the purpose of having internal class is for encapsulation, diminish the scope of such class
 * can only be used within the external class
 */
public class Demo06_Internal_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player someone = new Player();
		someone.cards = new Card[]{
				new Card(Card.SPADE,Card.THREE),
				new Card(Card.SPADE,Card.ACE),
				new Card(Card.DIAMOND,Card.THREE),
				new Card(Card.SPADE,Card.KING),
				};
		someone.sortCards();
		System.out.println(Arrays.toString(someone.cards));
	}

}



class Player{
	Card[] cards = {};
	
	public void sortCards(){
		Arrays.sort(cards, new ByRank());
	}
	
	// here is an internal class, because from the view of outside world,
	// you really don't care a little detail like "ByRank"
	// class "ByRank" has been define inside of class "Player", limiting the scope of "ByRank"
	class ByRank implements Comparator<Card>{
		
		@Override
		public int compare(Card o1, Card o2) {
			// TODO Auto-generated method stub
			return o1.getRank() - o2.getRank();
		}
		
	}
}

