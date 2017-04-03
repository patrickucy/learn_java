package com.patrick.entity;

public class Cost {

	/**
	 * recommend using wrapping class primitive data type
	 */
	private Integer id;
	private String name;
	private Integer baseDuration;
	private Double baseCost;
	private Double unitCost;
	private String status;
	private String descr;
	// java.sql.data
	private java.sql.Date createTime;
	private java.sql.Date startTime;
	private String costType;
	@Override
	public String toString() {
		return "Cost [id=" + id + ", name=" + name + ", baseDuration="
				+ baseDuration + ", baseCost=" + baseCost + ", unitCost="
				+ unitCost + ", status=" + status + ", descr=" + descr
				+ ", createTime=" + createTime + ", startTime=" + startTime
				+ ", costType=" + costType + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public Double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public java.sql.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Date createTime) {
		this.createTime = createTime;
	}
	public java.sql.Date getStartTime() {
		return startTime;
	}
	public void setStartTime(java.sql.Date startTime) {
		this.startTime = startTime;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	
	
	
}
