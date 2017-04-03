package entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity (name="user_details")
//@Table (name="user_details")  // this is a table alone
public class UserDetails {

	@Id
	@Column (name="user_id")
	/** 
	 * this means it will let the db to generate this for us(sequence in oralce)
	 * its default is AUTO,  IDENTITY means fill the id colomn in mysql,oralce,
	 * SEQUENCE means hibernate_sequence in oracle, TABLE means separate table to 
	 * maintain the id , AUTO is recommended, and it's default
	 */
	@GeneratedValue (strategy=GenerationType.AUTO)   	
	private int userId; // treat this as primary key
	
	@Basic ()                      
	private String userName;
	
	
	/**
	 * hibernate will only persist the date and exclude the time,
	 * and vice versa. this default is timestamp
	 */
	@Temporal (TemporalType.DATE)   
	private Date joinedDate;
	private String address;
	
	
	/**   
	 * hibernate default save string as varchar(255), what if here is a long 
	 * text, thus you need this annotation to tell it's a large object. thus 
	 * it will no longer be limited to varchar(255)
	 */
	@Lob
	private String description;
	
	
	/**
	 * static property will not be persisted in hibernate,i
	 * t makes not sense if every object share this property
	 */
	private static String staticVar; 
	
	
	/**
	 * adding transient annotation here, this property will not be persisted to 
	 * database, but it's still available within the java side
	 */
	@Transient
	private static String notPersistedVar;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * any modification here in the getter will actually affect hibernate to 
	 * create a table for you. it's because hibernate fundamentally use getter 
	 * to decide how to create such table
	 * 
	 * just don't do this, declaring this annotation right at the property is 
	 * more than enough
	 * @param userName
	 */
	@Column (name="user_name") 
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName
				+ ", joinedDate=" + joinedDate + ", address=" + address
				+ ", description=" + description + "]";
	}
	
	
	
	
}
