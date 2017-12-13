package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_5 {
	static double mai(int n)					//舍罕王赏麦算法
	{
		int i;
		double temp,sum;

		temp=1;
		sum=0;						//总合

		for(i=1;i<=n;i++)				//计算等比级数的和
	    {
	        temp=temp*2;
	        sum=sum+temp;
	    }
		return sum;
	}
	public static void main(String[] args) {
		int n;
		double sum;

		System.out.printf("舍罕王赏麦问题求解！\n");
		System.out.printf("输入棋盘格总数:");
	    Scanner input=new Scanner(System.in);
		n=input.nextInt(); 
		sum=mai(n);					//求解
	    System.out.printf("舍罕王赏总麦粒数为:%f粒。\n",sum);
	    System.out.printf("共:%.2f吨。\n",sum/25000/1000);

	}

}
