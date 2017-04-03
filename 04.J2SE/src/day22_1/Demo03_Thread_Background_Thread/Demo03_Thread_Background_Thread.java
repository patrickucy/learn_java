package day22_1.Demo03_Thread_Background_Thread;
/**
 * background thread, when all foreground thread are closed, 
 * then all background threads will be closed
 * @author patrickyu
 *
 */
public class Demo03_Thread_Background_Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread rose = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					System.out.println("Let me go!");
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println("AAAAAAaaaaa....");
				
				
			}
		};
		
		Thread jack = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					System.out.println("you jump! I jump!");
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				
			}
		};
		
		
		rose.start();
		/**
		 * setup as daemon (background thread)
		 * before we start our thread
		 */
		jack.setDaemon(true);
		jack.start();
		
		
		
		/**
		 * if you have a while loop here, the main() will not be killed, in fact 
		 * main() is also executed by a foreground thread. Thus, thread jack will
		 * not be killed
		 */
//		while(true){
//			// in fact the thread using the main function is also a foreground thread
//		}
		
		
	}

}
