package day22_2.Demo01_Client_And_Server_More;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * client side
 * @author patrickyu
 *
 */
public class Client01 {

	private Socket socket;
	
	public Client01() {
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
			 *  v
			 */
			OutputStream out = socket.getOutputStream();
			/**
			 * we package it to a buffered character output stream
			 */
			PrintWriter writer = new PrintWriter(out);
			writer.println("what the fuck server ??");
			/**
			 *  without this flush() message will not be sent, because it will be store 
			 *  in the buffer
			 */
			writer.flush();
			
			
			
			
			
			
			
			
			
			
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);
			String line = reader.readLine();
			System.out.println(line);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Client01 client = new Client01();
		client.start();
		
	}
}
