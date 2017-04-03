package day08;
/*
 * greedy snake game
 */
import java.util.Random;

public class Demo03_Greedy_Snake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		Food food = new Food(random.nextInt(20),random.nextInt(20));
		Food food2 = new Food(random.nextInt(20),random.nextInt(20));

		System.out.println(food);
		System.out.println(food2);

	}

}


class Food{
	int x;
	int y;
	// 在类中声明构造器, 你会发现没有返回值,
	// 即使你声明返回值 void 也是错的,构造器就是什么都没有
	// 注意名字就是要一样
	public Food(int x, int y){
		this.x = x; //这里的this 是不能够省的, 跟 Swift很像
		this.y = y;
	}
}