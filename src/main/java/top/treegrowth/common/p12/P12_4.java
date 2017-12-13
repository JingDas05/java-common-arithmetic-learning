package top.treegrowth.common.p12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;


public class P12_4 {
	static int MAX=100;
	static char[] key=new char[MAX];							//用于保存密钥
	static int len;
	static char[] bitcode(char[] str)					//一次一密加密算法
	{
	    int i;
	    char[] wen;

	    if((wen=new char[len+1])==null)
	    {
	        System.out.printf("申请内存失败!\n");
	        System.exit(1);
	    }
	    for(i=0;i<len;i++)
	    {
			wen[i]=(char)(str[i]^key[i]);				//异或运算
	    }
	    wen[len]='\0';
	    return wen;
	}

	public static void main(String[] args) throws IOException {
		int i;
		char[] srcstr=new char[MAX];
	    char[] miwen,mingwen;
		String go;
		Scanner input=new Scanner(System.in);
//		srand(time(NULL));					//随机种子
		System.out.printf("一次一密加密解密算法演示！\n");
		
		do{
		System.out.printf("请输入明文字符串：");

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str=bufferedReader.readLine();
   
       srcstr=str.toCharArray();
							//明文信息
       Random r=new Random(); 			        //随机种子
		len=srcstr.length;
		for(i=0;i<len;i++)
		{
			key[i]=(char)(r.nextInt(10)+'0');			//产生密钥序列
		}
		System.out.printf("此次加密解密演示的密钥序列为：");
		for(i=0;i<len;i++)
		{
			System.out.printf("%c",key[i]);
		}
//		System.out.printf("\n");
	    miwen=bitcode(srcstr);				//加密
	    System.out.printf("\n输入的明文为：");
	    for(i=0;i<srcstr.length;i++)
	    	System.out.print(srcstr[i]);
	    System.out.printf("\n加密后的密文为：");
	    for(i=0;i<miwen.length;i++)
	    	System.out.print(miwen[i]);
	    mingwen=bitcode(miwen);				//解密
	    System.out.printf("\n解密出的明文为：");
	    for(i=0;i<mingwen.length;i++)
	    	System.out.print(mingwen[i]);
	    
	    System.out.print("\n\n继续执行(y/n)?");
	    
		go=input.next();
		}while(go.equalsIgnoreCase("y"));
		System.out.println("演示结束！");


	}

}
