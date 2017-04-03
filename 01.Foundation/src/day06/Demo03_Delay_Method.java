package day06;
/*
 * 延时方法
 * 业务:利用方法封装,撞击检查功能
 * 其中炸弹参数:x,y,r
 * 子弹参数:x1,y1
 * 返回值:true表示发生撞击
 * 这节课的主要内容是函数的调用
 * 
 */
public class Demo03_Delay_Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		boolean b = hit(60, 80, 50, 70, 90); // 方法调用 y = f(x)
		b = hit(60, 80, 50, 60+50, 80+50); // 方法调用
		
		System.out.println(b);
		
	}
	//方法必须在类中声明!
	//方法的3个要素:返回值,方法名,参数列表
	//如果方法声明了返回值,就必须使用return语句
	public static boolean hit(int x, int y, int r, int x1, int y1) {
		int a = x1 - x;
		int b = y1 - y;
		double c = Math.sqrt(a*a + b*b);
		
		return c <=r;
	}
}
