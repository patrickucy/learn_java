package day07;

import java.util.Arrays;

/*
 * 数组容量一旦创建就不能改变了
 * 
 */
public class Demo07_Array_Expansion {

	public static void main(String[] args) {
		String[] hotels = {"tom","andy","jerry"};
		System.out.println(Arrays.toString(hotels) );
		//扩容 (原数组复制了一遍,然后丢弃原数组,把内容复制到新的容量的新数组里面,实际上跟swap变量有点像)
		hotels = Arrays.copyOf(hotels, hotels.length + 1); 
		//实际上就是把引用给改了,原来那个没有人引用了,也就释放了,垃圾回收机制
		//只有在代码块结束了,才会被垃圾回收
		
		System.out.println(Arrays.toString(hotels) );
		//追加
		hotels[hotels.length-1] = "nemo";
		System.out.println(Arrays.toString(hotels) );


		
	}

}
