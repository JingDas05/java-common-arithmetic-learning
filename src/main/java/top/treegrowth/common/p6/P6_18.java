package top.treegrowth.common.p6;

import java.util.Scanner;


public class P6_18 {
	static long fact(int n)								//��׳˺���
	{
		int i;
		long result=1;

		for(i=1;i<=n;i++)						//ѭ������
		{
			result*=i;
		}
		return result;
	}
	public static void main(String[] args) {
		int i;									//��������
		
	    System.out.print("������Ҫ��׳˵�һ��������"); 
	    Scanner input=new Scanner(System.in);
	    i=input.nextInt();							//��������
	    System.out.println(i+"�Ľ׳˽��Ϊ��"+fact(i)); 		//���ú���

	}

}
