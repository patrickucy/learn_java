package com.patrick.vo;

import com.patrick.entity.Service;

/**
 * view object
 * we will be doing joint search
 * @author patrickyu
 *
 */
public class ServiceVO extends Service {
	
	private String idcardNo;
	private String realName;
	private String costName;
	private String costDescr;
	
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	public String getCostDescr() {
		return costDescr;
	}
	public void setCostDescr(String costDescr) {
		this.costDescr = costDescr;
	}
	
	@Override
	public String toString() {
		return "ServiceVO [idcardNo=" + idcardNo + ", realName=" + realName
				+ ", costName=" + costName + ", costDescr=" + costDescr + "]";
	}
	
	
	

}
