package day10.Demo14_Object_Array;

import java.util.Arrays;

import day10.Demo13_Poker_Game.Card;

/*
 * object array -> array of objects:
 * 		array having objects as its elements
 * 		object array itself is also an object
 * 		all elements in such array, in fact, are references of those objects
 * 
 */
public class Demo14_Object_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card[] bomb;
		bomb = new Card[4]; // just created an array, no elements inside it 
//		bomb[0].getSuit(); // there will be a run time error, because, in fact, no reference at this point
		
		System.out.println(Arrays.toString(bomb));
		
		bomb[0] = new Card(Card.DIAMOND, Card.ACE); // you are assigning reference to array
		bomb[1] = new Card(Card.CLUB, Card.ACE);
		bomb[2] = new Card(Card.HEART, Card.ACE);
		bomb[3] = new Card(Card.SPADE, Card.ACE);
		
		System.out.println(Arrays.toString(bomb));
		
		bomb = new Card[]{
				new Card(Card.JOKER, Card.BLACK),
				new Card(Card.JOKER, Card.COLOR)
		};
		System.out.println(Arrays.toString(bomb));
		

		
		
		//3:03:27
	}

}
