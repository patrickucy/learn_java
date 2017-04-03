package day21.Demo07_Thread_Interruption;
/**
 * 
 * @author patrickyu
 *
 * interrupt a sleep block, causing a InterruptionException
 */
public class Demo07_Thread_Interruption {
	
	public static void main(String[] args) {
		
		/**
		 *  this class in fact is defined within main()
		 *  we call this local anonymous internal class
		 *  
		 *  we have to use final here!!!!!!!!!!
		 *  because if you want to refer a local variable in a local internal class
		 *  semantic requires you to do so
		 */
		final Thread lin = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("lin: I just done doing my facial, I gonna go to sleep right now");
				try {
					Thread.sleep(10000000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					System.out.println("What the hell! What the hell! What the hell! You just ruin my face");
				}
				
			}
		});
		
		/**
		 *  huang hong  for thread interruption
		 */
		Thread huang = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hunang: start detroy the wall!");
				
				for (int i = 0; i < 5; i++) {
					System.out.println("Huang: 80!");
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println("Huang: done!");
				System.out.println("Duang! duang! duang!");
				
				
				/**
				 * we call a method to interrupt lin's thread
				 * there is a compile error
				 * 
				 * this lin must be a final !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				 * because if you want to refer a local variable in a local internal class,
				 * java semantic requires you to define that local variable to be "final"
				 */
				lin.interrupt();
				
			}
		});
		
		
		lin.start();
		huang.start();
	}
	
}
