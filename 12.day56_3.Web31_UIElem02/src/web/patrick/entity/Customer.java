package web.patrick.entity;

import java.util.List;

public class Customer {

	private String name; // text
	private String password; //password
	private String desc; // textarea
	private String sex; // single choice
	private boolean marry; // single choice
	private List<String> travelCities;
	private String home;
	private String loveCity;
	
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", password=" + password + ", desc="
				+ desc + ", sex=" + sex + ", marry=" + marry + ", travelCitys="
				+ travelCities + ", home=" + home + ", loveCity=" + loveCity
				+ "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean isMarry() {
		return marry;
	}
	public void setMarry(boolean marry) {
		this.marry = marry;
	}
	public List<String> getTravelCities() {
		return travelCities;
	}
	public void setTravelCities(List<String> travelCities) {
		this.travelCities = travelCities;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getLoveCity() {
		return loveCity;
	}
	public void setLoveCity(String loveCity) {
		this.loveCity = loveCity;
	}

	
	
	
}
