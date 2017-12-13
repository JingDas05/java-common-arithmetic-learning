package top.treegrowth.common.p12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class P12_2 {
	static char[] jiami(char[] str,int n)					//�����㷨
	{
	    int i,len;
	    char[] miwen;

	    len=str.length;
	    if((miwen=new char[len+1])==null)	//�����ڴ�
	    {
	        System.out.print("�����ڴ�ʧ��!\n");
	        System.exit(1);
	    }
	    for(i=0;i<len;i++)						//��λ�滻
	    {
			miwen[i]=(char)(str[i]+n);
	    }
	    miwen[len]='\0';
	    return miwen;
	}
	
	static char[] jiemi(char[] str,int n)					//�����㷨
	{
	    int i,len;
	    char[] mingwen;

	    len=str.length;
	    if((mingwen=new char[len+1])==null)//�����ڴ�
	    {
	        System.out.print("�����ڴ�ʧ��!\n");
	        System.exit(1);
	    }
	    for(i=0;i<len;i++)						//��λ�滻
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

		System.out.print("�滻���ܽ����㷨��ʾ��\n");
		
		do{
		System.out.print("\n���������滻���ܽ����㷨�е���Կ��");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();						//��Կ
		System.out.print("�����������ַ�����");
			
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str=bufferedReader.readLine();
		srcstr=str.toCharArray();				//�����ַ���
		
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
