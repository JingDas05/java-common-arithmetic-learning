package top.treegrowth.common.p9;

public class P9_8 {
	static int isPrime(int a)			//素数算法
	{  
	    int i;
	    for(i=2;i<a;i++)
		{
			if(a % i == 0)
			{
				return 0;      //不是素数 
			}
		}
	    return 1;      			//是素数 
	}

	static int huiwen(int n)			//回文素数算法
	{
		int temp,m,k,t,num,sum;
		int count,i;

		k=1;
		count=0;
		while(k>0)				//判断位数
		{
			k=n-(int)Math.pow(10,count);
			count++;
		}
		m=count-1;			//位数

		sum=0;
		num=n;
		for(i=0;i<m;i++)			//按位处理，交换高低位
		{
			temp=num%10;
			sum=sum+temp*((int)Math.pow(10,m-1-i));
			num=(num-temp)/10;
		}
		t=sum;
		if(t==n)
		{
			if(isPrime(n)==1)
			{
				return 1;		//是回文素数
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
	}
	public static void main(String[] args) {
		int i,count;

		count=0;
		System.out.printf("列举0~50000之间的回文素数\n");
		for(i=10;i<50000;i++)		//列举回文素数
		{
			if(huiwen(i)==1)
			{
				System.out.printf("%7d",i);
				count++;
				if(count%10==0)//10个为一行
				{
					System.out.printf("\n");
				}
			}
		}
		System.out.printf("\n");

	}

}
