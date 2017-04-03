package day05;
/*
 * 数组: 数据类型一样的一组数据
 * 数组的详细语法
 * 理解:数组变量,数组,数组元素
 * 注意:引用类型
 * 数组只有两种类型, 除了8种基本类型变量以外,都是引用类型变量
 * 
 * 1)数组变量(引用类型) : 类型,声明,初始化
 * 数组类型:类型[]
 * int[] ary;//声明int类型的数组变量ary
 * ary = null://初始化 为null(空,没有)
 * 有变量,有值,没有数组
 */
public class Demo13_Reference_Type_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] players = {"Deng Chao","Sun Li","Ma Yili"};
		String[] cards = {"MeiHua","HongTao","FangKuai","HeiTao"};
		
		System.out.println(players[1]);
		System.out.println(cards[1]);
		
		//数组变量
		int[] ary; //声明数组变量
//		System.out.println(ary[1]);
		ary = null;
		//这里稍微注意一下,编译错误 和 运行错误
		//选择运行结果:
		//A.编译错误  B. 运行异常  C. 0  D. [1]
		ary = new int[]{3,4,5};
		System.out.println(ary[1]);
		
		ary = new int[4];
		// {0,0,0,0] 这里是数组的长度是4
		System.out.println(ary[1]);
		boolean[] used = new boolean[4];
		System.out.println(used[1]);
		char[] chs = new char[4];
		System.out.println((int)chs[0]);
		String[] names = new String[4];
		System.out.println(names[1]);
		//数组是自动初始化为0值的
		
		//创建数组有3种方式
		//1) new 类型[长度] 每个元素是0值
		//2) new 类型[]{元素,元素,元素...}直接初始化元素
		//3) {元素,元素,元素...}称为静态初始化,相当于2)的简化版,但只能用于声明数组变量的同时创建数组
		ary = new int[]{4,5,6};
		System.out.println(ary[1]);
		
		//ary = {4,5,6} //像这种情况是不允许用的,因为这里只是赋值了
		int[] ary1 = {5,6,7};
		
		//3种方式适用情况
		// 如果已知数组元素的情况下, 使用2)
		// 如果数组元素未知 或者 数量很多 1)
		// 元素已知,数量不多的情况用,声明直接初始化 3)
		// 也可以使用(2)
		
		//如何访问数组元素
		//1)使用数组下标读写数组元素
		//2)使用数组的length属性 获得数组的长度
		//3)数组下标范围 0 1 2 ... length -1
		//4)超范围访问会出现数组下标越界的异常
		//5)数组的长度是不可改变的
		
		ary = new int[]{6,7,8};
		System.out.println(ary[0]);
		System.out.println(ary[1]);
		System.out.println(ary[2]);
		
		System.out.println(ary.length);
		ary[ary.length - 1] ++;
		

	}

}
















