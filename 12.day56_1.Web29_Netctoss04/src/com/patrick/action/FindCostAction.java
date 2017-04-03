package com.patrick.action;

import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.ICostDAO;
import com.patrick.entity.Cost;

public class FindCostAction {

	private int pageSize;
	// input
	private int currentPage = 1;
	
	// output
	private List<Cost> costs;
	private int totalPages;
	
	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
		
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String execute(){
		ICostDAO dao = DAOFactory.getCostDAO();
		try {
			costs = dao.findByPage(currentPage, pageSize);
			totalPages = dao.findTotalPages(pageSize);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
