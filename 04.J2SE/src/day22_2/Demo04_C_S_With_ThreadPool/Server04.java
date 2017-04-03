package day22_2.Demo04_C_S_With_ThreadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Server side
 * @author patrickyu
 *
 */
public class Server04 {
	
	private ServerSocket server;
	private ExecutorService threadPool;
	
	/**
	 *  we need this collection to be thread safe
	 *  it stores all output stream to out clients
	 */
	private Vector<PrintWriter> allOut;
	
	public Server04() {
		try {
			/**
			 *  instantiate a serverSocket and specify a service port
			 */
			System.out.println("Start server...");
			
			// initialization
			allOut = new Vector<PrintWriter>();
			threadPool = Executors.newCachedThreadPool();
			server = new ServerSocket(8088);
			
			System.out.println("Server is ready...");		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/**
	 * add a client output stream to a shared collection(Vector)
	 * why bother to have this function ?
	 * @param writer
	 */
	public void addClientOut(PrintWriter writer){
		allOut.add(writer);
	}
	
	public void removeClientOut(PrintWriter writer){
		allOut.remove(writer);
	}
	
	
	public void sendMsgToAllClients(String msg){
		/**
		 *  iterate every client output stream 
		 */
		for (PrintWriter writer : allOut) {
			writer.println(msg);
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
				
				
				String hostName = socket.getInetAddress().getHostName();
				String address = socket.getInetAddress().getHostAddress();
				System.out.println("HostName: "+ hostName + "\tAddress: " + address);
				
				
				/**
				 * create a new thread, to server this new client
				 */
				GetClientInfoHandler handler = new GetClientInfoHandler(socket);
				/**
				 * Old version 3.0
				 */
//				Thread t = new Thread(handler);
//				t.start();
				
				
				/**
				 *  assign a task to thread pool. let it to distribute threads for us to do the job
				 */
				threadPool.execute(handler);
			}
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server04 server = new Server04();
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
			
			// ourput stream to our client
			PrintWriter writer = null;
			/**
			 *  in a thread, 
			 */
			
			
			
			try {
				
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader reader = new BufferedReader(isr);
				
				/**
				 * version 4.0
				 * createwriter
				 */
				OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(),"UTF-8");
				writer = new PrintWriter(osw,true);
				addClientOut(writer);
				
				
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
					sendMsgToAllClients("Server: \""+info+"\"");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally{
				try {
					
					/**
					 * version 4.0
					 * before you close your socket connection, you need to delete the writer stream in
					 * our Vector<PrintWriter> 
					 */
					if (writer !=null) {
						removeClientOut(writer);
						
					}
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
