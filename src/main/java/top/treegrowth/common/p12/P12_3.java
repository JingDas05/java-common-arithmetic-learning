package top.treegrowth.common.p12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class P12_3 {
	static char[] bitcode(char[] str,char n)				//位加密解密算法
	{
	    int i,len;
	    char[] wen;

	    len=str.length;
	    if((wen=new char[len+1])==null)
	    {
	        System.out.print("申请内存失败!\n");
	        System.exit(1);
	    }
	    for(i=0;i<len;i++)
	    {
			wen[i]=(char)(str[i]^n);					//异或运算
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

		System.out.print("位加密解密算法演示！\n");
		
		do{
		System.out.print("\n请先输入替换加密解密算法中的密钥：");
		Scanner input=new Scanner(System.in);
		ch=input.next().charAt(0);						//密钥
		System.out.print("请输入明文字符串：");
			
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str=bufferedReader.readLine();
		srcstr=str.toCharArray();				//明文字符串
		
		System.out.print("输入的明文为：");
		for(i=0;i<srcstr.length;i++)
		{
		  	System.out.print(srcstr[i]);
		}
				
		miwen=bitcode(srcstr,ch);				//加密
		System.out.print("\n加密后的密文为：");
		for(i=0;i<srcstr.length;i++)
		{
		   	System.out.print(miwen[i]);
		}
		miwen=bitcode(miwen,ch);				//解密
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
