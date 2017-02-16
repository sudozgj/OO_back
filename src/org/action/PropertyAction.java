package org.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;

import com.opensymphony.xwork2.ActionSupport;

public class PropertyAction extends ActionSupport{
	private List result;
	
	public String getMemory() throws Exception{
//		System.out.println("\n——获取内存——");
		
		Sigar sigar = new Sigar();
		Mem mem = sigar.getMem();
        DecimalFormat df = new DecimalFormat("######0.00");   	//保留double2位小数

        String mT = df.format((double)mem.getTotal()/1024/1024/1024);	//总内存 B
        String mU = df.format((double)mem.getUsed()/1024/1024/1024);	//已用
        String mF = df.format((double)mem.getFree()/1024/1024/1024);	//可用
        String mUP = df.format((double)mem.getUsedPercent());	//使用率
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("memTotal", mT);
        map.put("memUsed", mU);
        map.put("memFree", mF);
        map.put("memPercent", mUP);
        List<Map<String, String>> list = new ArrayList<>();
        list.add(map);
        
        result = list;
        return SUCCESS;
	}

	public String getDisk() throws Exception{
		Sigar sigar = new Sigar();
		DecimalFormat df = new DecimalFormat("######0.00");   	//保留double2位小数
		FileSystem fslist[] = sigar.getFileSystemList();
		
		List<Map<String, String>> list = new ArrayList<>();
		
		for (int i = 0; i < fslist.length; i++) {
			Map<String, String>	map = new HashMap<>();

            FileSystem fs = fslist[i];
            // 文件系统类型
            FileSystemUsage usage = null;
            usage = sigar.getFileSystemUsage(fs.getDirName());
            double usePercent = usage.getUsePercent() * 100D;

            String diskName = fs.getDevName();									// 磁盘名称
            String diskTotal = df.format((double)usage.getTotal()/1024/1024);	//磁盘总空间
            String diskFree = df.format((double)usage.getAvail()/1024/1024);	//磁盘可用
            String diskUsed = df.format((double)usage.getUsed()/1024/1024);		//磁盘已用
            String diskPercent = df.format(usePercent);							// 磁盘使用率
            
            map.put("diskName", diskName);	
            map.put("diskTotal", diskTotal);
            map.put("diskFree", diskFree);
            map.put("diskUsed", diskUsed);
            map.put("diskPercent", diskPercent);
            list.add(map);
        }
		result=list;
		
		return SUCCESS;
	}
	
	//-----------------------------------------
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
}
