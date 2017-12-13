package top.treegrowth.common.p12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class P12_1 {
	static char[] jiami(char[] str,int n)					//�����㷨
	{    
	    int i,j,k,d;
		int len;
	    char[] temp,miwen,mtemp={};

	    len=str.length;						//�ַ�������
	    if((d=len%n)!=0) 
		{
			len=len+n-d;
		}

	    if((temp=new char[len+1])==null)	//�����ڴ�	
	    {
	        System.out.print("�����ڴ�ʧ��!\n");
	        System.exit(1);
	    }    

	    if((miwen=new char[len+1])==null)	//�����ڴ�	
	    {
	        System.out.print("�����ڴ�ʧ��!\n");
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
	    for(k=0;k<n;k++)					//ת��������
	    {
	        for(j=0;j<len/n;j++)
			{
	           mtemp[i]=temp[k+j*n];           
	           i++;
	        }           
	    }
	    mtemp[i]='\0';
	    temp=null;
  
	    return miwen;						//��������
	}

	static char[] jiemi(char[] str,int n)					//�����㷨
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
	    if((temp=new char[len+1])==null)	//�����ڴ�	
	    {
	        System.out.print("�����ڴ�ʧ��!\n");
	        System.exit(1);
	    }    

	    if((mingwen=new char[len+1])==null)	//�����ڴ�	
	    {
	        System.out.print("�����ڴ�ʧ��!\n");
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
	    for(k=0;k<n;k++)					//�ָ�������
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
	    return mingwen;						//��������
	}

	
	
	public static void main(String[] args) throws IOException 
	{
		int n,i;
		char[] srcstr=new char[100];
		char[] miwen;
		String go;

		System.out.print("��λ���ܽ����㷨��ʾ��\n");
		
		do{
		System.out.print("\n�������뻻λ���ܾ���ÿ�е��ַ�����");
		Scanner input=new Scanner(System.in);
	    n=input.nextInt();						//���뻻λ���ܾ���ÿ�е��ַ���

	    System.out.println("���������ģ�");
								//���������ַ���
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str=bufferedReader.readLine();
		srcstr=str.toCharArray();
		         
		System.out.print("���������Ϊ��");
		for(i=0;i<srcstr.length;i++)
		{
		  	System.out.print(srcstr[i]);
		}
			
		miwen=jiami(srcstr,n);				//����
		System.out.print("\n���ܺ������Ϊ��");
		for(i=0;i<srcstr.length;i++)
		{
		   	System.out.print(miwen[i]);
		}
		miwen=jiemi(miwen,n);				//����
		System.out.print("\n���ܳ�������Ϊ��");
		for(i=0;i<srcstr.length;i++)
		{
		  	System.out.print(miwen[i]);
		}
		
		System.out.print("\n����ִ��(y/n)?");
		go=input.next();
		}while(go.equalsIgnoreCase("y"));
		System.out.println("��ʾ������");
	}
}
