package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_2 {
	public static int fibonacci(int n)
	{
		int t1,t2;
		if(n==1 || n==2)
		{
			return 1;
		}
		else
		{
			t1=fibonacci(n-1);
			t2=fibonacci(n-2);
			return t1+t2;
		}
	}
	public static void main(String[] args) {
		System.out.println("�����㷨������Ӳ������⣡");
		System.out.print("��������ʱ�䣺");
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();						//ʱ��
		int num=fibonacci(n);					//���
	    System.out.println("����"+n+"�µ�ʱ�䣬���ܷ�ֳ��"+num+"�����ӣ�");
	}
}
