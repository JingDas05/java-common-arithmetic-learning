package top.treegrowth.common.p10;

import java.util.Scanner;


public class p10_15 
{
	static int Fibonacci(int n)							//兔子产仔算法
	{ 
		int t1,t2;

	    if (n==1 || n==2) 
		{
			return 1;
		}
	    else
		{
			t1=Fibonacci(n-1);				//递归调用
			t2=Fibonacci(n-2);
			return t1+t2;  
		}
	}
	public static void main(String[] args) 
	{
		int n,num;
		
		System.out.printf("兔子产仔问题求解！\n");
		System.out.printf("请先时间：");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();						//时间
		num=Fibonacci(n);					//求解
	    System.out.printf("经过%d月的时间，共能繁殖成%d对兔子！\n",n,num);

	}

}
