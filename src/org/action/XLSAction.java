package org.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.struts2.ServletActionContext;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.opensymphony.xwork2.ActionSupport;

public class XLSAction extends ActionSupport{
	private String filePath;
	private String data;
	private List result;
	
	public String xlsExport() throws Exception{
		System.out.println("\n——导出xls——");
		String r[]=data.split("=");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
		String t = df.format(new Date());
		
		ServletRequest request = ServletActionContext.getRequest();
		String path =request.getRealPath("/");	//项目在服务器的路径
		
		WritableWorkbook book= Workbook.createWorkbook(new File(path+t+".xls"));//xls文件名
		
		WritableSheet sheet=book.createSheet("第一页",0); //第一页工作表
		try {
			String head[]=r[0].split("-");
			for(int j=0;j<head.length;j++){
				sheet.addCell(new Label(j,0,head[j]));
			}
			int cnt=1;
			for(int k=1;k<r.length;k++){
				String context[]=r[k].split("-");
				for(int m=0;m<context.length;m++){
					sheet.addCell(new Label(m,k,context[m]));
				}
			}
			book.write();
			book.close();
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "http://localhost:8080/OO/"+t+".xls");
			List<Map<String, String>> list = new ArrayList<>();
			list.add(map);
			result = list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return SUCCESS;
	}
	//----------------- get/set --------------------------
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
	
}
