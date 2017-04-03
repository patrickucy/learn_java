package entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
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
	@GeneratedValue (strategy=GenerationType.AUTO)   	
	private int userId; // treat this as primary key
	
	/**
	 * also this user might have multiple ids
	 * we can use this as follow
	 * this object also must Embeddable
	 */
//	@EmbeddedId
//	private LoginName userId
	
	
	@Basic ()                      
	private String userName;
	

	@Temporal (TemporalType.DATE)   
	private Date joinedDate;
	
	
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride (name="street",column=@Column (name="home_street_name")),
		@AttributeOverride (name="city",column=@Column (name="home_city_name")),
		@AttributeOverride (name="state",column=@Column (name="home_state_name")),
		@AttributeOverride (name="zipcode",column=@Column (name="home_zip_code"))
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
	
	

	@Lob
	private String description;
	
	private static String staticVar; 
	
	@Transient
	private static String notPersistedVar;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static String getStaticVar() {
		return staticVar;
	}
	public static void setStaticVar(String staticVar) {
		UserDetails.staticVar = staticVar;
	}
	public static String getNotPersistedVar() {
		return notPersistedVar;
	}
	public static void setNotPersistedVar(String notPersistedVar) {
		UserDetails.notPersistedVar = notPersistedVar;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName
				+ ", joinedDate=" + joinedDate + ", homeAddress=" + homeAddress
				+ ", officeAddress=" + officeAddress + ", description="
				+ description + "]";
	}
	
	
	
	
	
	
	
}
