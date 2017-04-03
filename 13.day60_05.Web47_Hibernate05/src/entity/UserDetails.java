package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity (name="user_details")
//@Table (name="user_details")  // this is a table alone
public class UserDetails {

	@Id
	@Column (name="user_id")
	@GeneratedValue (strategy=GenerationType.AUTO)   	
	private int userId; // treat this as primary key
	
	private String userName;
	
	
	
	/**
	 * only those collections have index can have a collectionid annotation
	 * 
	 * this fetch type eager means, it will not do the lazy initialization- fetch data all at once, but it is 
	 * lazy by default, which is also recommended
	 */
	@ElementCollection (fetch=FetchType.EAGER)
	@JoinTable (name="user_address", joinColumns=@JoinColumn(name="user_id"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>(); // hibernate just create a subtable for this property
	
	
	
	
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
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName
				+ ", listOfAddresses=" + listOfAddresses + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
