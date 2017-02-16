package org.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OnlineNumAction extends ActionSupport implements HttpSessionListener{
	private long onlineCount;
	private ServletContext application = null;
	private Object result;
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session create : "+new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss").format(new Date()));
		
//		this.onlineCount=this.onlineCount+1;
//		onlineCount++;
//		arg0.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session destory : "+new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss").format(new Date()));
		
//		this.onlineCount=this.onlineCount-1;
//		onlineCount--;
//		arg0.getSession().getServletContext().setAttribute("onlineCount", onlineCount);
	}
	
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
