package day07;
import java.util.Arrays;
/*
 * Arrays.fill() 填充方法
 */
public class Demo05_Arrays_fill {

	public static void main(String[] args) {
		//假设一个游戏角色默认有5个属性,血,魅力,体力
		int[] person = new int[5];
		Arrays.fill(person, 100);
		System.out.println(Arrays.toString(person));
		
	}

}
