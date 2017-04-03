package day05;
/*
 * 水仙花数问题: 也称为 3位自幂数
 * 是一个3位数, 这个数等于 每个数字的3次幂的和
 * 153 = 1*1*1 + 5*5*5 + 3*3*3
 * 
 * 如何判断一个数是否为水仙花数
 * 拆分一个数,累加每个数字3次幂的和与原数字比较
 */
public class Demo09_Flower_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 153;
		int sum = 0;
		while (num != 0){
			int last = num % 10;
			num /= 10;
			sum += last * last * last;
		}
		if (sum == num) {
			System.out.println(num + "是水仙花数");
		}
	}

}
