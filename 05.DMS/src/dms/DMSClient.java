package dms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dms.bo.LogData;
import dms.bo.LogRec;
import dms.net.NetService;
import dms.net.Request;
import dms.net.Response;
import dms.util.Utils;

/**
 * this client is to parse unix log file, do data paring 
 * then send these paired data to server
 * @author patrickyu
 *
 */
public class DMSClient {

	/**
	 * dms ip and its port
	 */
	private String dmsServerHost;
	private int dmsServerPort;
	
	/**
	 * current host of this machine
	 */
	private String serverHost;
	
	/**
	 *  unix log file wtmpx
	 */
	private File logFile;


	/**
	 *  store data to a temporary file, 10 lines of log every time
	 */
	private File tempLogFile;


	/**
	 *  parse to be some file we can interpret
	 */
	private File textLogFile;


	/**
	 * successfully paired data
	 */
	private File logRecFile;


	/**
	 * not successfully pair data
	 */
	private File loginLogFile;


	/**
	 *  after you read 10 lines of log data, you need to store the position of your 
	 *  cursor in order to be used next time, thus you won't need to read data from 
	 *  scratch, just start with where you leftover last time
	 */
	private File LastPositionFile;


	/**
	 *  how many lines of log you want to read at each time. our default is 10. If 
	 *  you want to read more data at each time, you could just adjust this 
	 *  value later. Thus, you can tune your system dynamically.
	 */
	private int batch;


	/**
	 *  in one machine, we just need one client to collect log data, so we can define it
	 *  as a singleton
	 */
	private static DMSClient instance =  new DMSClient();
	private DMSClient(){
		/**
		 *  initialization in constructor
		 *  new -> memory allocation
		 *  constructor -> initialize data
		 */
		initConfig();
	}
	public static DMSClient getInstance(){
		return instance;
	}


	/**
	 *  initialization
	 */
	private void initConfig(){
		try {
			/**
			 * initialize all properties
			 */
			dmsServerHost = "localhost";
			dmsServerPort = 8088;
			
			serverHost = "192.168.1.23";
			batch = 10;
			logFile = new File("wtmpx");
			tempLogFile = new File("temp.log");
			LastPositionFile = new File("last_postion.txt");
			textLogFile = new File("log.txt");
			logRecFile = new File("logrec.txt");
			loginLogFile = new File("login.txt");


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 *  step 2:
	 *   this method transform a file of binary log content to a LogData object, and user to String to write
	 *   it to our log.txt file 
	 */
	public boolean parseLogs(){

		if(textLogFile.exists()){
			System.out.println(textLogFile + ": textLogFile exists");
			return true;
		}

		// if we don't have this temp file, then we can't do our parse
		if(!tempLogFile.exists()){
			System.out.println("you need a temporary log file "+ tempLogFile);
			return false;
		}

		/**
		 * read data from temp file one by one, transform LogData and use toString() method. take this returned string and 
		 * write it to "log.txt" file 
		 * done our parse task 
		 */
		FileInputStream in = null;
		PrintWriter out = null;

		try {
			in = new FileInputStream(tempLogFile);
			out  = new PrintWriter(textLogFile);
			byte[] log = new byte[LogData.LOG_LENGTH];
			int len = -1;
			// read 372byte data from temp file
			while ((len = in.read(log)) != -1){
				LogData logData = parseLog(log);
				out.println(logData.toString());
			}

			/**
			 * when we got temp data we needed, we need to delete it
			 * 
			 * during a IOStream you can't delete a file, we should delete after we close the IOStream
			 * 
			 */
			//			tempLogFile.delete();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			/**
			 *  when we have a exception during parsing, then the information in "log.txt" file is invalid.
			 *  thus, we need to delete it
			 */
			if(textLogFile.exists()){
				textLogFile.delete();
			}
			return false;
		} finally {
			try {
				if ( in != null){
					in.close();
				}


				/**
				 *  if we fianlly have our "log.txt" then the temp file will no longer be needed
				 */
				if(tempLogFile.exists()){
					tempLogFile.delete();
				}

				if( out != null){
					out.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	private LogData parseLog(byte[] log){
		String user = Utils.toString(log, LogData.USER_OFFSET, LogData.USER_LENGTH);
		int pid = Utils.toInt(log, LogData.PID_OFFSET);
		short type = Utils.toShort(log, LogData.TYPE_OFFSET);
		int time = Utils.toInt(log, LogData.TIME_OFFSET);
		String host = Utils.toString(log, LogData.HOST_OFFSET, LogData.HOST_LENGTH);

		return new LogData(user, pid, type, time, host);
	}




	/** 
	 * step 3:
	 * 		parse data from "log.txt" file and pair data. Put pairable data to logrec.txt, othwise, to login.txt
	 */
	public boolean matchLogs(){
		if(logRecFile.exists()){
			System.out.println("File exists: "+ logRecFile);
			return true;
		}

		if(!textLogFile.exists()){
			System.out.println("File doesn't exist: "+ textLogFile);
			return false;
		}

		/**
		 * start pairing data in "log.txt"
		 * read data in "log.txt", parse them to LogData object,and put them to collection.
		 * thus, we have all our data
		 */
		List<LogData> list  = loadLogData(tempLogFile);
		
		List<LogData> loginList = new ArrayList<LogData>();
		
		/**
		 * check the data that were not paired previously if still exists, if it exists
		 * we need to add these data to our list collection to participate this new round 
		 * of pairing  
		 */
		if(loginLogFile.exists()){
			list.addAll(loadLogData(loginLogFile));
			
		}
		
		// matched data (pairs)
		List<LogRec> matched = new ArrayList<LogRec>();
		
		for(LogData logData : list){
			if(logData.getType() == LogData.USER_PROCESS){
				// find corresponding logout info and match them as a pair
				LogRec logRec = matchLogout(logData, list);
				if(logRec != null){
					// matched successfully
					matched.add(logRec);
				}else{
					// fail to match
					loginList.add(logData);
				}
			}
		}
		/**
		 * write these two data to two different files
		 */
		try {
			Utils.saveList(logRecFile, matched);
			Utils.saveList(loginLogFile, loginList);
			// after you pair everything you need to delete the original log file
			textLogFile.delete();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(logRecFile.exists()){
				logRecFile.delete();
			}
		}
		

		return false;
	}
	
	
	
	private LogRec matchLogout(LogData login, List<LogData> list){
		
		for (LogData log : list){
			/**
			 * query if this log is match our current login
			 */
			if(log.getType() != LogData.DEAD_PREOCESS){
				continue;
			}
			if(!login.getUser().equals(log.getUser())){
				continue;
			}
			if(login.getPid() != log.getPid()){ 
				continue;
			}
			if(!login.getHost().equals(log.getHost())){
				continue;
			}
			
			LogRec logRec = new LogRec(login, log, serverHost);
			return logRec;
		}
		
		// after we query every requirement, if all of them don't satisfy, then it must be no such pair available 
		return null;
	}

	/**
	 * load data from file and parse them to LogData object
	 * @param file
	 * @return
	 */
	private List<LogData> loadLogData(File file){
		BufferedReader reader = null;
		try {
			ArrayList<LogData> list = new ArrayList<LogData>();

			reader = new BufferedReader(new FileReader(textLogFile));
			String log = null;
			while ((log = reader.readLine()) != null){
				list.add(new LogData(log));

			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			if(reader !=null){
				try {
					reader.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * read data from wtmpx file with batch lines of data to temp file
	 * @return true: successfully generating those data
	 */
	public boolean readNextLogs(){
		/**
		 *  we first query if we have the temporary file.
		 */
		if(tempLogFile.exists()){
			return true;
		}

		/**
		 *  we still need to query if our unix log file exist.
		 *  if not, we will have no way to read the data from it.
		 *  
		 *  we still need to query if we have already reach the end of our source file. Because in this method
		 *  we will be only reading new content.
		 */
		if(!hasLogs()){
			// no new content available 
			return false;
		}


		/**
		 * next, we just need to read data from our log file and generate a temporary file
		 */
		RandomAccessFile in = null;
		FileOutputStream out = null;
		int num = 0;
		try {
			long lastPosition = 0;
			if (LastPositionFile.exists()) {
				lastPosition = Utils.readInt(this.LastPositionFile);		
			}

			/**
			 *  create RandomAccessFile to read data 
			 */
			in = new RandomAccessFile(logFile, "r");
			out = new FileOutputStream(tempLogFile);

			/**
			 * create a byte[] as buffer. and its length is one line of log data 
			 */
			byte[] log = new byte[LogData.LOG_LENGTH];
			int len = -1; // actual data readed from file

			num = 0; // record how many times you just read
			/**
			 * adjust your cursor to the last position, then start reading data
			 */
			in.seek(lastPosition);
			while ( (len = in.read(log)) != -1) {
				/**
				 *  once we read our log, we write data to temp file
				 */
				out.write(log);
				num ++;
				if(num == batch){
					break;
				}
			}

			/**
			 *  After you copy, you store current position of our cusor
			 */
			lastPosition = in.getFilePointer();
			Utils.saveInt(LastPositionFile, (int)lastPosition);




		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			/**
			 * if we get a problem while generating temporary file, we need to delete our temporary file 
			 * immediately. because it's invalid data now.
			 * 
			 */
			if(tempLogFile.exists()){
				tempLogFile.delete();
			}
			return false;
		} finally {
			try {
				in.close();
				out.close();
				System.out.println("Copied " + num +" records to file");

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return true;


	}

	/**
	 * this method is to check if the wtmpx file still exist, and check if we have new content according to our cursor
	 * position
	 * @return
	 */
	private boolean hasLogs(){

		if(!logFile.exists()){
			throw new RuntimeException("Log file doesn't exist: "+logFile.getAbsolutePath());

		}

		// cursor position
		int lastPosition = 0;
		if (LastPositionFile.exists()){
			/**
			 * if this cursor file exists, we read the position of this cursor and assign its value to 
			 * our variable "lastPosition"
			 */
			lastPosition = Utils.readInt(this.LastPositionFile);

		}


		// this means our log file contains new content
		return logFile.length() > lastPosition;

	}




	
	
	
	/**
	 * step 4:
	 * 		send paired data to server
	 */
	public boolean sendLogs(){
		if(!logRecFile.exists()){
			System.out.println("no available data to be sent to server");
			return true;
		}
		
		/**
		 * read all successfully paired data from file
		 */
		List<LogRec> data = loadRecData(logRecFile);
		Socket socket = null;
		try {
			/**
			 * 3 parts needed to be sent
			 * 		1: send the current system time
			 * 		2: send data host (serverHost)
			 * 		3: paired data
			 */
			socket = new Socket(dmsServerHost, dmsServerPort);
			
			Request request = new Request(System.currentTimeMillis(), serverHost, data);
			NetService net = NetService.getInstance();
			System.out.println("sending request to server...");
			net.sendRequest(socket, request);
			
			System.out.println("sending request ends");
			
			/**
			 * waiting for server responds
			 * 		1: the time when data being sending back from server
			 * 		2: if our server process our data successfully
			 * 
			 */
			Response response = net.receiveResponse(socket);
			
			if(response.getState() == Response.OK){
				logRecFile.delete();
				System.out.println("Server has handled correctly");
				return true;
			}else{
				System.out.println("Server has encouter a failure");
				return false;
			}

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	// load rec data from file and return it as a list
	private List<LogRec> loadRecData(File file){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			ArrayList<LogRec> list = new  ArrayList<LogRec>();
			String log = null;
			while ((log = reader.readLine()) != null){
				list.add(new LogRec(log));
			}
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}


	/**
	 * client start to parse unix log file and generate paired file
	 * 
	 */
	public void process(){
		
		while(true){
			/**
			 * step 1: 
			 * 		read 10 lines of log from unix log file and store them to our tempLogFile
			 */
			if (readNextLogs()) {
				// succeed
			} else {
				// fail
			}


			/**
			 * step 2:
			 * 		parse every record from our temp file and transform them to information we can understand
			 */
			if(parseLogs()){
				// succeed
			}else{
				// fail
			}


			/**
			 * step 3:
			 * 		pair records in our log.txt, put successful pairs to "logrec.txt" and put
			 * 	unpaired data to login.txt waiting for next pairing
			 */
			if(matchLogs()){
				// succeed 
			}else{
				// fail
			}
			
			
			
			/**
			 * step 4:
			 * 		send these paired data to server
			 */
			if(sendLogs()){
				// succeed
			}else{
				// fail
			}
			
			
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}




	public static void main(String[] args) throws IOException {
		DMSClient client = DMSClient.getInstance();
		client.process();


	}
}




















