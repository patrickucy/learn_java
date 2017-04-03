package day08;

public class Demo04_Constructor_Overload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
// 坐标系中的点
class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	//这个构造器用来创建对角线上的点(x,y相等)
	public Point(int x){
		this.x = x;
		this.y = x;
	}
}