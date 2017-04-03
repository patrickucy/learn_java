package dms.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import dms.bo.LogRec;

/**
 * for communication between server and client 
 * @author patrickyu
 *
 */
public class NetService {
	
	private static NetService instance = new NetService();
	private NetService(){};
	public static NetService getInstance(){
		return instance;
	}
	
	
	public void sendRequest(Socket socket, Request request) throws IOException {
		OutputStream out = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(out);
		
		/**
		 *  write data in Request
		 */
		writer.println(request.getTime());
		writer.println(request.getIp());
		// write the size of such log data
		writer.println(request.getData().size());
		for(LogRec logRec : request.getData()){
			writer.println(logRec.toString());
			System.out.println("sending log: "+ logRec.getLogin().getUser());
		}
		writer.flush();
		
		/**
		 * attention! don't user writer.close() here
		 * writer will be collected by GC when it ends
		 * 
		 * because you don't want to close the low-level IOStream, otherwise it will end the connection between client and server
		 */
	}
	
	
	/**
	 *  just like the method above. but this time it is to receive request 
	 * @param socket
	 * @return
	 */
	public Request receiveRequest(Socket socket) throws IOException{
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		long time = Long.parseLong(reader.readLine());
		String ip = reader.readLine();
		int size = Integer.parseInt(reader.readLine());
		List<LogRec> list = new ArrayList<LogRec>();
		for (int i = 0; i < size; i++) {
			LogRec logRec = new LogRec(reader.readLine());
			list.add(logRec);
		}
		Request request = new Request(time, ip, list);
		return request;
	}
	
	public Response receiveResponse(Socket socket) throws IOException{
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader reader = new BufferedReader(isr);
		
		
		long time = Long.parseLong(reader.readLine());
		int state = Integer.parseInt(reader.readLine());
		Response response = new Response(time,state);
		return response;	
		/**
		 * don't close low-level IOStream
		 */
	}
	
	/**
	 * send Socket and get an inputStream, and send data out
	 */
	public void sendResponse(Socket socket, Response response) throws IOException{
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		writer.println(response.getTime());
		writer.println(response.getState());
		writer.flush();
	}
}
