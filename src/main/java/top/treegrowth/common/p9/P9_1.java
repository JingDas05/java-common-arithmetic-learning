package top.treegrowth.common.p9;

public class P9_1 {
	static void Perfectnum(long fanwei)		//计算完全数算法
	{
	    long[] p=new long[300]; 				//保存分解的因子 
		long i,j,sum,num;
		int k,count;

		for(i=1;i<fanwei;i++)			//循环处理每1个数
		{
			count=0;
			num=i;
			sum=num;
			for(j=1;j<num;j++)		//循环处理每1个数
			{
				if(num % j==0)
				{
					p[count++]=j;	//保存因子，计数器count增加1
					sum=sum-j;	//减去一个因子
				}
			}
			if(sum==0)
			{
	            System.out.printf("%4d是一个完全数,因子是",num);
	            System.out.printf("%d=%d",num,p[0]); 	//输出完数
	            for(k=1;k<count;k++) 		//输出因子
				{
	                System.out.printf("+%d",p[k]);
				}
	            System.out.printf("\n");
			}
		}
	}
	public static void main(String[] args) {
		long fanwei;

		fanwei=10000;					//初始化范围
		System.out.printf("查找%d之内的完全数：\n",fanwei);
		Perfectnum(fanwei);				//查找完全数

	}

}
