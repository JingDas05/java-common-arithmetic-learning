package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_3 {
	static long fact(int n)					//��׳˺���
	{
	    if(n<=1)
	        return 1;
	    else
	        return n*fact(n-1);			   //�ݹ�
	}
	public static void main(String[] args) {
		 int i;									//��������
         System.out.print("������Ҫ��׳˵�һ��������"); 
		 Scanner input=new Scanner(System.in);				
		 i=input.nextInt();                              //��������
		 System.out.print(i+"�Ľ׳˽��Ϊ��"+fact(i)); 	//���ú���
	}
}
