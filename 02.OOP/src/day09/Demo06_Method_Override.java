package day09;
/*
 * 方法重写
 * 重写:子类定义与父类一样的方法(方法名和参数都是一样的)
 * 重写的目的是在子类中重新"修改"父类的方法行为 (比如说鸟的翅膀都用来飞,但是有部分子类是不会)
 * 重写的方法调用规则:调用运行期间对象的方法,父类型的方法被修改(覆盖)掉了,父类方法此时也就无效了
 */
public class Demo06_Method_Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FlyingObject[] enemys = new FlyingObject[3]; //成群的初始化
		
		//子类对象可以"向上造型"为父类型实例(引用类型转换,也就是多态)
		enemys[0] = new Airplane(10,10,30,40);
		enemys[1] = new Bomb(20,70,10);
		enemys[2] = new Airplane(60,60,30,40);
		
		//子弹位置
		int x = 30;
		int y = 40;
		
		for (int i = 0; i < enemys.length; i++) {
			//如果父类没有声明shootBy方法,就会出现编译错误
			//java 编译器根据类型检查方法 shootBy 是否存在
			//如果不存在就会出现编译错误,
			//而且你声明的对象是FlyObject类,它当然会去检查是否有这个方法
			if (enemys[i].shootBy(x,y)) {
				System.out.println( i +" get hit !");
				//只有一个敌人被打掉了,其他的都还在
				break;// 加了这个就会只打掉一个飞机,如果不加break就会把这个坐标的所有飞机给打掉了
			}
		}
	}
}


class FlyingObject{
	int x;
	int y;
	
	//被击落了,检测当前飞行物是否被在x,y位置的子弹击中
	public boolean shootBy(int x, int y){
		
		return false;
	}
}

class Airplane extends FlyingObject{
	int width;
	int height;
	public Airplane(int x, int y, int w, int h){
		this.x = x;
		super.y = y; 
		//super.y = this.y 在子类中访问父类中声明的变量x
		//其实是一样的,就用this就好了 跟OC一样就好了
		this.width = w;
		this.height = h;
	}
	
	//重写父类的方法,实现检查飞机是否被击中
	public boolean shootBy(int x, int y){
		int dx = x - this.x;
		int dy = y - this.y;
		//就是距离范围判断
		return dx >= 0 && dx < this.width && dy >= 0 && dy < this.height;
	}
}

class Bomb extends FlyingObject{
	int radius;
	public Bomb(int x, int y, int r){
		this.x = x;
		this.y = y;
		this.radius = r;
	}
	
	//这里要自定义shootBy是因为每个子类的shootBy是不一样的,但是shootBy这个行为是都具有的
	public boolean shootBy(int x, int y){
		int a = x - this.x;
		int b = y - this.y;
		double c = Math.sqrt(a*a + b*b);
		return c <= this.radius;
	}
}





