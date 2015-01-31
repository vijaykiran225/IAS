package com.Lab;

//package com.Lab;
import java.util.*;
import java.io.*;
public class FPQuestion {
	public static void main(String[] args)throws Exception {
		HashMap<String, Integer> input=new HashMap<String, Integer>();
		input.put("low", 4);
		input.put("avg", 4);
		input.put("high", 6);
		HashMap<String, Integer> output=new HashMap<String, Integer>();;
		output.put("low", 3);
		output.put("avg", 5);
		output.put("high", 7);
	HashMap<String, Integer> files=new HashMap<String, Integer>();;
	files.put("low", 5);
	files.put("avg", 15);
	files.put("high", 15);
		HashMap<String, Integer> inquiry=new HashMap<String, Integer>();;
		inquiry.put("low", 2);
		inquiry.put("avg", 4);
		inquiry.put("high", 6);
		HashMap<String, Integer> interfaces=new HashMap<String, Integer>();;
		interfaces.put("low", 4);
		interfaces.put("avg", 10);
		interfaces.put("high", 10);
		
		HashMap<String, Integer> environment=new HashMap<String, Integer>();;
		environment.put("nc", 0);
		environment.put("low", 1);
		environment.put("bavg", 2);
		environment.put("avg", 3);
		environment.put("aavg", 4);
		environment.put("high", 5);
		int UFP=0,ch=0;
		String temp="";
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Integer> maptemp=new HashMap<String, Integer>();
		do{
			temp="";
		System.out.println("Enter Type input / output / files / inquiry / interface");
		temp=br.readLine();
		temp=temp.toLowerCase();
		if(temp.equals("input"))
		{maptemp=input;}

		if(temp.equals("output"))
		{maptemp=output;}

		if(temp.equals("files"))
		{maptemp=files;}

		if(temp.equals("inquiry"))
		{maptemp=inquiry;}

		if(temp.equals("interfaces"))
		{maptemp=interfaces;}
		
		System.out.println("Enter low / avg / high ");
		String type=br.readLine();
		System.out.println("<"+type+"> \nEnter value");
		int x=Integer.parseInt(br.readLine());

		if(maptemp.containsKey(type)){
			UFP=UFP+(x*(maptemp.get(type)));	
		}
		else
		{
		System.out.println("error in typing ... type properly !! ");
		}
		System.out.println("continue 1/0?");
		ch=Integer.parseInt(br.readLine());
		}while(ch!=0);
		
		System.out.println("UFP is "+UFP);
		int vaf=0;
		System.out.println("enter the adjustment factors !");
		
		do{
		System.out.println("Enter Vaf Type low / nc / avg / bavg / aavg / high");
		temp=br.readLine();
		if(environment.containsKey(temp))
		vaf+=(environment.get(temp));
		else
			System.out.println("error in typing ... type properly !! ");
		System.out.println("continue 1/0?");
		ch=Integer.parseInt(br.readLine());
		}while(ch!=0);
		System.out.println("vaf  value is "+vaf);
		double AdjustedFP = UFP *(0.65 + (vaf * 0.01));
		System.out.println("Final value is "+AdjustedFP);
	}

}
