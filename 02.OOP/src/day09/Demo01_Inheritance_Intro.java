package day09;

import java.util.Arrays;
import java.util.Random;

/*
 * 继承关系
 * 业务案例: 四格方块(tetromino)有7中
 * 父类型中定义的属性和方法,可以被子类类型继承
 * 构造器不能继承!!! -> 这也是为什么在OC你也要经常自己写super init();
 * 在子类构造器中初始化对象的属性
 * 父类的变量可以引用子类实例(说白了就是以前的多态)
 * 
 */
public class Demo01_Inheritance_Intro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 这里的t只有三种情况: 1.工厂方法给的. 2.等待别的对象传. 3.自己new出来
		Tetromino t = randomTetromino(); //这里可以声明称父类,跟以前的动态绑定的概念是一样的
		System.out.println(t);
		t.softDrot(); //下落方法是从父类继承下来的
		System.out.println(t);
	}
	
	
	// 随机生成一个多态的对象(特点就是返回的是父类型的子类实例)
	// 工厂方法,方法能够生成新的对象,一切属性都设置好了(自动的),  以前的就是自己分配内存来生成对象,并进行属性赋值(手动的)
	public static Tetromino randomTetromino(){ 
		Random random = new Random();
		int randomIndex = random.nextInt(2);
		switch (randomIndex) {
		case 0:
			return new TShapeTetromino();
			
		case 1:
			return new IShapeTetromino();	
		}
		return null;
	}
}

/*四格方块*/
class Tetromino{
	Cell[] cells = new Cell[4]; //这里只是说声明了有4个元素的数组,并没有进行初始化
	
	public void softDrot(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].drop();
		}
	}
	
	public String toString(){
		return Arrays.toString(this.cells);
	}
}

class Cell{
	int row;
	int column;
	public Cell(int row, int column){
		this.row = row;
		this.column = column;
	}
	
	public void drop(){
		this.row ++;
	}
	
	public void moveLeft(){
		this.column --;
		
	}

	public void moveRight(){
		this.column ++;
		
	}
	
	public String toString(){
		return "(" + row +","+ column +")";
	}
}

/* detailed Tetromino */
class TShapeTetromino extends Tetromino{
	public TShapeTetromino(){
		//cells 是从父类继承下来的属性,这里你看到了cells[]根本没有在本类定义
		cells[0] = new Cell(0,4);
		cells[1] = new Cell(0,4);
		cells[2] = new Cell(0,5);
		cells[3] = new Cell(1,4);

	}
}

class IShapeTetromino extends Tetromino{
	public IShapeTetromino(){
		cells[0] = new Cell(0,4);
		cells[1] = new Cell(0,3);
		cells[2] = new Cell(0,5);
		cells[3] = new Cell(0,6);
	}
}