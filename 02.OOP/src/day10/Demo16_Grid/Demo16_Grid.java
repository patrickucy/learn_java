package day10.Demo16_Grid;

import java.util.Arrays;

public class Demo16_Grid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cell[][] wall = new Cell[20][10];
		wall[19][5] = new Cell(19,5);
		wall[19][6] = new Cell(19,6);
		wall[19][7] = new Cell(19,7);
		wall[19][8] = new Cell(19,8);
		wall[18][7] = new Cell(18,7);
		
		//the length is the length of the first dimension of such array
		for (int row = 0; row < wall.length; row++) {
			// row = 0 1 2 ... 19
			Cell[] line = wall[row];
			System.out.println(Arrays.toString(line));
		}
	}

}


class Cell{
	int row;
	int column;
	//right click you mouse, select "source" then "Generate Constructor using Fields..."
	public Cell(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	
	
	@Override
	public String toString() {
		return  row + "," + column;
	}



	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	
	
}