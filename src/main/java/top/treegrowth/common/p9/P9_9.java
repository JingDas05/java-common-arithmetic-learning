package top.treegrowth.common.p9;

public class P9_9 {
	static int pingfanghuiwen(int a)				//算法
	{
		int temp,m,k,t,num,sum;
		int count,i,n;

		n=a*a;
		k=1;
		count=0;
		while(k>0)						//判断位数
		{
			k=n-(int)Math.pow(10,count);
			count++;
		}
		m=count-1;					//位数

		sum=0;
		num=n;
		for(i=0;i<m;i++)					//按位处理，交换高低位
		{
			temp=num%10;
			sum=sum+temp*((int)Math.pow(10,m-1-i));
			num=(num-temp)/10;
		}
		t=sum;
		if(t==n)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public static void main(String[] args) {
		int i;

		System.out.printf("列举平方回文素数\n");
		for(i=10;i<1000;i++)
		{
			if(pingfanghuiwen(i)==1)		//列举平方回文数
			{
				System.out.printf("%d*%d=%d\n",i,i,i*i);
			}
		}

	}

}
