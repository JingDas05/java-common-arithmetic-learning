package top.treegrowth.common.p12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P12_1 {
	static char[] jiami(char[] str,int n)					//加密算法
	{    
	    int i,j,k,d;
		int len;
	    char[] temp,miwen,mtemp={};

	    len=str.length;						//字符串长度
	    if((d=len%n)!=0) 
		{
			len=len+n-d;
		}

	    if((temp=new char[len+1])==null)	//申请内存	
	    {
	        System.out.print("申请内存失败!\n");
	        System.exit(1);
	    }    

	    if((miwen=new char[len+1])==null)	//申请内存	
	    {
	        System.out.print("申请内存失败!\n");
	        System.exit(1);
	    }
		else
		{
			mtemp=miwen;  
		}

	    System.arraycopy(str,0,temp,0,str.length);
	    for(i=str.length;i<len;i++)
		{
	        temp[i]=32;
		}
	    temp[len]='\0';
	    i=0;
	    for(k=0;k<n;k++)					//转换，加密
	    {
	        for(j=0;j<len/n;j++)
			{
	           mtemp[i]=temp[k+j*n];           
	           i++;
	        }           
	    }
	    mtemp[i]='\0';
	    temp=null;
  
	    return miwen;						//返回密文
	}

	static char[] jiemi(char[] str,int n)					//解密算法
	{    
	    int i,j,k=0,d;
		int len;
	    char[] temp,mingwen,mtemp={};

	    len=str.length;

	    if((d=len%n)!=0) 
		{
	    	len=len-d;
	    }
	    n=len/n;
	    if((temp=new char[len+1])==null)	//申请内存	
	    {
	        System.out.print("申请内存失败!\n");
	        System.exit(1);
	    }    

	    if((mingwen=new char[len+1])==null)	//申请内存	
	    {
	        System.out.print("申请内存失败!\n");
	        System.exit(1);
	    }
		else
		{
			mtemp=mingwen;    
		}
	    
	    System.arraycopy(str,0,temp,0,str.length);
	    for(i=str.length;i<len;i++)
		{
	        temp[i]=32;
		}
	    temp[len]='\0';
	    i=0;
	    for(k=0;k<n;k++)					//恢复出明文
	    {
	        for(j=0;j<len/n;j++)
			{
	           mtemp[i]=temp[k+j*n];           
	           i++;
	        }           
	    }
	    
	    while(mtemp[--i]==32);
	    i++;
	    mtemp[i]='\0';
	    return mingwen;						//返回明文
	}

	
	
	public static void main(String[] args) throws IOException 
	{
		int n,i;
		char[] srcstr=new char[100];
		char[] miwen;
		String go;

		System.out.print("换位加密解密算法演示！\n");
		
		do{
		System.out.print("\n请先输入换位加密矩阵每行的字符数：");
		Scanner input=new Scanner(System.in);
	    n=input.nextInt();						//输入换位加密矩阵每行的字符数

	    System.out.println("请输入明文：");
								//输入明文字符串
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str=bufferedReader.readLine();
		srcstr=str.toCharArray();
		         
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
