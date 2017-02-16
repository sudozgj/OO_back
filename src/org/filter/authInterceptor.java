package org.filter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dao.LogDao;
import org.dao.imp.LogDaoImp;
import org.model.Log;
import org.model.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class authInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getInvocationContext().getName();
		System.out.println("——权限拦截——"+new Timestamp(System.currentTimeMillis())+" "+actionName);

		/**
		 * 先判断是否登录过
		 */
		
		/**
		 * 先进行权限拦截判断，再日志
		 */
		if(actionName.equals("login")){		//login请求
			Map request = (Map) ActionContext.getContext().get("request");
			String username = (String) request.get("username");
			
			LogDao lDao = new LogDaoImp();
			Log log = new Log();
			log.setUsername(username);
			log.setOperation("login");
			log.setTime(new Date().getTime()/1000);
			lDao.addLog(log);
			
			return invocation.invoke();
		}else {			//其他请求
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User) session.get("user");
			
			if(user!=null){	//已经登录过
				LogDao lDao = new LogDaoImp();
				Log log = new Log();
				log.setUsername(user.getUsername());
				log.setOperation(actionName);
				log.setTime(new Date().getTime()/1000);
				
				lDao.addLog(log);
				
				if(actionName.equals("getLogList")){	//模拟没有权限
					List<Map<String, String>> list = new ArrayList<>();
					Map<String, String> map = new HashMap<String, String>();
					map.put("result", "无权限访问");
					list.add(map);
					ActionContext.getContext().put("result", list);
					
					return Action.ERROR;
				}else {
					
					return invocation.invoke();
				}
			}else{	//没有登录
				List<Map<String, String>> list = new ArrayList<>();
				Map<String, String> map = new HashMap<String, String>();
				map.put("result", "请先登录");
				list.add(map);
				ActionContext.getContext().put("result", list);
				return Action.ERROR;
			}
		}
	}
}
