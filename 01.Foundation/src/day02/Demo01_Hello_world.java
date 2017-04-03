package day02;

import javax.xml.ws.handler.MessageContext.Scope;

/*
 *  
 Java是强类型语言
 变量必须有明确类型,类型不能混用
 变量必须先声明,并且初始化,然后才能用
 变量可以赋值和更改
 变量有明确的作用域,离开作用域立即回收
 在同一个作用域中,变量不能重复定义
 违反上面任意一条就会发生编译错误
 编译错误,就是开发工具出现的红叉叉
 务必通过开发工具了解”编译错误”的详细信息提示
 
 其实跟C语言的基础非常像,你就直接跳过这些内容了,命名的习惯跟OC都是一样的
 */
public class Demo01_Hello_world {

	public static void main(String[] args) {
		int age; //declare a variable
		age = 12; //variable initialization; first time to assign value
		{
			int score = 8;//在代码块中定义的变量,这里的特点就是score指在当前的作用域块里面有效
			System.out.println(score);
		}
//		System.out.println(Score); //像这样子离开作用域,这个变量就已经被回收了
	}
}
