package top.treegrowth.common.p9;

import java.util.Scanner;


public class P9_10 {
	static int isPrime(int a)			//判断素数算法
	{  
	    int i;
	    for(i=2;i<a;i++)
		{
			if(a % i == 0)
			{
				return 0;      //不是质数 
			}
		}
	    return 1;      			//是质数 
	}

	static void PrimeFactor(int n)		//分解质因数算法
	{ 
	    int i;
	    if(isPrime(n)==1)  
		{
			System.out.printf("%d*",n);
		}
	    else
	    {
	        for(i=2;i<n;i++)
			{
	            if(n % i == 0)
	            {
	                 System.out.printf("%d*",i); 	//第一个因数一定是质因数 
	                 if(isPrime(n/i)==1) 
					 {			//判断第二个因数是否是质数 
	                     System.out.printf("%d",n/i);
	                     break; 		//找到全部质因子 
	                 }
	                else
					{
	                    PrimeFactor(n/i);//递归地调用PrimeFactor 分解n/i 
					}
	            break;
	            }
			}
	    }
	}
	public static void main(String[] args) {
		int n;
	    System.out.printf("请首先输入一个数n：\n")  ;
	    Scanner input=new Scanner(System.in);
	    n=input.nextInt();
	    System.out.printf("n=%d=",n);
	    PrimeFactor(n);   			//对n分解质因数 

	}

}
