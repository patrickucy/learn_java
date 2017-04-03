package day11.Demo08_Tetris;
/*
 * as you can see here, the only way you can create a tetromino is to call "randomOne()"
 */
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tetromino one = Tetromino.randomOne();
//		Tetromino t = new Tetromino(); //compile error
//		Tetromino t = new Tetromino.T(); // compile error, private static class, can't be seen
		
		System.out.println(one);
	}

}


//class T extends Tetromino{
//	// Compile error. Can't get the constructor
//}