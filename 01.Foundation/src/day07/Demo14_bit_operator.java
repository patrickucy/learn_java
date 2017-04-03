package day07;

public class Demo14_bit_operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 0xf;
		System.out.println(Integer.toBinaryString(n1));
		int n2 = 0xf0;
		System.out.println(Integer.toBinaryString(n2));
		int n3 = 0x41;
		System.out.println(Integer.toBinaryString(n3));
		
		System.out.println(Integer.toBinaryString(n1 | n2));
		// n1&n3 可以截取 n3的后4位数,因为n1 是 00001111,这样就可以与出来n3的后四位
		System.out.println(Integer.toBinaryString(n1 & n3));
		
		//将d1 d2 d3 d4 拼接为一个32位IP地址数据
		int d1 = 192; 	//00000000 00000000 00000000 11000000
		int d2 = 168;	//00000000 00000000 00000000 10101000
		int d3 = 10; 	//00000000 00000000 00000000 00001010
		int d4 = 1;  	//00000000 00000000 00000000 00000001
		
		int ip = d1<<24 | d2<<16 | d3<<8 | d4;		// 11000000 10101000  00001010 00000001
		System.out.println(Integer.toBinaryString(ip));
		//ip 地址的拼接就是位运算的用处
		
		int red = 121;
		int green = 35;
		int blue = 15;
		
		int color = red<<16 | (green<<8) | blue;// (因为其他位都是0,所以加的话效果是一样的)虽然教程是这么说,但是不能这么用,你还是用与运算好了
		System.out.println(Integer.toBinaryString(color));
		
		int b = color & 0xff;
		int g = color>>8 & 0xff;
		int r = color>>16 & 0xff;
		
		System.out.println(r);
		System.out.println(g);
		System.out.println(b);

		
		
	}

}
