package day22_2.Demo02_C_S_With_UserInput;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 * client side
 * @author patrickyu
 *
 */
public class Client02 {

	private Socket socket;
	
	public Client02() {
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
			 *  version 2.0
			 *  reader data from user keyboard input, and send them to server. and user
			 *  and do this over and over again
			 */
			
			Scanner scanner = new Scanner(System.in);
			
			OutputStream out = socket.getOutputStream();
			/**
			 * we package it to a buffered character output stream
			 */
			PrintWriter writer = new PrintWriter(out,true); // turn auto flush() on
			
			while(true){
				
				writer.println(scanner.nextLine());

			}
			
			
			
			
			
			
			
			
			
			
			
//			InputStream in = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader reader = new BufferedReader(isr);
//			String line = reader.readLine();
//			System.out.println(line);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Client02 client = new Client02();
		client.start();
		
	}
}
