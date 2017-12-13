package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_3 
{
	static void JTTL(int head,int foot,int[] tu,int[] ji)
	{
	    tu[0]=(foot-2*head)/2; 				//兔子的数量
	    ji[0]=head-tu[0];  					//鸡的数量
	}
	public static void main(String[] args) 
	{
		int[] ji={0},tu={0};
		int head,foot;

	    System.out.printf("鸡兔同笼问题求解!\n");
		System.out.printf("输入头数:");
	    Scanner input=new Scanner(System.in);
		head=input.nextInt();				//输入头数
	    System.out.printf("输入脚数:");
	    foot=input.nextInt();				//输入脚数
	    
		JTTL(head,foot,tu,ji);
		
	    System.out.printf("鸡有:%d只,兔子有:%d只。\n",ji[0],tu[0]);

	}
}
