package day06;

import java.util.Random;

/*
 * 洗牌(打乱)算法
 * 红桃Q 黑桃A 方块3 梅花9 红桃K 方块9
 * 每一都是后一个跟前面任意一个交换,然后,向前挪一位,再随便的交换一次
 * 为什么从后向前洗牌呢?这是因为用取余数的话是非常方便的
 */
public class Demo01_Poker_Shuffle {

	public static void main(String[] args) {
		System.out.println("shuffle algorithm");
		String[] cards = {"红桃Q", "黑桃A", "方块3", "梅花9", "红桃K", "方块9"};
		Random random = new Random();
		for (int i = cards.length - 1; i > 0; i--) {
			int randIndex = random.nextInt(i);// j =[0,i)
			String temp = cards[i];
			cards[i] = cards[randIndex];
			cards[randIndex] = temp;
		}
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i]+" ");
		}
	}

}
