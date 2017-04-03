package day05;
/*
 * 打印 1000以内所有质数
 * 1) 注意检查 1000 以内的所有数
 * 2) 如果是质数就打印输出
 */
public class Demo07_Prime_Number_Under_1000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 1000; i++) {
			int num = i;
			boolean isPrime = true;
			for (int j = 2; j <= num / 2 ; j++) {
				if (num % j == 0) {
					isPrime = false;
					//System.out.println(num + " is Not Prime Number");
					break;
				}
			}
			if (isPrime) {
				System.out.println(num + " is Prime Number");
			}
		}
		
	}

}
