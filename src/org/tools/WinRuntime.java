package org.tools;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Properties;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

public class WinRuntime {
	public static void main(String[] args) {
		try {
			Sigar sigar = new Sigar();
			Runtime r = Runtime.getRuntime();
			Properties props = System.getProperties();
			
			
			/**
			 * 主机
			 */
			System.out.println("\n————主机————");
			InetAddress addr;
			addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress();
			Map<String, String> map = System.getenv();
			String computerName = map.get("COMPUTERNAME");// 获取计算机名
			String username = map.get("USERNAME");	//获取用户名
			System.out.println(ip);		//主机IP地址
			System.out.println(username);
			System.out.println(computerName);
			
			/**
			 * CPU
			 */
			System.out.println("\n————CPU————");
			CpuInfo infos[]=sigar.getCpuInfoList();
			CpuPerc cpuList[] = null;
	        cpuList = sigar.getCpuPercList();
	        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
	            CpuInfo info = infos[i];
	            System.out.println("第" + (i + 1) + "块CPU信息");
	            printCpuPerc(cpuList[i]);
	        }
			
			/**
			 * 内存
			 */
			System.out.println("\n————内存————");
	        Mem mem = sigar.getMem();
	        DecimalFormat df = new DecimalFormat("######0.00");   	//保留double2位小数
	        double mT = mem.getTotal();	//总内存 B
	        double mU = mem.getUsed();	//已用
	        double mF = mem.getFree();	//可用
	        double mUP = mem.getUsedPercent();	//使用率
	        System.out.println(df.format(mT/1024/1024/1024)+" GB");
	        System.out.println(df.format(mU/1024/1024/1024)+" GB");
	        System.out.println(df.format(mF/1024/1024/1024)+" GB");
	        System.out.println(df.format(mUP)+" %");

	        /**
	         * 磁盘
	         */
	        System.out.println("\n————磁盘————");
	        file();
	        
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SigarException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void printCpuPerc(CpuPerc cpu) {
        System.out.println("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
        System.out.println("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
        System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
        System.out.println("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
    }
	private static void file() throws Exception {
		DecimalFormat df = new DecimalFormat("######0.00");   	//保留double2位小数
        Sigar sigar = new Sigar();
        FileSystem fslist[] = sigar.getFileSystemList();
        for (int i = 0; i < fslist.length; i++) {
        	System.out.println();
            FileSystem fs = fslist[i];
            // 分区的盘符名称
            System.out.println("盘符名称:    " + fs.getDevName());
            // 文件系统类型
            FileSystemUsage usage = null;
            usage = sigar.getFileSystemUsage(fs.getDirName());
            
            // 文件系统总大小
            System.out.println(fs.getDevName() + "总大小:    " + df.format((double)usage.getTotal()/1024/1024) + " GB");
            // 文件系统剩余大小
            System.out.println(fs.getDevName() + "可用大小:    " + df.format((double)usage.getAvail()/1024/1024) + " GB");
            // 文件系统已经使用量
            System.out.println(fs.getDevName() + "已经使用量:    " + df.format((double)usage.getUsed()/1024/1024) + " GB");
            double usePercent = usage.getUsePercent() * 100D;
            // 文件系统资源的利用率
//            System.out.println(fs.getDevName() + "磁盘使用率:    " + usePercent + "%");
            System.out.println(fs.getDevName() + "磁盘使用率:    " + df.format((double)usage.getUsed()/(double)usage.getTotal()*100) + "%");
        }
        return;
    }
//	private double getCpuRatioForWindows() {   
//        try {   
//            String procCmd = System.getenv("windir")   
//                    + "\\system32\\wbem\\wmic.exe process get Caption,CommandLine,"  
//                    + "KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount";   
//            // 取进程信息   
//            long[] c0 = readCpu(Runtime.getRuntime().exec(procCmd));   
//            Thread.sleep(CPUTIME);   
//            long[] c1 = readCpu(Runtime.getRuntime().exec(procCmd));   
//            if (c0 != null && c1 != null) {   
//                long idletime = c1[0] - c0[0];   
//                long busytime = c1[1] - c0[1];   
//                return Double.valueOf(   
//                        PERCENT * (busytime) / (busytime + idletime))   
//                        .doubleValue();   
//            } else {   
//                return 0.0;   
//            }   
//        } catch (Exception ex) {   
//            ex.printStackTrace();   
//            return 0.0;   
//        }   
//    }
//	private long[] readCpu(final Process proc) {
//		long[] retn = new long[2];
//		try {
//		proc.getOutputStream().close();
//		InputStreamReader ir = new InputStreamReader(proc.getInputStream());
//		LineNumberReader input = new LineNumberReader(ir);
//		String line = input.readLine();
//		if (line == null || line.length() < FAULTLENGTH) {
//		return null;
//		}
}
