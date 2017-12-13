package top.treegrowth.common.p12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class P12_3 {
	static char[] bitcode(char[] str,char n)				//λ���ܽ����㷨
	{
	    int i,len;
	    char[] wen;

	    len=str.length;
	    if((wen=new char[len+1])==null)
	    {
	        System.out.print("�����ڴ�ʧ��!\n");
	        System.exit(1);
	    }
	    for(i=0;i<len;i++)
	    {
			wen[i]=(char)(str[i]^n);					//�������
	    }
	    wen[len]='\0';
	    return wen;
	}
	public static void main(String[] args) throws IOException {
		int i;
		char ch;
		char[] srcstr=new char[100];
		char[] miwen;
		String go;

		System.out.print("λ���ܽ����㷨��ʾ��\n");
		
		do{
		System.out.print("\n���������滻���ܽ����㷨�е���Կ��");
		Scanner input=new Scanner(System.in);
		ch=input.next().charAt(0);						//��Կ
		System.out.print("�����������ַ�����");
			
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str=bufferedReader.readLine();
		srcstr=str.toCharArray();				//�����ַ���
		
		System.out.print("���������Ϊ��");
		for(i=0;i<srcstr.length;i++)
		{
		  	System.out.print(srcstr[i]);
		}
				
		miwen=bitcode(srcstr,ch);				//����
		System.out.print("\n���ܺ������Ϊ��");
		for(i=0;i<srcstr.length;i++)
		{
		   	System.out.print(miwen[i]);
		}
		miwen=bitcode(miwen,ch);				//����
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
