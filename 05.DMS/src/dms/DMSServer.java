package dms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import dms.bo.LogRec;
import dms.net.NetService;
import dms.net.Request;
import dms.net.Response;

/**
 * to receive data from client and store them to file 
 * @author patrickyu
 *
 */
public class DMSServer {

	private static DMSServer instance =  new DMSServer();
	private DMSServer(){
		initConfig();
	}
	public static DMSServer getInstance(){
		return instance;
	}
	
	
	private ServerSocket serverSocket;
	
	/**
	 * thread pool
	 * you need different thread to handle different tasks
	 */
	private ExecutorService threadPool;
	
	/**
	 * file to store data from client
	 */
	private File serverLogRecFile;
	
	/**
	 * server port
	 */
	private int serverPort;
	
	/**
	 * greate a deque for handling messages from multiple clients and write them to file 
	 */
	private BlockingDeque<LogRec> logRecQueue;
	
	
	/**
	 * initialize properties of our DMSServer
	 */
	private void initConfig(){
		try {
			serverLogRecFile = new File("server_logrec.txt");
			threadPool = Executors.newCachedThreadPool();
			logRecQueue = new LinkedBlockingDeque<LogRec>();
			serverPort = 8088;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	public void start(){
		try {
			serverSocket = new ServerSocket(serverPort);
			
			/**
			 * we need to start a thread, reading data from our queue in a while loop
			 */
			Timer timer = new Timer();
			
			/**
			 * get data from deque and start writing data to file, and do this periodically 
			 * every 5 seconds, in order to let deque buffer its data
			 */
			timer.schedule(new SaveProcess(), 0, 5000);
			
			
			/**
			 * monitoring connection to client in a while loop
			 */
			while(true){
				System.out.println("waiting for client connection...");
				Socket socket = serverSocket.accept();
				System.out.println("One client just connected");
				threadPool.execute(new ReceiveProcess(socket));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	/*************************************************************************************/
	public static void main(String[] args) {
		DMSServer server = DMSServer.getInstance();
		server.start();
	}
	
	
	
	/**
	 * save data to file periodically 
	 * @author patrickyu
	 *
	 */
	private class SaveProcess extends TimerTask {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			BufferedWriter writer = null;

			try {
				if(!serverLogRecFile.exists()){
					serverLogRecFile.createNewFile();
				}
				
				/**
				 * the issue of using printWriter is that it will erase previous data in that file. 
				 */
//				writer = new PrintWriter(new FileOutputStream(serverLogRecFile),true);
				
				/**
				 * the problem for this outputStream is that it always write data from scratch, but if you add a option
				 * telling FileOutputStream to add content from the end of the existing data, then problem solved!
				 * 
				 * solution: fileOutputStream (true) means you write data to file from the end of existing content
				 */
				writer = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(serverLogRecFile,true))));
				
				while(!logRecQueue.isEmpty()){
					LogRec logRec = logRecQueue.poll();
					writer.write(logRec.toString());
					writer.newLine();
					System.out.println("timer: one record of data has just been written");
					System.out.println(logRec);
					writer.flush();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * this thread is to receive a message sended from client , and put every of them to a 
	 * log info Deque
	 */
	private class ReceiveProcess implements Runnable{
		private  Socket socket;
		
		public ReceiveProcess(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				/**
				 * read data from our client 
				 * it is three parts:
				 * 1: time
				 * 2: ip
				 * 3: all paired log info
				 */
				NetService net = NetService.getInstance();
				Request request = net.receiveRequest(socket);
				/**
				 * get all paired data from log info
				 */
				List<LogRec> list = request.getData();
				
				System.out.println("Data size from client: " +list.size());
				
				for(LogRec logRec : list){
//					while(!logRecQueue.offer(logRec)){
//						/**
//						 *  this means if you fail to offer, it will continue offer until it's successful
//						 */
//					}
					
					/**
					 * if not successful, it will offer 1 second later. the same mechanism as above while loop
					 * para 1: element
					 * para 2: time 
					 * para 3: time unit
					 */
					while(!logRecQueue.offer(logRec, 1, TimeUnit.SECONDS));
					
				}
				System.out.println("Data size of current deque: "+logRecQueue.size());
				/**
				 * now we've add every elements to our deque
				 */
				Response response = new Response(System.currentTimeMillis(),Response.OK);
				
				// send response
				net.sendResponse(socket, response);
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				Response response = new Response(System.currentTimeMillis(), Response.ERROR);
				try {
					// this is a singleton, you can just use it like this 
					NetService.getInstance().sendResponse(socket, response);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} finally {
				if(socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		
		
	}
	
	
}













