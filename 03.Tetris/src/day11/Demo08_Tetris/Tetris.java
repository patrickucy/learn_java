package day11.Demo08_Tetris;


import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * 
 * 
 *
 */
public class Tetris extends JPanel {
	// all these properties are compenents of Tetris
	private int score;
	private int lines;
	public static final int ROWS = 20;
	public static final int COLUMNS = 10;
	private Cell[][] wall = new Cell[ROWS][COLUMNS];

	
	// However all these properties are depended on Tetris
	// and this is why these properties don't need to initialize right now
	// current tetromino
	private Tetromino tetromino;
	private Tetromino nextOne;
	
	
	//images materials
	// you just have one backgroud
	public static BufferedImage background;
	public static BufferedImage gameOver;
	public static BufferedImage I;
	public static BufferedImage T;
	public static BufferedImage S;
	public static BufferedImage J;
	public static BufferedImage L;
	public static BufferedImage O;
	public static BufferedImage Z;

	static{ // use static block to load static images resources
		
		// abnormity handling
		try{
			// since you don't have image resources, this is the best you can do
			// its meaning is reading an image file from current package, and its name is "tetris.png"	
			// all these images files must be put into the same package
//			background = ImageIO.read(Tetris.class.getResource("tetris.png"));
//			gameOver = ImageIO.read(Tetris.class.getResource("game-over.png"));
//			I = ImageIO.read(Tetris.class.getResource("I.png"));
//			...
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		System.out.println("Game loaded!");
	}
	
	
}
