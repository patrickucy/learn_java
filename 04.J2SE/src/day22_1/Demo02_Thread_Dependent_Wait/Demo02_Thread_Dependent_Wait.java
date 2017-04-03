package day22_1.Demo02_Thread_Dependent_Wait;

public class Demo02_Thread_Dependent_Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Thread download = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				System.out.println("Download Thread: Start downloading image");
				for (int i = 0; i < 101; i++) {
					System.out.println("Download Thread: Completed "+ i+ "%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				System.out.println("Download Thread: Download completed!");
				System.out.println("Download Thread: download thread ends");
			}
		};
		
		Thread showImage = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				System.out.println("ShowImage Thread: Waiting for the download thread");
				try {
					/**
					 * join() will cause a block,which means showImage thread will not start
					 * until download thread ends ! Also download thread must be final, the
					 * issue we discuss before. Prevent other threads from disturbing it .
					 * 
					 * because showImage thread is depended on download
					 * 
					 */
					download.join();
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("ShowImage Thread: Start showing image!");
			}
		};
		showImage.start();
		download.start();
		
	}

}
