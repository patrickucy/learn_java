package day03;
import java.util.*; // once you add this library you can use API to generate random number

public class Demo04_Coding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((int)'中');
		System.out.println((int)'国');
		System.out.println((int)'最');
		System.out.println((int)'好');
		System.out.println((int)'吃');

		char c = '\u4e2d';
		int n = c;
		System.out.println(c); //中
		System.out.println(n); // 编码
		
		c = '\n'; // new line
		System.out.println(c); //中

		c = '\r'; // return
		System.out.println(c); //中

		c = '\t'; // tab
		System.out.println(c); //中

		c = '\''; // '
		System.out.println(c); //中

		c = '\"'; // "
		System.out.println(c); //中

		c = '\\'; // \
		System.out.println(c); //中
		
		c = 'A' + 1;
		System.out.println(c); // 'B'
		
		Random random = new Random();
		int k = random.nextInt(26); // generate [0,26) numbers between this range
		// 凡事以后java以后表示数字范围的都是左包含,右不包含 即 [XX,XX)
		
		c = (char)('A' + k);
		System.out.println(c);
		
		c = 20013;
		System.out.println(c);
		
		// c = 65536; //编译错误,超范围赋值
		
		c = 65535;
		System.out.println(c);
				
		c = 65534+1; //字面量运算结果不超范围也可以赋值
//		c = 65534+2; // 编译错误, 
		
		c = 'A' + 3; //字面量没有超过范围
		
		n = 500000000;
//		c = 'A' + n;//int 变量表达,不能直接给char赋值
		
		c = (char)('A' + n);//你会发现这里 n的数字可能很大,这样子就会超范围,这样子会出现runtime 错误
	}

}
