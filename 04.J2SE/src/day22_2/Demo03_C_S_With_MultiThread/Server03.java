package day22_2.Demo03_C_S_With_MultiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server side
 * @author patrickyu
 *
 */
public class Server03 {
	
	private ServerSocket server;

	public Server03() {
		try {
			/**
			 *  instantiate a serverSocket and specify a service port
			 */
			System.out.println("Start server...");
			server = new ServerSocket(8088);
			
			System.out.println("Server is ready...");		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public void start(){
		try {
			
			/**
			 *  socket accept()
			 *  this method is a block, it will wait for client socket, only then
			 *  it will return value, the return value is the Socket of this server
			 *  
			 *  
			 *  Accept() is monitoring the port "8088", in fact you can call accept() 
			 *  multiple times. That means we need a while-loop here keep monitoring 
			 *  for new users. Thus, multi-thread is needed in this situation
			 */
			
			
			/**
			 *  version 3.0
			 *  if we want to serve multiple users, we will have to call accept() iteratively
			 *  Only in this way can it discover new coming users. Now that, we have a infinite 
			 *  while-loop here, we can do interaction with users, thus we need the multi-thread 
			 *  strategy to solve this problem
			 */
			
			while(true){
				System.out.println("Waiting for connection from client...");
				Socket socket = server.accept();
				System.out.println("A client connected!");
				
				/**
				 * create a new thread, to server this new client
				 */
				GetClientInfoHandler handler = new GetClientInfoHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server03 server = new Server03();
		server.start();
	}
	
	
	
	/**
	 * internal class 
	 * this thread is in fact a distributor. it's job is to specify which thread will be serving
	 * the new coming client
	 * @author patrickyu
	 *
	 */
	private class GetClientInfoHandler implements Runnable {
		private Socket socket;
		
		public GetClientInfoHandler(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			/**
			 *  in a thread, 
			 */
			try {
				
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader reader = new BufferedReader(isr);
				
				
				OutputStream out = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(out,true);
				/**
				 * version 2.0
				 */
				while(true){
					String info = reader.readLine();
					if(info == null){
						throw new RuntimeException("Client connection exception");
					}
					System.out.println("Client: "+ info);
					
					/**
					 *  say things back to client
					 */
					writer.println("Server: hello client! you just said \""+info+"\"");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally{
				try {
					/**
					 *  close connection with user
					 *  if you close the socket, it will automatically close inputOutputStream for us.
					 *  otherwise, you need to keep this input stream open to accept data from user
					 */
					 
					
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	

}
