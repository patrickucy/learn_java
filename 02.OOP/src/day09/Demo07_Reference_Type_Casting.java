package day09;
/*
 * 造型: 引用类型转换
 *  子类型到父类型:向上造型,自动类型转换
 *  父类型到子类型:向下转型,强制类型转换,可能不成功
 *  
 *  
 *  instanceof 运算符
 *  
 *  Number
 *   |-- Integer
 *   |-- Double
 *  
 */
public class Demo07_Reference_Type_Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//子类到父类:向上造型,自动类型转换
		Number n1 = new Integer(5);
		Number n2 = new Double(5.5);
		
		
		
		//父类到子类:向下造型,强制类型转换
		Integer i = (Integer) n1; //如果没有这个强制类型转换的话,就会出现编译错误
		
//		Integer i1 = (Integer) n2;
		//虽然这个通过了编译,但是会发生runtime error
		//原因是n2在运行期间实际引用的是Double不能转换为Integer类型
		
		
		
		//跟OC里面的类判断是一样的
		boolean isInt = n1 instanceof Integer;
		System.out.println(isInt);
		isInt = n2 instanceof Integer;
		System.out.println(isInt);
		
		
		
		//先检查类型,在进行转换,可以避免出现运行异常
		//类型安全的转换,是"常用的转换模式"
		//如下代码不会出现转换异常!
		if (n2 instanceof Integer) {
			Integer x = (Integer) n2;
		}
	}

}
