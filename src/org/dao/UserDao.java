package org.dao;

import java.util.List;

import org.model.User;

public interface UserDao {
	/**
	 * 注册 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public boolean deleteUser(int id);
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);
	
	/**
	 * 检验用户名
	 * @param username
	 * @return
	 */
	public boolean checkUsername(String username);
	/**
	 * 获取用户列表
	 * @return
	 */
	public List getUserList();
}
