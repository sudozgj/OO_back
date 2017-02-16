package org.action;

import java.util.List;

import org.dao.LogDao;
import org.dao.imp.LogDaoImp;
import org.model.Log;

import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport{
	private Object result;

	public String getLogList() throws Exception{
		LogDao lDao = new LogDaoImp();
		List<Log> list = lDao.getLogList();
		
		result = list;
		return SUCCESS;
	}
	public String getLogList02() throws Exception{
		LogDao lDao = new LogDaoImp();
		List<Log> list = lDao.getLogList02();
		
		result = list;
		return SUCCESS;
	}
	
	//------------------------------------------------
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
