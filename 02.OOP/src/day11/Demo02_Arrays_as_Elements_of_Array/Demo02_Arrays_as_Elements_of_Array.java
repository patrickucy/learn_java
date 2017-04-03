package day11.Demo02_Arrays_as_Elements_of_Array;

import java.util.Arrays;
/*
 * from this demo, you need to emphasize the logic of your project!
 * not just coding for coding sake
 * 
 * And you have to know the fundamental concept of 2-D array
 * in fact, it is a 1-D array, it just using arrays as its elements!
 * this is why people call java is a pure object-oriented language
 * 
 * Arrays.fill("array",element) -> it will fill all its element with new element
 */
public class Demo02_Arrays_as_Elements_of_Array {

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
		
		
		System.out.println("********************************************************************************");
		//clearing the elements in such array!!
		for(int row = 0; row < wall.length; row ++){
			Arrays.fill(wall[row], null); 
			// this is clearing the elements of this array
			// and these elements are also arrays! that's why you can use"Arrays.fill()"method here
			
//			Arrays.fill(wall, null); // this is nullifying the array itself
			// these two lines of code is ABSOLUTELY different!!!
		}
		
		
		for (int row = 0; row < wall.length; row++) {
			// row = 0 1 2 ... 19
			Cell[] line = wall[row];
			System.out.println(Arrays.toString(line));
		}
		
		System.out.println("********************************************************************************");
		// nullifying the array itself
		Arrays.fill(wall, null);
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
