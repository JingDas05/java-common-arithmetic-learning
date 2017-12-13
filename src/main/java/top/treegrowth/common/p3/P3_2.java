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
		System.out.println("递推算法求解兔子产仔问题！");
		System.out.print("请先输入时间：");
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();						//时间
		int num=fibonacci(n);					//求解
	    System.out.println("经过"+n+"月的时间，共能繁殖成"+num+"对兔子！");
	}
}
