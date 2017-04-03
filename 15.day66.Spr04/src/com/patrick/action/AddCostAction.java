package com.patrick.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.patrick.dao.ICostDAO;


@Service
@Scope("prototype")
public class AddCostAction {
	@Resource (name="jdbcCostDAOImpl")//在这里使用annotation的话,下面的setter都不用写了,自动给你匹配 , 如果有多个匹配的实现类,可以通过指定名字来注入
	@Autowired // 功能是一样跟上面的, 这个是属于Spring框架, 上面的数据javax框架的
	@Qualifier("jdbcCostDAOImpl")
	private ICostDAO dao;
	
	
	public String execute(){
		System.out.println("start processing add cost request...");
		return "success";
	}


//	@Resource // 可以按类型匹配注入, 
//	public void setDao(ICostDAO dao) {
//		this.dao = dao;
//	}
}
