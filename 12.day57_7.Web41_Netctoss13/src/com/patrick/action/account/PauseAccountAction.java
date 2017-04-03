package com.patrick.action.account;

import java.util.List;

import com.patrick.dao.DAOException;
import com.patrick.dao.DAOFactory;
import com.patrick.dao.account.IAccountDAO;
import com.patrick.dao.service.IServiceDAO;
import com.patrick.entity.Service;

public class PauseAccountAction {

	private int id;

	public String execute(){
		
		// 1. cancel account 
		IAccountDAO accDao = DAOFactory.getAccountDAO();
		try {
			accDao.pause(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
		// 2. cancel services under this account
		IServiceDAO serdao = DAOFactory.getServiceDAO();
		try {
			List<Service> services =  serdao.findByAccountId(id);
			// 3. enumerate
			if(services != null && services.size() > 0){
				for(Service s: services){
					serdao.pause(s.getId());
				}
			}
			
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		
		return "success";
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
