package day22_1.Demo07_Client_And_Server;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * client side
 * @author patrickyu
 *
 */
public class Client07 {

	private Socket socket;
	
	public Client07() {
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
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
		
		Client07 client = new Client07();
		
	}
}
