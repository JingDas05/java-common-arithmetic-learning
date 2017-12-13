package top.treegrowth.common.p12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class P12_2 {
	static char[] jiami(char[] str,int n)					//加密算法
	{
	    int i,len;
	    char[] miwen;

	    len=str.length;
	    if((miwen=new char[len+1])==null)	//申请内存
	    {
	        System.out.print("申请内存失败!\n");
	        System.exit(1);
	    }
	    for(i=0;i<len;i++)						//移位替换
	    {
			miwen[i]=(char)(str[i]+n);
	    }
	    miwen[len]='\0';
	    return miwen;
	}
	
	static char[] jiemi(char[] str,int n)					//解密算法
	{
	    int i,len;
	    char[] mingwen;

	    len=str.length;
	    if((mingwen=new char[len+1])==null)//申请内存
	    {
	        System.out.print("申请内存失败!\n");
	        System.exit(1);
	    }
	    for(i=0;i<len;i++)						//移位替换
	    {
			mingwen[i]=(char)(str[i]-n);
	    }
	    mingwen[len]='\0';
	    return mingwen;
	}        
	
	public static void main(String[] args) throws IOException 
	{
		int i,n;
		char[] srcstr=new char[100];
		char[] miwen;
		String go;

		System.out.print("替换加密解密算法演示！\n");
		
		do{
		System.out.print("\n请先输入替换加密解密算法中的密钥：");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();						//密钥
		System.out.print("请输入明文字符串：");
			
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str=bufferedReader.readLine();
		srcstr=str.toCharArray();				//明文字符串
		
		System.out.print("输入的明文为：");
		for(i=0;i<srcstr.length;i++)
		{
		  	System.out.print(srcstr[i]);
		}
				
		miwen=jiami(srcstr,n);				//加密
		System.out.print("\n加密后的密文为：");
		for(i=0;i<srcstr.length;i++)
		{
		   	System.out.print(miwen[i]);
		}
		miwen=jiemi(miwen,n);				//解密
		System.out.print("\n解密出的明文为：");
		for(i=0;i<srcstr.length;i++)
		{
		  	System.out.print(miwen[i]);
		}
		
		System.out.print("\n继续执行(y/n)?");
		go=input.next();
		}while(go.equalsIgnoreCase("y"));
		System.out.println("演示结束！");
	}

}
