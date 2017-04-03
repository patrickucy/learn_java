package day10.Demo17_Poker_Game_More;

import java.util.Arrays;

import day10.Demo13_Poker_Game.Card;

/*
 * 
 */
public class Player {
	private int id;
	private String name;
	private Card[] cards = {};
	
	
	public Player(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void add(Card card) {
		// TODO Auto-generated method stub
		// Because you don't have mutable array in java, it is using copying to achieve adding 
		// but later List<Object> can be your NSMutableArray
		this.cards = Arrays.copyOf(cards, cards.length+1);
		cards[cards.length-1] = card;
	}

	@Override
	public String toString() {
		return id + ","  + name + Arrays.toString(cards);
	}
	
	public boolean isEqual(Object obj){
		if(obj == null){
			return false;
		}
		
		if(this == obj){
			return true;
		}
		
		if(obj instanceof Player){
			Player o = (Player) obj;
			return id == o.id;
		}
		return false;
	}
	
	public int hashCode(){
		return id; //OID, object ID
	}
	
	
}
