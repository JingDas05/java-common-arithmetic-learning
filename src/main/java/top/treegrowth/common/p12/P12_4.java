package top.treegrowth.common.p12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;


public class P12_4 {
	static int MAX=100;
	static char[] key=new char[MAX];							//���ڱ�����Կ
	static int len;
	static char[] bitcode(char[] str)					//һ��һ�ܼ����㷨
	{
	    int i;
	    char[] wen;

	    if((wen=new char[len+1])==null)
	    {
	        System.out.printf("�����ڴ�ʧ��!\n");
	        System.exit(1);
	    }
	    for(i=0;i<len;i++)
	    {
			wen[i]=(char)(str[i]^key[i]);				//�������
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
//		srand(time(NULL));					//�������
		System.out.printf("һ��һ�ܼ��ܽ����㷨��ʾ��\n");
		
		do{
		System.out.printf("�����������ַ�����");

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str=bufferedReader.readLine();
   
       srcstr=str.toCharArray();
							//������Ϣ
       Random r=new Random(); 			        //�������
		len=srcstr.length;
		for(i=0;i<len;i++)
		{
			key[i]=(char)(r.nextInt(10)+'0');			//������Կ����
		}
		System.out.printf("�˴μ��ܽ�����ʾ����Կ����Ϊ��");
		for(i=0;i<len;i++)
		{
			System.out.printf("%c",key[i]);
		}
//		System.out.printf("\n");
	    miwen=bitcode(srcstr);				//����
	    System.out.printf("\n���������Ϊ��");
	    for(i=0;i<srcstr.length;i++)
	    	System.out.print(srcstr[i]);
	    System.out.printf("\n���ܺ������Ϊ��");
	    for(i=0;i<miwen.length;i++)
	    	System.out.print(miwen[i]);
	    mingwen=bitcode(miwen);				//����
	    System.out.printf("\n���ܳ�������Ϊ��");
	    for(i=0;i<mingwen.length;i++)
	    	System.out.print(mingwen[i]);
	    
	    System.out.print("\n\n����ִ��(y/n)?");
	    
		go=input.next();
		}while(go.equalsIgnoreCase("y"));
		System.out.println("��ʾ������");


	}

}
