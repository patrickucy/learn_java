package com.patrick.action.cost;

import java.util.List;

import com.patrick.dao.ICostDAO;
import com.patrick.entity.Cost;

public class FindCostAction {

	private int page = 1;
	private int pageSize = 5;
	
	private List<Cost> costs;
	private int totalPage;
	
	private ICostDAO costDAO;
	
	public void setCostDAO(ICostDAO costDAO){
		this.costDAO = costDAO;
	}
	
	/**
	 * action --> dao 最好使用控制事务,方法最好不要使用默认名
	 * @return
	 */
	public String findCosts(){
		costs = costDAO.findByPage(page, pageSize);
		totalPage = costDAO.findTotalPages(pageSize);
		return "success";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public ICostDAO getCostDAO() {
		return costDAO;
	}
	
	
	

	
}
