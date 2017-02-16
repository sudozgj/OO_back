package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.dao.FileioDao;
import org.dao.imp.FileioDaoImp;
import org.model.Fileio;
import org.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileioAction extends ActionSupport{
	
	
	private File upFile;				//文件：		名字与标签中的name属性一致
	private String upFileFileName;		//文件名：	文件 + FileName
	private String upFileContentType;	//文件类型：	文件 + ContentType
	private List result;
	
	private String id;			//删除文件用
	private String fileName;	//下载文件使用
	
	/**
	 * 文件上传
	 * @return
	 * @throws Exception
	 */
	public String fileUpload() throws Exception{
		System.out.println("\n——文件上传——");
		
		long upTime = new Date().getTime();	//上传时间
		
		try {
			ServletRequest request = ServletActionContext.getRequest();
			String path = request.getRealPath("/");
			
			File dir = new File(path+"UpFileDir");		//文件保存的文件夹路径
			if(!dir.exists() && !dir.isDirectory()){	//路径不存在则创建
				dir.mkdir();
			}
			InputStream is = new FileInputStream(upFile);
			String fileName = upTime+"_"+upFileFileName;	//文件实际名，加上时间防止重复
			String fPath = dir+"\\"+fileName;		//文件最终路径
			OutputStream os = new FileOutputStream(fPath);
			
			System.out.println("文件名："+upFileFileName);
			System.out.println("文件保存名："+fileName);
			System.out.println("文件路径:"+fPath);
			
			byte[] buffer = new byte[1024];
			int count=0;
			while((count=is.read(buffer))>0){
				os.write(buffer,0,count);
			}
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		
		if(u!=null){
			Fileio f = new Fileio();
			f.setFilename(upFileFileName);
			f.setUsername(u.getUsername());
			f.setUploadtime(upTime);
			
			FileioDao fDao = new FileioDaoImp();
			fDao.addFileio(f);
		}else {
			System.out.println("请先登录,才能上传文件!");
		}
		return SUCCESS;
	}
	
	/**
	 * 获取文件列表
	 * @return
	 * @throws Exception
	 */
	public String getFileList() throws Exception{
		System.out.println("\n——获取文件列表——");
		
		FileioDao fDao = new FileioDaoImp();
			
		result=fDao.getFileioList();
		return SUCCESS;
	}
	
	/**
	 * 文件下载
	 * @return
	 * @throws Exception
	 */
	public InputStream getFileDown() throws Exception{
		System.out.println("\n——文件下载——");
		System.out.println("id:"+id);
		
		FileioDao fDao = new FileioDaoImp();
		Fileio f = fDao.getFileByid(Integer.parseInt(id));
		
		fileName=f.getUploadtime()+"_"+f.getFilename();
//		fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
		return ServletActionContext.getServletContext().getResourceAsStream("UpFileDir/"+fileName);
	}
	
	/**
	 * 删除文件
	 * @return
	 * @throws Exception
	 */
	public String deleteFile() throws Exception{
		FileioDao fDao = new FileioDaoImp();

		HttpSession session = (HttpSession) ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		
		Fileio f = fDao.getFileByid(Integer.parseInt(id));
		if(user.getUsername().equals(f.getUsername())){		//要删除的文件的拥有者是自己
			if(fDao.deleteFile(Integer.parseInt(id))){
				Map<String, String> map = new HashMap<String, String>();
				map.put("result", "1");
				List<Map<String, String>> list = new ArrayList<>();
				list.add(map);
				result=list;
			}else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("result", "0");
				List<Map<String, String>> list = new ArrayList<>();
				list.add(map);
				result=list;
			}
		}else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "无法删除他人的文件");
			List<Map<String, String>> list = new ArrayList<>();
			list.add(map);
			result=list;
		}
		return SUCCESS;
	}
	
	
	//------------- get/set -----------------
	public File getUpFile() {
		return upFile;
	}
	public void setUpFile(File upFile) {
		this.upFile = upFile;
	}
	public String getUpFileFileName() {
		return upFileFileName;
	}
	public void setUpFileFileName(String upFileFileName) {
		this.upFileFileName = upFileFileName;
	}
	public String getUpFileContentType() {
		return upFileContentType;
	}
	public void setUpFileContentType(String upFileContentType) {
		this.upFileContentType = upFileContentType;
	}
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
