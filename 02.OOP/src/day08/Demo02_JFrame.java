package day08;

import javax.swing.JFrame;

public class Demo02_JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		// setSize 是在JFrame类中自带声明好了的方法
		frame.setSize(800, 600);	//调用对象的方法
		frame.setVisible(true);
		
		JFrame frame2 = frame;	//没有对象,也就是这个引用是个空引用
		frame2.setSize(800, 600);	// 在运行时会发生运行错误,因为空指针异常
		frame2.setVisible(true);	//在值是null的引用变量访问属性,方法就会出现空指针异常
//		如何解决空指针异常? 就是把引用变量给赋值了就好了,当然你要知道自己赋值的是什么东西,变量引用了对象!
		
	}

}
