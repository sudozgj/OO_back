package org.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dao.UserDao;
import org.dao.imp.UserDaoImp;
import org.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private String id;
	private String name;
	private String username;
	private String password;
	private List result;
	
	public String login() throws Exception{
		System.out.println("\n——登录:login——");
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		UserDao uDao = new UserDaoImp();
		User user = uDao.login(username, password);
		if(user!=null){
			System.out.println("登录成功");
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("user", user);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "1");
			List<Map<String, String>> list = new ArrayList<>();
			list.add(map);
			result=list;
		}else {
			System.out.println("登录失败");
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "用户名或密码错误");
			List<Map<String, String>> list = new ArrayList<>();
			list.add(map);
			result=list;
		}
		return SUCCESS;
	}
	public String checkUsername() throws Exception{
		System.out.println("\n——检测用户名:checkUsername——");
		UserDao uDao = new UserDaoImp();
		if(uDao.checkUsername(username)){
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "1");
			List<Map<String, String>> list = new ArrayList<>();
			list.add(map);
			result=list;
		}else{
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "用户名重复");
			List<Map<String, String>> list = new ArrayList<>();
			list.add(map);
			result=list;
		}
		return SUCCESS;
	}
	public String register() throws Exception{
		System.out.println("\n——注册:register——");
		UserDao uDao = new UserDaoImp();
		
		User u = new User();
		u.setName(name);
		u.setUsername(username);
		u.setPassword(password);
		u.setCreatetime(new Date().getTime());
		if(uDao.addUser(u)){
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "1");
			List<Map<String, String>> list = new ArrayList<>();
			list.add(map);
			result=list;
		}else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "注册失败");
			List<Map<String, String>> list = new ArrayList<>();
			list.add(map);
			result=list;
		}
		return SUCCESS;
	}
	public String getUserList() throws Exception{
		System.out.println("\n——获取用户列表——");
		
		UserDao uDao = new UserDaoImp();
		
		result=uDao.getUserList();
		return SUCCESS;
	}
	public String logout() throws Exception{
		System.out.println("\n——注销:logout——");
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		session.remove("user");
		
		HttpSession hSession = ServletActionContext.getRequest().getSession();
		hSession.invalidate();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "1");
		List<Map<String, String>> list = new ArrayList<>();
		list.add(map);
		result=list;
		
		return SUCCESS;
	}
	public String deleteUser() throws Exception{
		System.out.println("\n——删除用户——");
		String[] idArray = id.split("-");
		
		UserDao uDao = new UserDaoImp();
		for(String uid:idArray){
			if(!uDao.deleteUser(Integer.parseInt(uid))){
				Map<String, String> map = new HashMap<String, String>();
				map.put("result", "删除用户出错,用户id："+uid);
				List<Map<String, String>> list = new ArrayList<>();
				list.add(map);
				result=list;
				return SUCCESS;
			}else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("result", "1");
				List<Map<String, String>> list = new ArrayList<>();
				list.add(map);
				result=list;
			}
		}
		return SUCCESS;
	}
	//———————————————get/set—————————————————————
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
