package top.treegrowth.common.p9;

import java.util.Scanner;


public class P9_6 {
	static int gcd(int a, int b) 			//最大公约数 
	{
	    int m,n;

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
	   if(n==0)				//若较小数为0 
	   {
	       return m; 			//返回另一数为最大公约数 
	   }
	   if(m%2==0 && n%2 ==0)	//m和n都是偶数 
	   {
	       return 2*gcd(m/2,n/2); 	//递归调用gcd函数，将m、n都除以2 
	   }
	   if ( m%2 == 0)			//m为偶数 
	   {
	       return gcd(m/2,n); 	//递归调用gcd函数，将m除以2 
	   }
	   if ( n%2==0 )			//n为偶数 
	   {
	       return gcd(m,n/2);		//递归调用gcd函数，将n除以2
	   }
	   return gcd((m+n)/2,(m-n)/2);//m、n都是奇数，递归调用gcd
	}

	static int lcm(int a,int b) 			//最小公倍数 
	{
	    int c,d;

		c= gcd(a,b); 			//获取最大公约数
		d=(a*b)/c;
	    return d; 				//返回最小公倍数 
	}
	public static void main(String[] args) {
		int a,b,c,d;
	    System.out.printf("输入两个正整数:");
	    Scanner input=new Scanner(System.in);
	    a=input.nextInt();
	    b=input.nextInt();	//输入整数
		c=gcd(a,b);			//最大公约数
	    System.out.printf("%d和%d的最大公约数:%d\n",a,b,c);
		d=lcm(a,b);			//最小公倍数
	    System.out.printf("%d和%d的最小公倍数:%d\n",a,b,d);
	}

}
