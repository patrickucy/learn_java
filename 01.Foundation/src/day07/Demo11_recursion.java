package day07;
/* 
 * 递归: 一个方法中,直接或间接的调用了方法本身就叫递归调用
 * 
 * 业务案例
 * 讲故事(){
 * 	从前有座山
 * 	山上有座庙
 * 	庙里有个小和尚
 * 	小和尚在 讲故事(){
 * 		从前有座山
 * 		山上有座庙
 * 		庙里有个小和尚
 * 		小和尚在 讲故事(){
 * 			...
 * 	}
 * }
 * 
 * 等差数列的递归公式
 * y = f(x) = 1 + 2 + 3 + ... +n = n + f(n-1) 且f(1) = 1;
 * 
 * 递归调用深度不宜太深,这样会栈溢出!
 * 
 * 
 * 递归使用注意事项:
 * 1. 一定有递归结束条件
 * 2. 不能进行太深层的递归
 * 3. 不要出现发散型递归,只用收敛型递归,要不然就无穷尽了(比如说 斐波那契数列)
 * 
 * 缺点: 大量占用栈内存,性能不好
 * 优点: 解决问题比较优雅,简洁,只需要处理base case就可以了
 * 
 * 
 */
public class Demo11_recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = f(10); //10000就已经会stack overflow了
		System.out.println(result);
		
	}
	
	public static int f(int n){
		if(n==1){
			return 1;
		}
		return n + f(n-1);
	}

}
