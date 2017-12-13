package top.treegrowth.common.p6;

import java.util.Scanner;


public class P6_20 {
	static void cyclotomic(int n)			//割圆术算法
	{
		int i,s;
		double k,len;
		i=0;
		k=3.0;					//初值
		len=1.0;					//边长初值
		s=6;						//初始内接正6边形

		while(i<=n)
	    {
	        System.out.printf("第%2d次切割,为正%5d边形,PI=%.24f\n",i,s,k*Math.sqrt(len));
	        s*=2;					//边数加倍 
	        len=2-Math.sqrt(4-len); 		//内接多边形的边长 
	        i++;
	        k*=2.0;        
	    } 
	}
	public static void main(String[] args) {
		int n;
	    System.out.print("输入切割次数:");
	    Scanner input=new Scanner(System.in);
	    n=input.nextInt(); 			//输入切割次数
		cyclotomic(n);				//计算每次切割的圆周率

	}

}
