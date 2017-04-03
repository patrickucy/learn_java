package com.patrick.entity;

import java.sql.Date;

public class Service {
	private Integer id;
	private Integer accountId;
	private String unixHost;
	private String osUserName;
	private String loginPassword;
	private String status;
	private Date createDate;
	private Date pauseDate;
	private Date closeDate;
	private Integer costId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getUnixHost() {
		return unixHost;
	}
	public void setUnixHost(String unixHost) {
		this.unixHost = unixHost;
	}
	public String getOsUserName() {
		return osUserName;
	}
	public void setOsUserName(String osUserName) {
		this.osUserName = osUserName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
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
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", accountId=" + accountId + ", unixHost="
				+ unixHost + ", osUserName=" + osUserName + ", loginPassword="
				+ loginPassword + ", status=" + status + ", createDate="
				+ createDate + ", pauseDate=" + pauseDate + ", closeDate="
				+ closeDate + ", costId=" + costId + "]";
	}
	
	
}
