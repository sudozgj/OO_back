package org.dao;

import java.util.List;

import org.model.Role;


public interface RoleDao {
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public boolean addRole(String role);
	/**
	 * 检测角色名
	 * @param username
	 * @return
	 */
	public boolean checkRole(String role);
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	public boolean deleteRole(int id);
	/**
	 * 获取角色列表
	 * @return
	 */
	public List getRoleList();
}
