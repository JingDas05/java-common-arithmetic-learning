package top.treegrowth.common.p10;

import java.util.Scanner;


public class P10_6 {
	static long count; 						//移动的次数 

	static void hanoi(int n,char a,char b,char c) 	//汉诺塔算法 
	{
	    if(n==1)
	    {        
	       System.out.printf("第%d次移动:\t圆盘从%c棒移动到%c棒\n",++count,a,c);
	    }
	    else
	    {
	        hanoi(n-1,a,c,b); 			//递归调用
	        System.out.printf("第%d次移动:\t圆盘从%c棒移动到%c棒\n",++count,a,c);
	        hanoi(n-1,b,a,c); 			//递归调用
	    }
	}
	public static void main(String[] args) {
		int n; 						//圆盘数量 

	    count=0;
	    System.out.printf("汉诺塔问题求解！\n");
	    System.out.printf("请输入汉诺塔圆盘的数量:");
	    Scanner input=new Scanner(System.in);
	    n=input.nextInt();
	    hanoi(n,'A','B','C');    			//求解
	    System.out.printf("求解完毕！总共需要%d步移动！\n",count);

	}

}
