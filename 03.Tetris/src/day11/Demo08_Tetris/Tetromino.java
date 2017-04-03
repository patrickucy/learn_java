package day11.Demo08_Tetris;

import java.util.Arrays;
import java.util.Random;


// because you will only use its subclasses
public abstract class Tetromino {
	// you need this property to be used by subclasses
	protected Cell[] cells = new Cell[4];
	
	
	
	/** here you define this constructor as private 
	 *  the object will never call this method
	 *  in other word, you can only call your initialization by calling "randomTetromino"
	 */
	private Tetromino(){ 
		
	}
	
	
	/** Tetromino is the shape, it consists cells
	 *  the methods below are just telling every cells to move as a whole structure
	 * 
	 */
	public void drop(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].drop();
		}
	}
	
	public void moveLeft(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].moveLeft();
		}
	}
	
	public void moveRight(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].moveRight();
		}
	}
	
	/** using this factory method to create a Tetromino instance
	 *  in other words, 
	 *  
	 */  
	public static Tetromino randomOne(){
		Random r = new Random();
		int type = r.nextInt(3);
		switch(type){
		// there is a compile error here
		// because static method can never use "this" pointer
		// hoverever, you sitll wanna use it like this
		// then you have to declare your method as "private static class"
		case 0: return new T();
		case 1: return new I();
		case 2: return new S();
		}
		return null;
	}
	
	// using static class to make them as part of the "Tetromino" class -> fullly encapsulation
	private static class T extends Tetromino{ // full encapsulation
		public T(){
			cells[0] = new Cell(0,4,Tetris.T);
			cells[1] = new Cell(0,3,Tetris.T);
			cells[2] = new Cell(0,5,Tetris.T);
			cells[3] = new Cell(1,4,Tetris.T);
		}
	}
	
	private static class I extends Tetromino{ // full encapsulation
		public I(){
			cells[0] = new Cell(0,4,Tetris.I);
			cells[1] = new Cell(0,3,Tetris.I);
			cells[2] = new Cell(0,5,Tetris.I);
			cells[3] = new Cell(0,6,Tetris.I);
		}
	}

	private static class S extends Tetromino{ // full encapsulation
		public S(){
			cells[0] = new Cell(0,4,Tetris.S);
			cells[1] = new Cell(0,3,Tetris.S);
			cells[2] = new Cell(1,4,Tetris.S);
			cells[3] = new Cell(1,5,Tetris.S);
		}
	}

	@Override
	public String toString() {
		return "Tetromino [cells=" + Arrays.toString(cells) + "]";
	}
	
	
}
