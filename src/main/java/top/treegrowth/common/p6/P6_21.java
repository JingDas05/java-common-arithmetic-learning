package top.treegrowth.common.p6;

import java.util.Random;
import java.util.Scanner;


public class P6_21 {
	static double montePI(int n) 				//蒙特卡罗算法
	{
		int i,sum;
		double PI;
	    double x,y;
		sum=0;

		Random r=new Random();    
	    for(i=1;i<n;i++)
	    {
	        x=r.nextDouble();	//产生0~1之间的一个随机数 
	        y=r.nextDouble();	//产生0~1之间的一个随机数 
	        if((x*x+y*y)<=1)				//若在阴影区域 
	            sum++;				//计数 
	    }
		PI=4.0*sum/n;					//计算PI
		return PI;
	}
	public static void main(String[] args) {
		int n; 
		double PI;

	    System.out.print("输入点的数量:");
	    Scanner input=new Scanner(System.in);
	    n=input.nextInt(); 				//输入撒点个数
	    PI=montePI(n);					//计算PI
	    System.out.println("PI="+PI); 				//输出结果 

	}

}
