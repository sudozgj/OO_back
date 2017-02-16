package org.dao;

import java.util.List;

import org.model.Fileio;

public interface FileioDao {
	/**
	 * 添加文件上传信息
	 * @param fu
	 * @return
	 */
	public boolean addFileio(Fileio fu);
	/**
	 * 获取上传文件的列表
	 * @return
	 */
	public List getFileioList();
	/**
	 * 通过id获取文件
	 * @return
	 */
	public Fileio getFileByid(int id);
	/**
	 * 删除文件
	 * @param id
	 * @return
	 */
	public boolean deleteFile(int id);
}
