package day22_1.Demo06_Wait_And_Notify;
/**
 * wait block
 * @author patrickyu
 *
 */
public class Demo06_Wait_And_Notify {

	// if image download is finish 
	public static boolean finish = false;
	
	public static void main(String[] args) {
		final Thread download = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Start downloading image...");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("image download complete!");
				finish = true;
				
				
				/**
				 *  notify other threads that waiting for download object to 
				 *  unblock.
				 *  this synchronized block is also required
				 *  
				 */
				synchronized (this) {
					this.notify();
				}
				
				
				System.out.println("Start downloading flash...");

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("image download flash!");
			}
		};
		
		Thread showImage = new Thread(){
			@Override
			public void run() {
				try {
					/**
					 * this is required!!!!!!!! no reason !!!
					 * here you have to use synchronized lock, and its monitor
					 * has to be the object calling the wait()
					 */
					synchronized (download) {
						/**
						 * only when download ends and download calls notify(), does it unlock
						 */
						download.wait();
					}	
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				if (!finish) {
					throw new RuntimeException("fail to show image!");
				}
				System.out.println("start showing images");
			}
		};
		
		
		download.start();
		showImage.start();
	}
}
