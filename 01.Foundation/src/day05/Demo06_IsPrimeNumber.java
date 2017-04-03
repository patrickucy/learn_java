package day05;
/*
 * 案例
 * 1 检查一个数是否为质数(素数)
 * 质数:一个数,除了能被自身和1整除,不能被其他数整除这个数就是质数
 * 
 */
public class Demo06_IsPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 6;
		boolean isPrime = true;
		for (int i = 2; i <= num / 2 ; i++) {
			if (num%i == 0) {
				isPrime = false;
				System.out.println(num + " is Not Prime Number");
				break;
			}
		}
		if (isPrime) {
			System.out.println(num + " is Prime Number");
		}
	}

}
