package day22_2.Demo02_C_S_With_UserInput;

import java.io.BufferedReader;
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
public class Server02 {
	
	private ServerSocket server;

	public Server02() {
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
			System.out.println("Waiting for connection from client...");
			
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
			
			Socket socket = server.accept();
			
			System.out.println("A client connected!");
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
				System.out.println("Client: "+ info);
				
				/**
				 *  say things back to client
				 */
				writer.println("Server: hello client! you just said \""+info+"\"");
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server02 server = new Server02();
		server.start();
	}
	
	

}
