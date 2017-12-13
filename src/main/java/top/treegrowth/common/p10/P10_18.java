package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_18 {
	static void threeball(int red,int yellow,int green,int n)		//算法
	{
		int i,j,k;

		System.out.printf("总共有如下几种可能!\n");
		System.out.printf("\t红球\t黄球\t绿球\n");
		for(i=0;i<=3;i++)         					//红色球
		{
			for(j=0;j<=3;j++)   					//黄色球
			{
				for(k=0;k<=6;k++)				//绿色球
				{
					if(i+j+k== n)				//判断是否符合
					{
						System.out.printf("\t%d\t%d\t%d\n",i,j,k);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int red,yellow,green;
		int n;

		System.out.printf("三色球问题求解！\n");
		System.out.printf("请先输入红球的数量为:");
		Scanner input=new Scanner(System.in);
		red=input.nextInt();						//红球的数量
		System.out.printf("请先输入黄球的数量为:");
		yellow=input.nextInt();						//黄球的数量
		System.out.printf("请先输入绿球的数量为:");
		green=input.nextInt();						//绿球的数量
		System.out.printf("请先输入取出球的数量为:");
		n=input.nextInt();							//取出球的数量

		threeball(red,yellow,green,n);				//求解

	}

}
