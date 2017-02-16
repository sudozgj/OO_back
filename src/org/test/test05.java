package org.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test05 {
	public static void main(String[] args) {
		try {
			Runtime runtime = Runtime.getRuntime();
			Process pr = runtime.exec("cmd /c typeperf \"\\Processor(_Total)\\% Processor Time\"");
			
			BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream(),"GBK"));
			String line = null;
			
			while((line=input.readLine())!=null){
				System.out.println(line);
			}
			int exitVal = pr.waitFor();
			System.out.println(exitVal);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
