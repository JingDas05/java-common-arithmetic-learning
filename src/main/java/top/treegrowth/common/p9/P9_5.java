package top.treegrowth.common.p9;

import java.util.Scanner;


public class P9_5 {
	static int gcd(int a, int b) 			//最大公约数 
	{
	    int m,n,r;
		if(a>b)				//m保存较大数,n保存较小数
		{
			m=a;
			n=b;
		}
		else
		{
			m=b;
			n=a;
		}
	    r=m%n; 				//求余数 
	    while(r!=0) 			//辗转相除 
	    {
	        m=n;
	        n=r;
	        r=m%n;
	    }
	    return n; 				//返回最大公约数 
	}
	public static void main(String[] args) {
		int a,b,c;
		
	    System.out.printf("输入两个正整数:");
	    Scanner input=new Scanner(System.in);
	    a=input.nextInt();
	    b=input.nextInt();	//输入数据
		c=gcd(a,b);
	    System.out.printf("%d和%d的最大公约数:%d\n",a,b,gcd(a,b));

	}

}
