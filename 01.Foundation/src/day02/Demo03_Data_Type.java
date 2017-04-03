package day02;
/*
 * long 
 * 经常用来定义时间:
 * 1970被行业内定义为时间的零点
 */
public class Demo03_Data_Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long now = System.currentTimeMillis();
		System.out.println(now);
		long year = now/1000/60/60/24/365 + 1970;
		System.out.println(year);
		long max = 0x7fffffff;
	}

}
