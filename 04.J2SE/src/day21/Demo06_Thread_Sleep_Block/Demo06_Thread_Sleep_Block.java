package day21.Demo06_Thread_Sleep_Block;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author patrickyu
 *
 * sleep  block
 * 
 * when you are design a game, object moves in a speed that pretty smooth,
 * in fact, there also mandatory delay inside them. just like this sleep 
 * block
 * 
 */
public class Demo06_Thread_Sleep_Block {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 *  17:11
		 */
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		
		while(true){
			// #1 create a date object has the current time of our OS
			Date now = new Date();
			
			// #2 print out current time
			System.out.println(formatter.format(now));
			
			// #3 block 1 second
			try{
				/**
				 * even though you sleep for 1 second, it still might cause a jump second situation
				 * that's because after 1 second block, the thread returns to runnable state, waiting 
				 * for its turn to get a time snippet, and this process is uncertain, that is why it might
				 * cause a delay error. So in sum sleep for 1 second doesn't really mean actual 1 second 
				 */
				Thread.sleep(1000); // this is the thread sleep block
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		
	}

	

}
