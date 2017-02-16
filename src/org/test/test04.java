package org.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.action.PropertyAction;


public class test04 {
	public static void main(String[] args) {
		System.out.println(getProcessCpuRate(1));
	}
    public static float getProcessCpuRate(int pid) // 获得应用cpu占用率  
    {  
	    float CPU = 0;  
	    try {  
	    float totalCpuTime1 = getTotalCpuTime();  
	    float processCpuTime1 = getAppCpuTime(pid);  
	    try {  
	    Thread.sleep(300);  
	    } catch (Exception e) {  
	    }  
	    float totalCpuTime2 = getTotalCpuTime();  
	    float processCpuTime2 = getAppCpuTime(pid);  
	    float cpuRate = 100 * (processCpuTime2 - processCpuTime1)  
	    / (totalCpuTime2 - totalCpuTime1);  
	    String str = new DecimalFormat("0.00").format(cpuRate);  
	    CPU = Float.parseFloat(str);  
	    } catch (Exception e) {  
	    }  
	    return CPU;  
    }  
    private static long getTotalCpuTime() { // 获取系统总CPU使用时间  
    	String[] cpuInfos = null;  
    	try {  
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(  
	    	new FileInputStream("/proc/stat")), 1000);  
	    	String load = reader.readLine();  
	    	reader.close();  
	    	cpuInfos = load.split(" ");  
	    	// System.out.println("cpulist:"+Arrays.toString(cpuInfos));  
    	} catch (IOException ex) {  
    		ex.printStackTrace();  
    	}  
    	long totalCpu = Long.parseLong(cpuInfos[2])  
    	+ Long.parseLong(cpuInfos[3]) + Long.parseLong(cpuInfos[4])  
    	+ Long.parseLong(cpuInfos[6]) + Long.parseLong(cpuInfos[5])  
    	+ Long.parseLong(cpuInfos[7]) + Long.parseLong(cpuInfos[8]);  
    	return totalCpu;  
    }
    private static long getAppCpuTime(int pid) { // 获取应用占用的CPU时间  
	    String[] cpuInfos = null;  
	    try {  
		    // int pid = android.os.Process.myPid();  
		    BufferedReader reader = new BufferedReader(new InputStreamReader(  
		    new FileInputStream("/proc/" + pid + "/stat")), 1000);  
		    String load = reader.readLine();  
		    reader.close();  
		    cpuInfos = load.split(" ");  
	    } catch (IOException ex) {  
	    	ex.printStackTrace();  
	    }  
	    long appCpuTime = Long.parseLong(cpuInfos[13])  
	    + Long.parseLong(cpuInfos[14]) + Long.parseLong(cpuInfos[15])  
	    + Long.parseLong(cpuInfos[16]);  
	    return appCpuTime;  
    }  
}
