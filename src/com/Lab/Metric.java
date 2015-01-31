package com.Lab;

import java.io.*;

class SoftwareMetrics
{
	int NumberOfComments=0;	
	int NumberOfLines=0;
	int NumberOfBranches=0;
	int NumberOfStatements=0;
	int Complexity=0;
	int MaxDepth=0;
	int NumberOfFunctions=0;
	float PercentOfBranches;
	float PercentOfComments;
	String Filename="";
	
	public void displayResults() throws Exception
	{	
		this.Complexity=this.NumberOfBranches+1;
		
		System.out.println("Name of file is "+this.Filename);
		System.out.println("No of statements is "+this.NumberOfStatements);
		System.out.println("No of lines is "+this.NumberOfLines);	
		
		System.out.println("No of Branches is "+this.NumberOfBranches);	
		System.out.println("No of Comments is "+this.NumberOfComments);	
		this.PercentOfBranches=(float)(this.NumberOfBranches)/(float)(this.NumberOfStatements);
		this.PercentOfBranches*=100;
		this.PercentOfComments=(float)(this.NumberOfComments)/(float)(this.NumberOfLines);
		this.PercentOfComments*=100;	
		System.out.println("% of Branches is "+this.PercentOfBranches);
		System.out.println("% of Comments is "+this.PercentOfComments);
		System.out.println("Complexity is "+this.Complexity);	
		System.out.println("Max Depth is "+this.MaxDepth);		
		
	}
}
public class Metric
{
	public static void main(String args[])throws Exception
	{
		String content=null;

		SoftwareMetrics m=new SoftwareMetrics();

		m.Filename="D:/Educational/SEMESTER VIII/Software Metrics Lab/a.c";

		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(m.Filename)));
	
		while((content=br.readLine())!=null)
		{
			//System.out.println("---->"+content);
			m.NumberOfLines++;
		}
		br.close();
		//br.close();
	
		br=new BufferedReader(new InputStreamReader(new FileInputStream(m.Filename)));
	
		while((content=br.readLine())!=null)
		{
			//System.out.println("---->"+content);
			
			if((!content.contains("//"))&&(!content.isEmpty()))
			{
				m.NumberOfStatements++;
			}
			
			if(content.contains("//"))
			{
				m.NumberOfComments++;
			}
			
		}
		
		br.close();
		
		br=new BufferedReader(new InputStreamReader(new FileInputStream(m.Filename)));
	
		while((content=br.readLine())!=null)
		{
			if((content.contains("if"))||(content.contains("else"))||(content.contains("for"))||(content.contains("while"))||(content.contains("switch"))||(content.contains("do")))
			{
				m.NumberOfBranches++;
			}		
		}
		
		br.close();

		int count=-1;
		br=new BufferedReader(new InputStreamReader(new FileInputStream(m.Filename)));
	
		while((content=br.readLine())!=null)
		{
			if(content.contains("{"))
			{
				count=-1;
				while(!content.contains("}"))
				{
					//System.out.println("---->"+content);
					if(content.contains("{"))
					{
						count++;
					}
					content=br.readLine();
					
					//System.out.print("---->"+"\t\t\tcount is"+count );
				}
				//System.out.println("end of inner loop");
			}
			if(m.MaxDepth<count)	
			{m.MaxDepth=count;	} 	
			//count=0;	
		}
				//System.out.println("end of outer loop");		
		br.close();

		

		m.displayResults();
		
	}
}