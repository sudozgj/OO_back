package org.test;


public class test01 {
	public static void main(String[] args) {
		String str = "net_sd";
		String str1 = "net1";
		if(str.startsWith("net"))
			System.out.println(str);
		if(str1.startsWith("net_"))
			System.out.println(str1);
	}
}
