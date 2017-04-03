package com.patrick.entity;

import java.util.Date;

public class Account {
	private int id;
 	private int recommenderId;
 	private String loginName;
 	private String loginPasswd;
 	private String status;
 	private Date createDate;
 	private Date pauseDate;
 	private Date closeDate;
 	private String realName;
 	private String idcardNo;
 	private Date birthdate;
 	private String gender;
 	private String occupation;
 	private String telephone;
 	private String email;
 	private String mailaddress;
 	private String zipcode;
 	private String qq;
 	private Date lastLoginTime;
 	private String lastLoginIp;
 	
 	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRecommenderId() {
		return recommenderId;
	}
	public void setRecommenderId(int recommenderId) {
		this.recommenderId = recommenderId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPasswd() {
		return loginPasswd;
	}
	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getPauseDate() {
		return pauseDate;
	}
	public void setPauseDate(Date pauseDate) {
		this.pauseDate = pauseDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMailaddress() {
		return mailaddress;
	}
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
	public Account() {
		super();
	}
	
	public Account(int id, int recommenderId, String loginName,
			String loginPasswd, String status, Date createDate, Date pauseDate,
			Date closeDate, String realName, String idcardNo, Date birthdate,
			String gender, String occupation, String telephone, String email,
			String mailaddress, String zipcode, String qq, Date lastLoginTime,
			String lastLoginIp) {
		super();
		this.id = id;
		this.recommenderId = recommenderId;
		this.loginName = loginName;
		this.loginPasswd = loginPasswd;
		this.status = status;
		this.createDate = createDate;
		this.pauseDate = pauseDate;
		this.closeDate = closeDate;
		this.realName = realName;
		this.idcardNo = idcardNo;
		this.birthdate = birthdate;
		this.gender = gender;
		this.occupation = occupation;
		this.telephone = telephone;
		this.email = email;
		this.mailaddress = mailaddress;
		this.zipcode = zipcode;
		this.qq = qq;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", recommenderId=" + recommenderId
				+ ", loginName=" + loginName + ", loginPasswd=" + loginPasswd
				+ ", status=" + status + ", createDate=" + createDate
				+ ", pauseDate=" + pauseDate + ", closeDate=" + closeDate
				+ ", realName=" + realName + ", idcardNo=" + idcardNo
				+ ", birthdate=" + birthdate + ", gender=" + gender
				+ ", occupation=" + occupation + ", telephone=" + telephone
				+ ", email=" + email + ", mailaddress=" + mailaddress
				+ ", zipcode=" + zipcode + ", qq=" + qq + ", lastLoginTime="
				+ lastLoginTime + ", lastLoginIp=" + lastLoginIp + ", getId()="
				+ getId() + ", getRecommenderId()=" + getRecommenderId()
				+ ", getLoginName()=" + getLoginName() + ", getLoginPasswd()="
				+ getLoginPasswd() + ", getStatus()=" + getStatus()
				+ ", getCreateDate()=" + getCreateDate() + ", getPauseDate()="
				+ getPauseDate() + ", getCloseDate()=" + getCloseDate()
				+ ", getRealName()=" + getRealName() + ", getIdcardNo()="
				+ getIdcardNo() + ", getBirthdate()=" + getBirthdate()
				+ ", getGender()=" + getGender() + ", getOccupation()="
				+ getOccupation() + ", getTelephone()=" + getTelephone()
				+ ", getEmail()=" + getEmail() + ", getMailaddress()="
				+ getMailaddress() + ", getZipcode()=" + getZipcode()
				+ ", getQq()=" + getQq() + ", getLastLoginTime()="
				+ getLastLoginTime() + ", getLastLoginIp()=" + getLastLoginIp()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
