package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_13 
{
	static int fish(int yufu)								//渔父捕鱼算法
	{
		int init;
		int n;
		int s;

		init=yufu+1;
		n=yufu-1;
	   s = init;
	   while(n!=0)
	   {
	        s=5*s+1;							//递推
	        n--;
	   }
	   return s;
	}
	public static void main(String[] args) 
	{
		int num;
		int yufu;

		System.out.printf("渔父捕鱼问题求解！\n");
		System.out.printf("请先输入渔父的个数：");
		Scanner input=new Scanner(System.in);
		yufu=input.nextInt();						//渔父个数
		num=fish(yufu);							//求解
	    System.out.printf("渔夫至少合伙捕了%d条鱼！\n",num);

	}

}
