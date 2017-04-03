package day10.Demo17_Poker_Game_More;

import java.util.Arrays;
import java.util.Random;

import day10.Demo13_Poker_Game.Card;

public class Demo17_Poker_Game_More {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card[] cards = new Card[54];
		int i = 0;
		for (int rank = Card.THREE; rank <= Card.DEUCE; rank++) {
			cards[i++] = new Card(Card.DIAMOND, rank);
			cards[i++] = new Card(Card.CLUB, rank);
			cards[i++] = new Card(Card.HEART, rank);
			cards[i++] = new Card(Card.SPADE, rank);
		}
		cards[i++] = new Card(Card.JOKER, Card.BLACK);
		cards[i++] = new Card(Card.JOKER, Card.COLOR);
		System.out.println(Arrays.toString(cards));
		
		// random card algorithm
		Random r = new Random();
		for (i = cards.length - 1; i>=1 ; i--) {
			int j = r.nextInt(i);
			// put out -> alter -> put back 
			// this is a little trick that you learn from Zhaozhe
			Card t = cards[i];
			cards[i] = cards[j];
			cards[j] = t;
		}
		System.out.println(Arrays.toString(cards));
	
		// Card distribution
		Player[] players = {
				new Player(1,"Chun Ge"), 
				new Player(2,"Zeng Ge"),
				new Player(3,"Chun Ye Men")
		};
		
		// Distribute cards in cycle
		int j = 0;
		for (i = 0; i < cards.length; i++) {
			Card c = cards[i];
			players[j++ %players.length].add(c);
		}
		System.out.println(players[0]);
		System.out.println(players[1]);
		System.out.println(players[2]);


	}

}
