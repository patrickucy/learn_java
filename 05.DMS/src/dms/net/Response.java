package dms.net;
/**
 * server responds
 * @author patrickyu
 *
 */
public class Response {

	/**
	 * responding time
	 */
	private long time;
	
	/**
	 * state for server
	 */
	private int state;
	
	public static final int OK = 200;
	public static final int ERROR = 500;
	
	/**
	 *  if you define a constructor yourself, then the default constructor will 
	 *  on longer be available,thus, you might need to define it again by yourself
	 */
	public Response(){};
	public Response(long time, int state) {
		super();
		this.time = time;
		this.state = state;
	}
	
	
	/**
	 * getter and setter
	 * @return
	 */
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	};
	
	
	
}
