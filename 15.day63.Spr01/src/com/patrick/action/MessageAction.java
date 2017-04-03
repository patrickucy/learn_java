package com.patrick.action;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MessageAction {

	private String msg;
	private int pageSize;
	private String[] types;
	private List<String> hbms;
	private Set<String> friends;
	private Map<String,Object> books;
	private Properties pros;
	
	// 注入一个 "jpg,jpeg,gif" 字符串
	public void setFileTypes(String str){
		types = str.split(",");
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setHbms(List<String> hbms) {
		this.hbms = hbms;
	}
	public void setFriends(Set<String> friends) {
		this.friends = friends;
	}

	public void setBooks(Map<String, Object> books) {
		this.books = books;
	}
	
	public void setPros(Properties pros) {
		this.pros = pros;
	}

	@Override
	public String toString() {
		return "MessageAction [msg=" + msg + ", pageSize=" + pageSize
				+ ", types=" + Arrays.toString(types) + ", hbms=" + hbms
				+ ", friends=" + friends + ", books=" + books + ", pros="
				+ pros + "]";
	}


	


	
	
	
}
