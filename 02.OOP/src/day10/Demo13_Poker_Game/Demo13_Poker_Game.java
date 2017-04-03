package day10.Demo13_Poker_Game;

public class Demo13_Poker_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card ace = new Card(Card.SPADE, Card.ACE);
		
		// you need to override toString method in order to get a description of such object
		System.out.println(ace);
		System.out.println(new Card(Card.JOKER, Card.COLOR));
	}

}
