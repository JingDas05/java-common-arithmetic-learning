package top.treegrowth.common.p9;

public class P9_7 {
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
	    return 1;       			//是素数 
	}
	public static void main(String[] args) {
		int i,n,count;

		n=1000;				//范围
		count=0;
		System.out.printf("列举1~1000之间所有的素数：\n");
		for(i=1;i<1000;i++)
		{
			if(isPrime(i)==1)	//如果是素数
			{
				System.out.printf("%7d",i);
				count++;
				if(count%10==0)//10个一行
				{
					System.out.printf("\n");
				}
			}
		}
		System.out.printf("\n");

	}

}
