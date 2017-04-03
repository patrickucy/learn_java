package day22_2.Demo04_C_S_With_ThreadPool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 * client side
 * @author patrickyu
 *
 */
public class Client04 {

	private Socket socket;
	
	public Client04() {
		try {
			/**
			 *  instantiate socket, for connecting server side
			 *  ServerSocket
			 *  Parameter 1: Server IP address
			 *  			 localhost means current computer
			 *  Parameter 2: port of our server side
			 *  			 port # must be the same as the server side
			 *  
			 */
			socket = new Socket("localhost",8088);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	public void start(){
		try {
			/**
			 *  version 4.0
			 *  start a thread to receive the incoming data from server side
			 */
			GetServerInfoHandler handler = new GetServerInfoHandler();
			Thread t = new Thread(handler);
			t.setDaemon(true);
			t.start();
			
			
			
			/**
			 *  version 2.0
			 *  reader data from user keyboard input, and send them to server. and user
			 *  and do this over and over again
			 */
			
			Scanner scanner = new Scanner(System.in);
			
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
			/**
			 * we package it to a buffered character output stream
			 */
			PrintWriter writer = new PrintWriter(osw,true); // turn auto flush() on
			
			while(true){
				
				writer.println(scanner.nextLine());

			}
			
			
			
			
			
			
			
			
			
			
	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Client04 client = new Client04();
		client.start();
		
		
		
	}
	
	
	/**
	 * this thread is to read data coming from our server side,and print it out to our
	 * console
	 * @author patrickyu
	 *
	 */
	private class GetServerInfoHandler implements Runnable{
		public GetServerInfoHandler() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader reader = new BufferedReader(isr);
				
				/**
				 *  always listening what server send us
				 */
				while(true){
					String info = reader.readLine();
					if (info == null) {
						break;
					}
					
					System.out.println(reader.readLine());
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
}
