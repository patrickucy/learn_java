package dms.bo;
/**
 * a pair of log info (successfully paired)
 * @author patrickyu
 *
 */
public class LogRec {

	private LogData login;
	private LogData logout;
	
	// the machine collecting these login and login info
	private String serverHost;

	public LogRec(LogData login, LogData logout, String serverHost) {
		super();
		
		/**
		 * given a pair of login and logout info, you need to check their correctness.
		 */
		if(login.getType() !=  LogData.USER_PROCESS){
			throw new RuntimeException("not a log in info");
		}
		if(logout.getType() != LogData.DEAD_PREOCESS){
			throw new RuntimeException("not a log out info");
		}
		if(!login.getUser().equals(logout.getUser())){
			throw new RuntimeException("not the same user");
		}
		if(login.getPid() != logout.getPid()){
			throw new RuntimeException("not the same process");	
		}
		if(!login.getHost().equals(logout.getHost())){
			throw new RuntimeException("not the same machine");
		}
		
		
		this.login = login;
		this.logout = logout;
		this.serverHost = serverHost;	
	}
	
	
	//given a String, we create a LogRec object
	public LogRec(String str){
		String[] ary = str.split("\\|");
		this.login = new LogData(ary[0]);
		this.logout = new LogData(ary[1]);
		this.serverHost = ary[2];
		
		
	}

	/**
	 * this toString() is to describe a pair of info, and save them to "logrec.txt" as a pair of info
	 * 
	 */
	@Override
	public String toString() {
		return login.toString() + "|" +logout.toString() +"|"+ serverHost;
	}

	
	
	/**
	 * getter and setter
	 * @return
	 */
	public LogData getLogin() {
		return login;
	}

	public void setLogin(LogData login) {
		this.login = login;
	}

	public LogData getLogout() {
		return logout;
	}

	public void setLogout(LogData logout) {
		this.logout = logout;
	}

	public String getServerHost() {
		return serverHost;
	}

	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}
	
	
}
