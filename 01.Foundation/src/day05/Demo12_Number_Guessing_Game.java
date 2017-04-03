package day05;

import java.util.Random;
import java.util.Scanner;

/*
 * 猜数字 游戏
 * 软件开发
 * 1) 分析找到数据
 * 2) 分析处理过程
 * 3) 设计软件流程
 *  猜数字 游戏
 *  1) 数据: 被猜测数据 num 
 *  		用户输入数据: guess
 *  		猜测次数(分数): Score
 *  2) 过程
 *  	1.生成随机被猜测数据 1~100
 *  	2.获得用户输入的数据
 *   	3.比较用户输入与被猜测数据
 *   		3.1一样就结束游戏
 *   		3.2大了,就提示猜大了
 *    		3.3小了,提示猜小了
 *    	5. 返回
 *  3) 实现
 */
public class Demo12_Number_Guessing_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, guess, score;
		score = 50;
		Random random = new Random();
		num = random.nextInt(100)+1;//这里产生的数一般是0~99
		Scanner in = new Scanner(System.in);
		
		while(true){
			System.out.println("Take a guess");
			guess = in.nextInt();
			if (guess == num) {
				System.out.println("Great! genius" );
				break;
			}
			if (guess>num) {
				System.out.println("you get it too big");
			}else {
				System.out.println("you get it too small");
			}
		}
		}
		
		

}
