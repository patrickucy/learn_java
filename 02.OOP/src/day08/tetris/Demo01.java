package day08.tetris;

import java.util.Arrays;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TPolyomino tpolyomino = new TPolyomino();
	
		//这里不写toString这种方法,这样子系统就会自动的调用这个方法,当你在用println的时候
		System.out.println(tpolyomino);
		tpolyomino.moveLeft();	
		System.out.println(tpolyomino);

	}

}

class TPolyomino{
	//这样子定义,属性的默认值是空的
	Cell[] cells;
	// 利用构造器,初始化4个格子
	public TPolyomino(){
		cells = new Cell[4]; // {null,null,null,null}
		cells[0] = new Cell(0,3,0xffff00);
		cells[1] = new Cell(0,4,0xffff00);
		cells[2] = new Cell(0,5,0xffff00);
		cells[3] = new Cell(1,4,0xffff00);
	}
	//相当于OC里面的description,就是一种输出成string来描述这个object
	public String toString(){
		return Arrays.toString(this.cells);
	}
	// drop one step
	public void softDrop(){
		for (int i = 0; i < cells.length; i++) {
			this.cells[i].drop();
		}
	}
	
	public void moveLeft(){
		for (int i = 0; i < cells.length; i++) {
			this.cells[i].moveLeft();;
		}
	}
	
	public void moveRight(){
		for (int i = 0; i < cells.length; i++) {
			this.cells[i].moveRight();
		}
	}
}


class Cell{
	int row;
	int column;
	int color;
	public Cell(int row, int column, int color){
		this.row = row;
		this.column = column;
		this.color = color;
	}
	//这里也定义了自己的description,方便在console中输出
	public String toString(){ //注意这个方法名要一模一样,而且是语言内置就是这么识别的      
		return "("+row +","+ column+")";
	}
	public void drop(){
		this.row++;
	}
	
	public void moveLeft(){
		this.column--;
	}
	
	public void moveRight(){
		this.column++;
	}
}