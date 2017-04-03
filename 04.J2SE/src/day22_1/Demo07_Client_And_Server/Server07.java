package day22_1.Demo07_Client_And_Server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server side
 * @author patrickyu
 *
 */
public class Server07 {
	
	private ServerSocket server;

	public Server07() {
		try {
			/**
			 *  instantiate a serverSocket and specify a service port
			 */
			System.out.println("Start server...");
			server = new ServerSocket(8088);
			
			System.out.println("Server is ready...");
			System.out.println("Waiting for connection from client...");
			
			
			/**
			 *  socket accept()
			 *  this method is a block, it will wait for client socket, only then
			 *  it will return value, the return value is the Socket of this server
			 */
			Socket socket = server.accept();
			
			System.out.println("A client connected!");
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);
			String info = reader.readLine();
			System.out.println("Client says: "+ info);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
		Server07 server = new Server07();
		
	}
	
	

}
