package dms.bo;
/**
 * define a class to describe your data record
 * 
 * one record of data represents several data, thus you need different properties to represent them
 * @author patrickyu
 *
 */
public class LogData {

	/**
	 *  define constant to be common properties
	 */
	
	
	public static final int LOG_LENGTH = 372;

	private String user;
	public static final int USER_OFFSET = 0;
	public static final int USER_LENGTH = 32;
	
	// process id
	private int pid;
	public static final int PID_OFFSET = 68;
	
	/**
	 *  log in type
	 *  there are a lot of types, but now we just care about log in and log out
	 *  it is the same length as "short" value
	 */
	private short type;
	public static final int TYPE_OFFSET = 72;
	// type log in value
	public static final short USER_PROCESS = 7;
	// type long out value
	public static final short DEAD_PREOCESS = 8;
	
	/** 
	 *  log in time, since 1970, in second
	 */
	private int time;
	public static final int TIME_OFFSET = 80;

	
	private String host;
	public static final int HOST_OFFSET = 114;
	public static final int HOST_LENGTH = 257;
	
	
	
	
	public LogData(String user, int pid, short type, int time, String host) {
		super();
		this.user = user;
		this.pid = pid;
		this.type = type;
		this.time = time;
		this.host = host;
	}
	
	
	// create a LogData object according to one line of log String 
	public LogData(String log){
		String[] data = log.split(",");
		this.user = data[0];
		this.pid = Integer.parseInt(data[1]);
		this.type = Short.parseShort(data[2]);
		this.time = Integer.parseInt(data[3]);
		this.host = data[4];
	}
	

	
	
	/**
	 * rewrite our toString method to show our data record
	 */
	@Override
	public String toString() {
		return "" + user + "," + pid + "," + type+ "," + time + "," + host;
	}



	/**
	 * properties setters and getters
	 * @return
	 */
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public short getType() {
		return type;
	}
	public void setType(short type) {
		this.type = type;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	
	
}








