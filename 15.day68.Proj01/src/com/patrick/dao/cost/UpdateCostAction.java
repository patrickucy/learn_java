package com.patrick.dao.cost;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.patrick.dao.cost.ICostDAO;
import com.patrick.entity.Cost;

@Controller
@Scope("prototype")
public class UpdateCostAction {

	private Cost cost;
	@Resource
	private ICostDAO dao;
	
	public String execute() throws Exception{
		dao.update(cost);
		
		
		return "success";
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
}
