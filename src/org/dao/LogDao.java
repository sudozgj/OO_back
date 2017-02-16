package org.dao;

import java.util.List;

import org.model.Log;

public interface LogDao {
	/**
	 * 添加日志
	 * @param log
	 * @return
	 */
	public boolean addLog(Log log);
	/**
	 * 获取日志列表
	 * @return
	 */
	public List getLogList();
	/**
	 * 时间戳转时间列表
	 * @return
	 */
	public List getLogList02();
}
