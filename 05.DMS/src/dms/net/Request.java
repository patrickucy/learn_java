package dms.net;

import java.util.List;

import dms.bo.LogRec;

/**
 * this is a class describing a data bundle to be sent to sever
 * @author patrickyu
 *
 */
public class Request {
	
	private long time;
	private String ip;
	private List<LogRec> data;
	

	public Request(long time, String ip, List<LogRec> data) {
		super();
		this.time = time;
		this.ip = ip;
		this.data = data;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public List<LogRec> getData() {
		return data;
	}
	public void setData(List<LogRec> data) {
		this.data = data;
	}
	
}
