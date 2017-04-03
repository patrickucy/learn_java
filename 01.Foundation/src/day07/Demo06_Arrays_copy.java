package day07;

import java.util.Arrays;

public class Demo06_Arrays_copy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] player1 = {100,100,100,100};
		int[] player2 = player1; //就是引用赋值,下面都是指的是同一个引用
		//player1 被打
		player1[0] -= 50;
		System.out.println(Arrays.toString(player1));
		System.out.println(Arrays.toString(player2));
		
		//复制数组
		int[] player3 = new int[player1.length];
		System.arraycopy(player1, 0, player3, 0, player1.length);
		System.out.println(Arrays.toString(player1));
		System.out.println(Arrays.toString(player3));

		System.out.println("123" + "abc");//其实这里就是用的是string copy实现的,
		// Arrays类 提供了更便捷的数组复制方法
		//底层就是System.arraycopy, copyOf(),方法java5之后出现
		int[] player4 = Arrays.copyOf(player1, player1.length);
		System.out.println(player4);

	}

}
