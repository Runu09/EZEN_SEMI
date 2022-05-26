package com.semi2.manager.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi2.controller.Controller;
import com.semi2.mem.model.MemService;
import com.semi2.mem.model.MemVO;
import com.semi2.store.model.StoreService;
import com.semi2.store.model.StoreVO;

public class StorecontrolController implements Controller {

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String keyword=request.getParameter("keywordid");	
		
		//2
		StoreService storeService = new StoreService();

		List<StoreVO> list=null;
		try{
			list=storeService.selectStore(keyword);	
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		
		//4
		return "/storecontrol.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false;
	}
	
}
