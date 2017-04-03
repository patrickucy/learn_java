package day03;
//就是导入系统API
import java.util.Scanner; //一定要在这个包下面import
//import java.lang.*; //这句话是把lang的包下所有的API拿来用,这个是默认是有的,其他的包都是默认不添加的
/*
 * 自由落体
 */
public class Demo02_Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		//Scanner console
		//Scanner 可以从控制台扫描读取(扫描)用户输入的数据
		
		
		System.out.print("input your time:"); //print就是不带换行的print
		//double t = 1.5;
		
		double t = console.nextDouble();
		
		double g = 9.8;
		double s;//位移
		s = g * t * t / 2;
		
		System.out.println("distance = "+s); 
		
		
	}

}
