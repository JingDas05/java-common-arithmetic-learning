package top.treegrowth.common.p6;

import java.util.Scanner;


public class P6_19 {
	static long fact(int n)								//��׳˺���
	{
	    if(n<=1)
	        return 1;
	    else
	        return n*fact(n-1);			//�ݹ�
	}
	public static void main(String[] args) {
int i;									//��������
		
	    System.out.print("������Ҫ��׳˵�һ��������"); 
	    Scanner input=new Scanner(System.in);
	    i=input.nextInt();							//��������
	    System.out.println(i+"�Ľ׳˽��Ϊ��"+fact(i)); 		//���ú���

	}

}
