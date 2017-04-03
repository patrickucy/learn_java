package day06;

import java.util.Random;
import java.util.Scanner;

/*
 * 猜字谜的游戏
 * 输入一个字符串,输出提示 告诉用户匹配的字符多少个,匹配的位置多少个
 * 业务规则描述:猜测"随机生成"的字符系列(5个)
 * 根据"用户输入"的字符序列"检查"是否猜测成功
 * 如果不成功就"提示"猜中情况,继续猜测
 * 
 * 业务数据分析
 * 1)char[] answer 被猜测字幕序列
 * 2)char[] input 用输入的字幕序列
 * 3)int count 猜测次数
 * 4)int[] Result = {祖父匹配数量,匹配成功位置}
 * 用户输入的序列和被猜测序列的比较结果
 * 
 * 功能分析设计
 * 1)随机生成(generate)
 * 方法算法功能描述:生成m个不重复的大写字母
 * char[] generate(int n)
 * 
 * 2)用户输入(input)
 * 方法算法功能描述:从控制台读取输入,返回5个大写字符
 * char[] userInput()
 * 
 * 3)检查(check)用户输入
 * 方法算法功能描述:检查标准答案(answer)和用户输入(input),返回结果:(字符匹配数量,匹配成功位置}
 * int[] check(char[] answer, char[] input
 * 
 * 4)提示猜中情况
 * void show(int count, int[] result)
 * 
 * 5)main方法完成猜猜测流程控制
 * 1."生成答案"字符序列:5个字符
 * 2.等待用户的答案输入
 * 3."检查用户输入"的答案,检查结果包含匹配数量和匹配位置
 * 4.统计回答数量
 * 5.提示检查结果,返回(2)
 */

public class Demo05_Character_Guessing_Game {
	public static void main(String[] args) {
		System.out.println("Build successfully!!!");
		char[] answer;
		char[] input;
		int count = 0;
		int[] result;
		answer = generate(5); //generate 5 answers of strings
		System.out.println(answer);
		System.out.println("start guessing your characters: ");
		for (;;) {
			input = userInput();
			count++;
			result = check(answer, input);
			show(count,result);
			if (result[0] == 5 && result[1] == 5) {
				break;
			}	
		}
	}

	// generate 5 unrepeated Uppercase letters 
	public static char[] generate(int n){
		// data: All uppercase letters,return an array with n letters in it 
		// 
		char[] chs = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean[] used = new boolean[chs.length];
		int i;
		char[] answer = new char[n];
		int index = 0;
		Random rand = new Random();
		do {
			i = rand.nextInt(chs.length);
			if(used[i]){
				continue;
			}
			answer[index++] = chs[i];
			used[i] = true;
			
		} while (index != n);
		return answer;
		
	}
	
	public static char[] userInput(){
		Scanner in = new Scanner(System.in);
		
		char[] input;
		do {
			System.out.println("Please input your guess:");
			String s = in.nextLine();//从控制台读取一个字符串
			input = s.toCharArray(); //从字符串转为字符数组
		} while (input.length != 5);
		
		
		return input;
	}
	
	public static int[] check(char[] answer, char[] input){
		int[] result = {0,0};
		for(int i = 0; i < answer.length; i++){
			for (int j = 0; j < input.length; j++) {
				if (answer[i] == input[i]) {
					result[0]++;
					if(i==j){
						result[1]++;
					}
					break;
				}	
			}
		}
		return null;
	}
	
	public static void show(int count, int[] result){
		if (result[0] == 5 && result[1] == 5) {
			System.out.println("Hello " + count + " times");
			return; //虽然这个函数式无返回值的,这里加上return就可以提前结束这个函数
		}
		System.out.println("You've guessed "+ count + " times!" + "match content" + result[0] + " position" + result[1]);
	}
}

