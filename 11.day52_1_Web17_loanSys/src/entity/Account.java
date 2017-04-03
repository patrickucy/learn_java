package entity;

public class Account {

	private int id;
	private String accountNo;
	private double balance;
	
	
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNo=" + accountNo + ", balance="
				+ balance + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
