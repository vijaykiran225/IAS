package com.ias;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
class WifiProblem
{
	private List<String> m=null;
	private String Name="";
	private Boolean Stat=true;
	public WifiProblem()
	{
		m=new LinkedList<String>();
	}
	public int connect() throws Exception
	{
		Process p=(Runtime.getRuntime().exec("netsh wlan show networks"));
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		String Result="",h="";
		
		while((h=br.readLine())!=null)
		{
			//Result+=h;
			//System.out.println("h is "+h);
			if(h.contains("SSID"))
			{
			//	h=br.readLine();
			//	if(h.contains(" Network type            : Ad-hoc")){
					String []temp=h.split(":");
					m.add(temp[1]);
					System.out.println("FOund Hosted network "+h);	
				//}
					
			}
		//	else{System.out.println("FOund Hosted network is not supported !!");}
		//	Result+="\n";
		}
		int ch;
		System.out.println("Enter the name to connect");
		ch=Integer.parseInt(console.readLine());
		ch--;
		if((ch<0)||(ch>m.size())){System.out.println("error");}
		else{
			
			System.out.println("setting profile parameter .. ");	
		p=(Runtime.getRuntime().exec("netsh wlan set profileparameter name="+m.get(ch)+" connectiontype=ibss"));
		br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((h=br.readLine())!=null)
		{
			System.out.println(h);	
		}
		}
		System.out.println("done..");
		System.out.println("Connecting to "+m.get(ch));
		Name=m.get(ch);
		p=(Runtime.getRuntime().exec("netsh wlan connect name="+m.get(ch)+" ssid="+m.get(ch)+" interface=Wi-Fi"));
		br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((h=br.readLine())!=null)
		{
			
			System.out.println(h);	
		}
		
//		}
		return 0;
	}
	
	
	
	public int disconnect()throws Exception
	{
		Process p=(Runtime.getRuntime().exec("netsh wlan show drivers"));
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String Result="",h="";
		
		while((h=br.readLine())!=null)
		{
			Result+=h;
			//System.out.println("h is "+h);
			if(h.contains("Hosted network supported  : Yes"))
			{
				System.out.println("FOund Hosted network is supported !!");		
			}
		//	else{System.out.println("FOund Hosted network is not supported !!");}
			Result+="\n";
			p=(Runtime.getRuntime().exec("netsh wlan disconnect"));
			br=new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((h=br.readLine())!=null)
			{
				
				System.out.println(h);	
			}
			p=(Runtime.getRuntime().exec("netsh wlan delete profile name="+Name+" interface=Wi-Fi"));
			br=new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((h=br.readLine())!=null)
			{
				
				System.out.println(h);	
			}
//		/netsh wlan delete profile <ssid>
		}
		return 0;
	}
	
	
	

	public int stopNet()throws Exception
	{
		Process p=(Runtime.getRuntime().exec("netsh wlan show drivers"));
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String Result="",h="";
		
		while((h=br.readLine())!=null)
		{
			Result+=h;
			//System.out.println("h is "+h);
			if(h.contains("Hosted network supported  : Yes"))
			{
				System.out.println("FOund Hosted network is supported !!");		
			}
		//	else{System.out.println("FOund Hosted network is not supported !!");}
			Result+="\n";
		}
		
		p=(Runtime.getRuntime().exec("netsh wlan stop hostednetwork"));
		br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((h=br.readLine())!=null)
		{
			System.out.println(h);	
		}
		return 0;
	}

	public int startNet()throws Exception
	{
		Process p=(Runtime.getRuntime().exec("netsh wlan show drivers"));
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String Result="",h="";
		
		while((h=br.readLine())!=null)
		{
			Result+=h;
			//System.out.println("h is "+h);
			if(h.contains("Hosted network supported  : Yes"))
			{
				System.out.println("FOund Hosted network is supported !!");		
			}
		//	else{System.out.println("FOund Hosted network is not supported !!");}
			Result+="\n";
		}
		return 0;
	}
	
	
	
	
	
	public int create()throws Exception
	{
		Process p=(Runtime.getRuntime().exec("netsh wlan show drivers"));
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		String Result="",h="";
		
		while((h=br.readLine())!=null)
		{
			Result+=h;
			//System.out.println("h is "+h);
			if(h.contains("Hosted network supported  : Yes"))
			{
				System.out.println("FOund Hosted network is supported !!");		
			}
		//	else{System.out.println("FOund Hosted network is not supported !!");}
			Result+="\n";
		}
		
		System.out.println("Enter the name to connect");
		String name=(console.readLine());
		System.out.println("Enter the password to connect");
		String pwd=(console.readLine());
		
		p=(Runtime.getRuntime().exec("C:/Users/Vijay Kiran/Documents/e/bin/x86/Release/Elevate.exe netsh wlan set hostednetwork mode=allow ssid="+name+" key="+pwd));
		br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((h=br.readLine())!=null)
		{
			System.out.println(h);		
		}
		p=(Runtime.getRuntime().exec("C:/Users/Vijay Kiran/Documents/e/bin/x86/Release/Elevate.exe netsh wlan start hostednetwork"));
		br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((h=br.readLine())!=null)
		{
			System.out.println(h);		
		}
		p=(Runtime.getRuntime().exec("netsh wlan export hostednetworkprofile"));
		br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((h=br.readLine())!=null)
		{
			System.out.println(h);		
		}
		System.out.println("import the pr0file created in other pc");
		return 0;
	}
}
public class App {

	public static void main(String args[])throws Exception
	{
//		JFrame frame=new JFrame("crappp");
//		JPanel panel=new JPanel();
//		JLabel label=new JLabel("",JLabel.LEADING);
		Process p=(Runtime.getRuntime().exec("netsh wlan show drivers"));
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String Result="",h="";
		
		while((h=br.readLine())!=null)
		{
			Result+=h;
			//System.out.println("h is "+h);
			if(h.contains("Hosted network supported  : Yes"))
			{
				System.out.println("FOund Hosted network is supported !!");		
			}
		//	else{System.out.println("FOund Hosted network is not supported !!");}
			Result+="\n";
		}
		//System.out.println("h is "+Result);
		
		WifiProblem w=new WifiProblem();
	System.out.println("enter the choice \n1->connect\n2->disconnect\n3->create\n4->stopnet");
	br=new BufferedReader(new InputStreamReader(System.in));
	int y=Integer.parseInt(br.readLine());
	switch(y){	
	case 1:w.connect();break;
	case 2:	w.disconnect();break;
	case 3:w.create();break;
	case 4 :w.stopNet();break;
	default:System.out.println("enter properly");
	}}
}
