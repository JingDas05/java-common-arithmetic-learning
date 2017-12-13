package top.treegrowth.common.p3;

import java.util.Scanner;

public class P3_5 {
	static double MontePI(int n) 				//蒙特卡罗算法
	{
		double PI;
	    double x,y;
		int i,sum;
		sum=0;
	    for(i=1;i<n;i++)
	    {
	        x=Math.random();	//产生0~1之间的一个随机数 
	        y=Math.random();	//产生0~1之间的一个随机数 
	        if((x*x+y*y)<=1)				//若在阴影区域 
	            sum++;				//计数 
	    }
		PI=4.0*sum/n;					//计算PI
		return PI;
	}
	public static void main(String[] args) {
		int n; 
		double PI;
		System.out.println("蒙特卡罗概率算法计算π:");
		Scanner input=new Scanner(System.in);
		System.out.print("输入点的数量:");
	    n=input.nextInt(); 				//输入撒点个数
	    PI=MontePI(n);					//计算PI
	    System.out.println("PI="+PI); 				//输出结果 
	}
}
