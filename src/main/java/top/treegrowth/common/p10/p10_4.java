package top.treegrowth.common.p10;

import java.util.Scanner;


public class p10_4 {
	static int peach(int n) 					//猴子吃桃算法
	{
		int pe;
	    if(n==1)
		{
	        return 1;  					//第10天就只剩1个了
		}
	    else
		{
			pe=(peach(n-1)+1)*2; 		//前一天总比后1天多一半加1
		}
	    return pe; 
	}
	public static void main(String[] args) 
	{
		int n; 						//天数 
	    int peachnum; 				//最初桃子数 

	    System.out.printf("猴子吃桃问题求解！\n");
		System.out.printf("输入天数:");
	    Scanner input=new Scanner(System.in);
		n=input.nextInt(); 
		
	    peachnum=peach(n);				//求解
	    System.out.printf("最初的桃子数为:%d个。\n",peachnum);

	}

}
