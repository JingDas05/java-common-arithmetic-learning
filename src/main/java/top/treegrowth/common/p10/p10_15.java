package top.treegrowth.common.p10;

import java.util.Scanner;


public class p10_15 
{
	static int Fibonacci(int n)							//���Ӳ����㷨
	{ 
		int t1,t2;

	    if (n==1 || n==2) 
		{
			return 1;
		}
	    else
		{
			t1=Fibonacci(n-1);				//�ݹ����
			t2=Fibonacci(n-2);
			return t1+t2;  
		}
	}
	public static void main(String[] args) 
	{
		int n,num;
		
		System.out.printf("���Ӳ���������⣡\n");
		System.out.printf("����ʱ�䣺");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();						//ʱ��
		num=Fibonacci(n);					//���
	    System.out.printf("����%d�µ�ʱ�䣬���ܷ�ֳ��%d�����ӣ�\n",n,num);

	}

}
