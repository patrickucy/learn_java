package day22_2.Demo01_Client_And_Server_More;

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
public class Server01 {
	
	private ServerSocket server;

	public Server01() {
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
			 */
			Socket socket = server.accept();
			
			System.out.println("A client connected!");
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);
			String info = reader.readLine();
			System.out.println("Client says: "+ info);
			
			
			/**
			 *  say things back to client
			 */
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			writer.println("hello client! you are stupid!");
			writer.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server01 server = new Server01();
		server.start();
	}
	
	

}
